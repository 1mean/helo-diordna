package com.example.pandas

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.junit.Test
import kotlin.system.measureTimeMillis

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 7/29/23 4:11 PM
 * @version: v1.0
 */
public class FlowTest {

    private fun simleFlow() = flow<Int> {
        println("Flow started")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }

    @Test
    fun `test flow is cold`() = runBlocking<Unit> {
        val flow = simleFlow()
        println("Calling collect")
        flow.collect { value -> println(value) }
        println("Calling collect again...")
        flow.collect { value -> println(value) }
    }

    @Test
    fun `test flow1`() = runBlocking<Unit> {

        (1..5).asFlow().filter {
            it % 2 == 0
        }.map {
            "String $it"
        }.collect {
            println("Collect $it")
        }
    }

    @Test
    fun `test flowOf`() = runBlocking<Unit> {

        flowOf("one", "two", "three").onEach {
            delay(1000)
        }.collect {
            println(it)
        }
    }

    private fun flowSimle5() = flow<Int> {

        println("Flow started ${Thread.currentThread().name}")
        for (i in 1..3) {
            delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.Default)

    @Test
    fun `test flowOf2`() = runBlocking<Unit> {

        flowSimle5().collect { value -> println("Collected:$value ${Thread.currentThread().name}") }
    }

    fun events() = (1..3)
        .asFlow()
        .onEach { delay(100) }//包含发射
        .flowOn(Dispatchers.Default)

    @Test
    fun `test flow launch`() = runBlocking<Unit> {

        events()
            .onEach { event -> println("Event:$event ${Thread.currentThread().name}") }
            //.collect {  } //必须有末端操作符才能够使event开始发射
            .launchIn(this)
    }

    private fun flowSimle6() = flow<Int> {

        for (i in 1..3) {
            delay(1000)
            emit(i)
            println("Emitting $i")
        }
    }.flowOn(Dispatchers.Default)

    @Test
    fun `test cancle flow`() = runBlocking<Unit> {

        withTimeoutOrNull(2500) {
            flowSimle6().collect { value -> println("Collect $value") }
        }
        println("Done")
    }

    @Test
    fun `test cancle flow2`() = runBlocking<Unit> {

        (1..5).asFlow().cancellable().collect { value ->
            println("Collect: $value")
            if (value == 3) {
                cancel()
            }
        }
    }

    private fun flowSimle7() = flow<Int> {

        for (i in 1..3) {
            delay(100)
            emit(i)
            println("Emitting $i")
        }
    }


    @Test
    fun `test flow back pressure`() = runBlocking<Unit> {

        val time = measureTimeMillis {
            flowSimle7()
                //.conflate()
                //.flowOn(Dispatchers.Default)
                //.buffer(50)
                .collectLatest { value ->
                    delay(300)//处理这个元素需要消耗300ms
                    println("Collect $value")
                }
        }
        println("Collected in Time: $time")
    }

    private suspend fun performRequest(request: Int): String {

        delay(1000)
        return "request: $request"
    }

    @Test
    fun `test translate flow operator`() = runBlocking<Unit> {

        (1..3)
            .asFlow()
            .transform { request ->
                emit("Making request $request")
                emit(performRequest(request))
            }
            .collect { value -> println("Collect value:$value") }
    }

    private fun numbers() = flow<Int> {
        try {
            emit(1)
            emit(2)
            println("This line will not execute")
            emit(3)
        } finally {
            println("Finally in numbers")
        }
    }

    @Test
    fun `test limit list operator`() = runBlocking<Unit> {

        val sum = (1..5).asFlow().map { it * it }.reduce { a, b ->
            println("a=$a, b=$b")
            a + b
        }
        println("sum: $sum")
    }


    @Test
    fun `test zip operator`() = runBlocking<Unit> {

        val numbs = (1..3).asFlow().onEmpty { delay(300) }
        val strs = flowOf("one", "two", "three").onEach { delay(400) }
        val startTime = System.currentTimeMillis()
        numbs.zip(strs) { a, b -> "$a -> $b" }.collect {
            println("$it at ${System.currentTimeMillis() - startTime} ms from start") }
    }


}