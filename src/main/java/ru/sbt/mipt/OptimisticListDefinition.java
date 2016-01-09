package ru.sbt.mipt;

import java.util.concurrent.locks.Lock;

/**
 * Created by Ilya on 06.01.2016.
 */
public class OptimisticListDefinition implements SetOptimisticList {
    public class NodeNew<T> {
        public NodeNew next;
        private Lock lock;
        public T value;

        public NodeNew(T value) {
            this.value = value;
            lock = new BackoffLock();
        }

        public void lock() {
            lock.lock();
        }

        public void unlock() {
            lock.unlock();
        }


        public boolean tryLock() {
            return lock.tryLock();
        }
    }

    private SyncNode head;
    private SyncNode tail;
    private int size;

    public OSLList() {
        SyncNode root = new SyncNode(null);
        head = root;
        tail = root;
        size = 0;
    }

    private Node head;
    private SyncNode tail;
    private int size;

    public OSLList() {
        SyncNode root = new SyncNode(null);
        head = root;
        tail = root;
        size = 0;
    }
