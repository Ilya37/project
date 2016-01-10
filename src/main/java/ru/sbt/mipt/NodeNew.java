package ru.sbt.mipt;

import java.util.concurrent.locks.Lock;

/**
 * Created by Ilya on 09.01.2016.
 */
public class NodeNew<T> {
    public NodeNew next;
    public Lock lock;
    public T value;

    public NodeNew(T value) {
        this.value = value;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
