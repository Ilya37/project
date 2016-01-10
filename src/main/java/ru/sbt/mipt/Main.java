package ru.sbt.mipt;

import java.io.IOException;

/**
 * Created by Ilya on 22.11.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = System.currentTimeMillis();
        OptimisticListDefinition<Integer> lists = new OptimisticListDefinition<Integer>();


        //CoarseGrainedSynch list = new CoarseGrainedSynch();

        //JobCreator.createAddThreads(linkList,1,100000,10);
       //JobCreator.addTest(lists, 1, 50000, 10);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total time is " + totalTime);
        //lists.size();
        //linkList.read();

    }
}
