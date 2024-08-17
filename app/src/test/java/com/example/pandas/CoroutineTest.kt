package com.example.pandas

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import org.junit.Test
import kotlin.system.measureTimeMillis

/**
 * @description: CoroutineTest
 * @author: dongyiming
 * @date: 7/26/23 5:46 PM
 * @version: v1.0
 */
public class CoroutineTest {

    //runBlocking把主线程包装成一个协程
    @Test
    fun `test coroutine builder`() = runBlocking {

        val job1 = launch {
            delay(300)
            println("job1 finished")
        }
        val job2 = async {
            delay(200)
            println("job2 finished")
            "job2 result"
        }
        println(job2.await())
    }

    @Test
    fun `test coroutine join`() = runBlocking {

        val job1 = launch {
            delay(10000)
            println("job1 finished")
        }
        job1.join()
        val job2 = launch {
            delay(300)
            println("job2 finished")
        }
        val job3 = launch {
            delay(200)
            println("job3 finished")
        }
    }

    @Test
    fun `test coroutine await`() = runBlocking {

        val job1 = async {
            delay(2000)
            println("job1 finished")
        }
        job1.await()
        val job2 = async {
            delay(300)
            println("job2 finished")
        }
        val job3 = async {
            delay(200)
            println("job3 finished")
        }
    }

    @Test
    fun `test sync add`() = runBlocking {

        val time = measureTimeMillis {
            val one = doOne()
            val two = doTwo()
            println("The result:${one + two}")
        }
        println("cost time: $time ms")
    }

    @Test
    fun `test combine async`() = runBlocking {

        val time = measureTimeMillis {
            val one = async { doOne() }.await()
            val two = async { doTwo() }.await()
            println("The result:${one + two}")
        }
        println("cost time: $time ms")
    }

    private suspend fun doOne(): Int {
        delay(1000)
        return 14
    }

    private suspend fun doTwo(): Int {
        delay(2000)
        return 7
    }

    @Test
    fun `test start mode`() = runBlocking {

        val job = async(context = Dispatchers.IO, start = CoroutineStart.UNDISPATCHED) {
            println("thread1:${Thread.currentThread().name}")
            delay(1000)
            println("thread2:${Thread.currentThread().name}")
        }
    }

    @Test
    fun `test supervisorScope`() = runBlocking {
        coroutineScope {
            val job1 = async {
                delay(400)
                println("job1 finished.")
            }
            val job2 = async {
                delay(200)
                println("job2 finished.")
                throw IllegalStateException()
            }
        }
    }

    @Test
    fun `test scope cancel`() = runBlocking<Unit> {
        val scope = CoroutineScope(Dispatchers.Default)
        val job1 = scope.launch {
            delay(1000)
            println("job1 finished.")
        }
        val job2 = scope.launch {
            delay(1000)
            println("job2 finished.")
        }
        delay(100)
        job1.cancel()
        delay(2000)
    }

    @Test
    fun `test cancel exception`() = runBlocking<Unit> {
        val job1 = GlobalScope.launch {
            try {
                delay(1000)
            } catch (exception: CancellationException) {
                exception.printStackTrace()
            }
            println("job1 finished.")
        }
        delay(100)
        job1.cancel(CancellationException("我取消啦！！！"))
        job1.join()
    }

