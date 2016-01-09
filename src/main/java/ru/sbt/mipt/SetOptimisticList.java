package ru.sbt.mipt;

import java.util.List;

/**
 * Created by Ilya on 06.01.2016.
 */
public interface SetOptimisticList<T> {
        public boolean add(T e);

        public boolean remove(T e);

        public boolean contains(T e);

        public int size();
}
