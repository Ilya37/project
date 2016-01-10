package ru.sbt.mipt;

/**
 * Created by Ilya on 06.01.2016.
 */
public class OptimisticListDefinition{

    private NodeNew head;
    private NodeNew tail;
    private int size;

    public OptimisticListDefinition() {
        NodeNew root = new NodeNew(null);
        head = root;
        tail = root;
        size = 0;
    }

}
