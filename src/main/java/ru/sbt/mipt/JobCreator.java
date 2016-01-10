package ru.sbt.mipt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 09.01.16.
 */
public class JobCreator {

    public static List<Thread> createAddThreads(final LinkList list, int numberOfThreads, int numberOfElements) {

        List<Thread> threads = new ArrayList<Thread>();
        final int threadElemAmount = numberOfElements / numberOfThreads;
        System.out.println("thread element amount "+threadElemAmount);
        int rest = numberOfElements % numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            int additive = 0;
            if (rest > 0) {
                System.out.println("REST > 0. rest = " + rest);
                additive = 64;
            }
            final int finalAdditive = additive;
            threads.add(new ExecThread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadelemamount = " + threadElemAmount);
                    System.out.println(threadElemAmount + finalAdditive);
                    for (int j = 0; j < (threadElemAmount + finalAdditive); j++) {
                        //make a job
                        list.add2(1,j);
                    }

                }
            }, String.valueOf("adding " + i)));
            rest--;
        }
        return threads;
    }

    public static void addTest(final LinkList list, int numberOfThreads, int numberOfElements) throws IOException, InterruptedException {

        List<Thread> threads = createAddThreads(list, numberOfThreads, numberOfElements);
        System.out.println("Configuration: threads = " + numberOfThreads + " elements = " + numberOfElements );

        System.out.println("Start adding test with " + numberOfThreads + " threads");
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}