package ru.sbt.mipt;


/**
 * Created by Ilya on 09.01.2016.
 */
public class OptimisticListImplementation<I> implements SetOptimisticList {
    private NodeNew head;
    private NodeNew tail;
    private int size;

    public OptimisticListImplementation() {
        NodeNew root = new NodeNew(null);
        head = root;
        tail = root;
        size = 0;
    }

    public void addToList() throws Exception {
        OptimisticListImplementation<Integer> integers = new OptimisticListImplementation<Integer>();
        for (int i = 0; i < 5; i++) {
            integers.add(i);
        }
    }

    @Override
    public boolean add(Object e) {
        NodeNew pred = tail;
        try {
            NodeNew newNode = new NodeNew(e);
            pred.next = newNode;
            tail = newNode;
            size++;
            return true;
        } finally {
            pred.unlock();
        }
    }

    @Override
    public boolean remove(Object e) {
        NodeNew pred = null, curr = null;
        head.lock();
        try {
            pred = head;
            curr = pred.next;
            curr.lock();
            try {
                while (!curr.value.equals(e)) {
                    pred.unlock();
                    pred = curr;
                    curr = curr.next;
                    curr.lock();
                }
                if (curr.value.equals(e)) {
                    pred.next = curr.next;
                    size--;
                    return true;
                }
                return false;
            } finally {
                curr.unlock();
            }
        } finally {
            pred.unlock();
        }
    }

    @Override
    public boolean contains(Object e) {
        NodeNew pred = null, curr = null;
        head.lock.lock();
        try {
            pred = head;
            curr = pred.next;
            curr.lock();
            try {
                while (!curr.value.equals(e)) {
                    pred.unlock();
                    pred = curr;
                    curr = curr.next;
                    curr.lock();
                }
                if (curr.value.equals(e)) {
                    return true;
                }
                return false;
            } finally {
                curr.unlock();
            }
        } finally {
            pred.unlock();
        }
    }

    @Override
    public int size() {
        return size;
    }
}