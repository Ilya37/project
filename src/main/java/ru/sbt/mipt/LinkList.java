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
        LinkList linkList = new LinkList();
        linkList.add(1);
        linkList.add(11);
        linkList.add(-1);
        linkList.add(133);
        linkList.add(5565);
        linkList.read();

        System.out.println("Deleting ");

        linkList.delete(-1);
        linkList.read();
        System.out.println("Adding again");
        linkList.add(2, 1000);
        System.out.println("Now reading");
        linkList.read();
    }

    // this is element locked version of linkList
    private void delete(Node head, int data) {

        while (head != null) {
            // here the node is having left , right elements . So I am assuming
            // if I lock this
            // head object , then the left and right pointers will also be
            // locked.
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

        // here the node is having left , right elements . So I am assuming if I
        // lock this
        // head object , then the left and right pointers will also be locked.
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
