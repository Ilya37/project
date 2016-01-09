package ru.sbt.mipt;

/**
 * Created by Ilya on 06.01.2016.
 */
public interface SetOptimisticList<T> {
        boolean add(T x);
        boolean remove(T x);

        boolean remove(Object item);

        boolean contains(Object item);

        boolean contains(T x);
}
