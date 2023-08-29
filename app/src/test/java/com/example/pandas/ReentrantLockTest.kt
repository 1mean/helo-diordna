package com.example.pandas

import org.junit.Test
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

/**
 * @description: TODO
 * @author: dongyiming
 * @date: 7/29/23 4:11 PM
 * @version: v1.0
 */
public class ReentrantLockTest {

    private val lock: ReentrantLock = ReentrantLock()

    @Test
    fun `reentrantLock test`() {
        val thread1 = thread(false, name = "thread_1") {
            lock.lock()
            try {
                println("${Thread.currentThread()}: First lock acquisition")
                lock.lock()
                try {
                    println("${Thread.currentThread()}: Second lock acquisition")
                } finally {
                    lock.unlock()
                    println("${Thread.currentThread()}: Second lock released")
                }
            } finally {
                lock.unlock()
                println("${Thread.currentThread()}: First lock released")
            }
        }

        val thread2 = thread(false, name = "thread_2") {
            lock.lock()
            try {
                println("${Thread.currentThread()}: First lock acquisition")
            } finally {
                lock.unlock()
                println("${Thread.currentThread()}: First lock released")
            }
        }

        thread1.start()
        thread2.start()
        thread1.join()
        thread2.join()
    }
}