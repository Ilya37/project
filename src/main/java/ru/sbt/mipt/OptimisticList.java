package ru.sbt.mipt;

/**
 * Created by Ilya on 06.01.2016.
 */
public class OptimisticList<T> implements SetOptimisticList {
    @Override
    public boolean add(T item) {
        int key = item.hashCode();
        while (true) {
            LinkList.Node pred = head;
            LinkList.Node curr = pred.next;
            while (curr.key <= key) {
                pred = curr; curr = curr.next;
                }
            pred.lock();
            curr.lock();
            try {
                if (validate(pred, curr)) {
                    if (curr.key == key) {
                        return false;
                        } else {
                        LinkList.Node node = new LinkList.Node(item);
                        node.next = curr;
                        pred.next = node;
                        return true;
                        }
                    }
                } finally {
                pred.unlock(); curr.unlock();
                }
            }
        }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    public boolean validate()

    @Override
    public boolean contains(Object x) {
        return false;
    }
}
