package ru.sbt.mipt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by alex on 09.01.16.
 */
public class CoarseGrainedSynch {

    private class Node<T> {
        T item;
        int key;
        Node next;
    }

    public class CoarseList<T> {
        private Node head;
        private Lock lock = new ReentrantLock();
/// проверить класс Node!!!
        public CoarseList() {
            head = new Node();
            head.next = new Node();
        }

        public boolean add(T item) {
            Node pred, curr;
            int key = item.hashCode();
            lock.lock();
            try {
                pred = head;
                curr = pred.next;
                while (curr.key < key) {
                    pred = curr;
                    curr = curr.next;
                }
                if (key == curr.key) {
                    return false;
                } else {
                    Node node = new Node();
                    node.next = curr;
                    pred.next = node;
                    return true;
                }
            } finally {
                lock.unlock();
            }
        }


        public boolean remove(T item) {
            Node pred, curr;
            int key = item.hashCode();
            lock.lock();
            try {
                pred = head;
                curr = pred.next;
                while (curr.key < key) {
                    pred = curr;
                    curr = curr.next;
                }
                if (key == curr.key) {
                    pred.next = curr.next;
                    return true;
                } else {
                    return false;
                }
            } finally {
                lock.unlock();
            }
        }


    }
}
