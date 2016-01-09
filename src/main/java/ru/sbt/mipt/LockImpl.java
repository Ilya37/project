package ru.sbt.mipt;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Ilya on 09.01.2016.
 */
public class LockImpl implements Lock {
        private AtomicBoolean state = new AtomicBoolean(false);

        public void lock() {
            while (true) {
                while (state.get()) {
                }

                if (!state.getAndSet(true)) return;
            }
        }

        public void unlock() {
            state.set(false);
        }
}
