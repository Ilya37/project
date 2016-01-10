package ru.sbt.mipt;

/**
 * Created by Ilya on 09.01.2016.
 */
public interface LockSet {
    public void lock();
    public void unlock();
    public boolean tryLock();
}
