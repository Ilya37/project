package ru.sbt.mipt;

import java.util.concurrent.locks.Lock;

/**
 * Created by Ilya on 09.01.2016.
 */
public class NodeNew<T> {
    public NodeNew next;
    public Lock lock;
    public T value;
    public int size;

    public boolean tryLock() {
        return false;
    }

    public class Node {
        int data;
        Node left, right;
        int size;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            size++;
        }
    }


    public NodeNew(T value) {
        this.value = value;
        size++;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

}