    @Test
    fun `test cancel cpu task by isActive`() = runBlocking<Unit> {

        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nexTime = startTime
            var i = 0
            while (i < 5) {//调用了cancel后，isActive = false
                ensureActive()
                if (System.currentTimeMillis() > nexTime) {
                    println("job: I'm sleeping ${i++}...")
                    nexTime += 500
                }
            }
        }
        delay(1300)
        println("main: I'm tiread of waiting")
        job.cancelAndJoin()
        println("main: Now I can quit")
    }

    @Test
    fun `test cancel cpu task by yield`() = runBlocking<Unit> {

        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nexTime = startTime
            var i = 0
            while (i < 5) {//调用了cancel后，isActive = false
                yield()
                if (System.currentTimeMillis() > nexTime) {
                    println("job: I'm sleeping ${i++}...")
                    nexTime += 500
                }
            }
        }
        delay(1300)
        println("main: I'm tiread of waiting")
        job.cancelAndJoin()
        println("main: Now I can quit")
    }

    @Test
    fun `test cancel with NonCancellable`() = runBlocking<Unit> {

        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i ...")
                    delay(500)
                }
            } catch (e: Exception) {
                withContext(NonCancellable) {
                    println("job: I'm running finally")
                    delay(1000)
                    println("job: delay for 1 seconds")
                }
            }
        }
        delay(1300)
        println("main: I'm tiread of waiting")
        job.cancelAndJoin()
        println("main: Now I can quit")
    }

    @Test
    fun `test deal with timeout`() = runBlocking<Unit> {
        val result = withTimeoutOrNull(1300) {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500)
            }
            "Done"
        } ?: "Jack"
        println("Result is $result")
    }

    @Test
    fun `test corutinecontext`() = runBlocking<Unit> {
        val job = launch(Job() + Dispatchers.IO + CoroutineName("my_test")) {
            println("current thread:${Thread.currentThread().name}")
        }
        job.join()
    }

    @Test
    fun `test coroutine extends`() = runBlocking<Unit> {
        val scope = CoroutineScope(Job() + Dispatchers.IO + CoroutineName("my_test"))
        val job = scope.launch {
            println("${coroutineContext.job} ${Thread.currentThread().name}")
            val result = withContext(Dispatchers.Default) {
                println("${coroutineContext.job} ${Thread.currentThread().name}")
                "Ok"
            }
        }
        job.join()
    }

    @Test
    fun `test coroutine exception`() = runBlocking<Unit> {

        val job1 = GlobalScope.launch {
            try {
                throw IllegalArgumentException()
            } catch (e: Exception) {
                println("Caught IndexOutOfBoundsException")
            }
        }
        job1.join()

        val job2 = GlobalScope.async {
            throw NullPointerException()
        }

        try {
            job2.await()
        } catch (e: Exception) {
            println("Caught NullPointerException")
        }
    }

    @Test
    fun `test coroutine exception2`() = runBlocking<Unit> {

        val scope = CoroutineScope(Job())
        val job = scope.launch {
            async {
                throw IllegalArgumentException()
            }
        }
        job.join()
    }

    @Test
    fun `test supervisor job`() = runBlocking<Unit> {

        val scope = CoroutineScope(SupervisorJob())
        val job1 = scope.launch {
            delay(200)
            println("child 1")
            throw IllegalArgumentException()
        }

        val job2 = scope.launch {
            try {
                delay(Long.MAX_VALUE)
            } finally {
                println("child 2 finish.")
            }
        }
        delay(100)
        scope.cancel()
        joinAll(job1, job2)
    }

    @Test
    fun `test supervisorscope`() = runBlocking<Unit> {
        try {
            supervisorScope {
                val child = launch {
                    try {
                        println("The child is sleeping. ")
                        delay(Long.MAX_VALUE)
                    } finally {
                        println("The child is canceled. ")
                    }
                }
                yield()//使用yield来给我们的launch子作业一个机会来执行
                println("Throwing an exception from the scope")
                throw AssertionError()
            }
        } catch (e: AssertionError) {
            println("Caught an assertion error")
        }
    }

    @Test
    fun `test coroutinescope exception handler`() = runBlocking<Unit> {

        val handler = CoroutineExceptionHandler { _, throwable ->
            println("Caught $throwable")
        }

        val scope = CoroutineScope(Job())
        val job = scope.launch {
            launch(handler) {
                throw IllegalArgumentException()
            }
        }
        job.join()
    }

    @Test
    fun `test cancel and exception`() = runBlocking<Unit> {

        val handler = CoroutineExceptionHandler { _, throwable ->
            println("Caught $throwable")
        }

        val job = GlobalScope.launch(handler) {
            launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    withContext(NonCancellable) {
                        println("Childen are canceled, but exception is not handle until all children terminate")
                        delay(100)
                        println("The first child finished its non cancellable block")
                    }
                }
            }

            launch {
                delay(10)
                println("Second child throw an exception")
                throw ArithmeticException()
            }
        }
        job.join()
    }

    @Test
    fun `test cancel and exception2`() = runBlocking<Unit> {

        val job = launch {
            val child = launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    println("Child is canceled")
                }
            }
            yield()
            println("Cancelling child")
            child.cancelAndJoin()
            yield()
            println("Parent is not cancelled")
        }
        job.join()
    }

    @Test
    fun `test terminal operator`() = runBlocking {

        println("""close.trim""".trimMargin())
        val channel = Channel<Int>()
        val sum = (1..3).asFlow().map {
            it * it
        }.reduce { a, b ->
            println("a=$a,b=$b")
            a + b
        }
        println(sum)


    }
}