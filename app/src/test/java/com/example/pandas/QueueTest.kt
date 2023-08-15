package com.example.pandas

import android.util.Log
import org.junit.Test
import java.util.*
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 8/7/23 8:02 PM
 * @version: v1.0
 */
public class QueueTest {

    @Test
    fun `test queue`() {
        val queue: Queue<Int> = LinkedList<Int>()
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        queue.forEach {
            println(it)
        }
    }

    @Test
    fun `blocking queue`() {
        //阻塞队列，底层是数组，必须指定队列大小，且不可改变
        val queue = ArrayBlockingQueue<Int>(2)
        queue.offer(1)
        queue.offer(2)
        val result = queue.offer(3)
        println("Queue is full,still offer element 3 result: $result")
        try {
            queue.add(4)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        queue.forEach {
            println("queue element: $it")
        }
    }

    @Test
    fun `test enque remove and poll`() {
        //阻塞队列，底层是数组，必须指定队列大小，且不可改变
        val queue = ArrayBlockingQueue<Int>(3)
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        queue.forEach {
            println(it)
        }
        queue.forEachIndexed { index, i ->
            println("remove 移除了元素：${queue.remove()}")
        }
        println("Empty queue still poll result:${queue.poll()}")
        println("Empty queue still remove result:${queue.remove()}")
    }

    @Test
    fun `test enque element and peek`() {
        //阻塞队列，底层是数组，必须指定队列大小，且不可改变
        val queue = ArrayBlockingQueue<Int>(3)
        queue.offer(1)
        queue.offer(2)
        val element = queue.element()
        val peek = queue.peek()
        println("Queue header by element():$element")
        println("Queue header by peek():$peek")
        println("=============================")
        queue.clear()
        val peek2 = queue.peek()
        println("Empty queue header by peek():$peek2")
        val element2 = queue.element()
        println("Empty queue header by element():$element2")
    }

    private val queue = ArrayBlockingQueue<Int>(3)
    private val putLock = ReentrantLock()
    private val takeLock = ReentrantLock()

    var i = 0

    @Test
    fun `test enque put and take`() {
        //阻塞队列，底层是数组，必须指定队列大小，且不可改变
        thread1.start()
        thread2.start()
        putLock.newCondition()
    }

    private val thread1: Thread = thread {
        while (true) {
            queue.put(i++)
            println("put element:$i")
        }
    }

    private val thread2: Thread = thread {
        while (true) {
            val element = queue.take()
            println("get element:$element")
        }
    }
}