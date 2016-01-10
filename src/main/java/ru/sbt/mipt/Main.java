package ru.sbt.mipt;

/**
 * Created by Ilya on 22.11.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        LinkList list = new LinkList();
        list.add(1);
    //    OptimisticListImplementation<Integer> lists = new OptimisticListImplementation<Integer>();
    //    lists.add(1);

        //lists.size();
        //OptimisticListDefinition lists = new OptimisticListDefinition();


        //CoarseGrainedSynch list = new CoarseGrainedSynch();

        //JobCreator.createAddThreads(list,4,100000,10);
        JobCreator.addTest(list, 1, 50000);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total time is " + totalTime);
        list.size();
        //linkList.read();

    }
}
