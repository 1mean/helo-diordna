package com.example.pandas;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockTest1 {

    ReentrantLock lock = new ReentrantLock();

    static int value = 0;
    synchronized int get(){
        return value;
    }

    synchronized static void addOne(){
        value += 1;
    }
}
