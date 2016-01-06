package ru.sbt.mipt;

/**
 * Created by Ilya on 22.11.2015.
 */

public class LinkList {

    Node head;
    int size;

    public LinkList() {
        head = null;
        size = 0;
    }

    // adding new element at last
    public void add(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            add(head, data);
        }
    }

    public void add(Node node, int data) {
        Node temp;
        while (node.left != null) {
            node = node.left;
        }
        Node temp1 = new Node(data);
        node.left = temp1;
        temp1.right = node;
    }

    public void read() {
        read(head);
    }

    private void read(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.left;
        }
    }

    public class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            size++;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        LinkList linkList = new LinkList();
        for (int i = 1; i <= 10000; i++) {
            linkList.add(i);
        }

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total time is " + totalTime);

        //linkList.read();

        System.out.println("Deleting ");

        linkList.delete(-1);
        //linkList.read();
        System.out.println("Adding again");
        //linkList.add(2, 1000);
        System.out.println("Now reading");
        //linkList.read();
    }

    // this is element locked version of linkList
    private void delete(Node head, int data) {

        while (head != null) {

            synchronized (head) {
                if (head.data == data) {
                    Node rightTemp, leftTemp;
                    rightTemp = head.right;
                    leftTemp = head.left;
                    rightTemp.left = leftTemp;
                    leftTemp.right = rightTemp;
                    return;
                }
            }
            head = head.left;
        }
    }

    public void delete(int data) {
        delete(head, data);
        size--;
    }

    public void add(int index, int data) {
        if (index > -1 && index < size) {
            add(head, index, data);
        } else if (index == size) {
            add(head, data);

        } else {
            System.out.println("Sorry can`t add element ");
        }
    }

    public void add(Node head, int index, int data) {
        int i = 0;
        while (i <= index) {
            head = head.left;
            i++;
        }
        synchronized (head) {
            Node tempRight, tempLeft, temp;
            tempLeft = head;
            tempRight = head.right;
            temp = new Node(data);
            tempRight.left = temp;
            temp.right = tempLeft;
            temp.left = tempLeft;
        }

    }
}
