package ru.sbt.mipt;

/**
 * Created by Ilya on 06.01.2016.
 */
public interface Set {
        boolean add(OptimisticList x);
        boolean remove(OptimisticList x);
        boolean contains(OptimisticList x);
}
