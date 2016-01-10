package ru.sbt.mipt;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Ilya on 09.01.2016.
 */
public class LockSetImpl implements LockSet {
    private AtomicBoolean state = new AtomicBoolean(false);

    @Override
    public void lock() {
        while (state.getAndSet(true)) {}
    }

    @Override
    public void unlock() {
        state.set(false);
    }

    @Override
    public boolean tryLock() {
        if (!state.get()){
            lock();
            return true;
        } else return false;
    }
}
