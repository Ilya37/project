package ru.sbt.mipt;

/**
 * Created by Ilya on 22.11.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        LinkList list = new LinkList();
        list.add(1);
        list.add(2);
        //list.add(0);
         list.add2(2,100);
        long startTime = System.currentTimeMillis();
        JobCreator.addTest(list,1, 1);

        //    OptimisticListImplementation<Integer> lists = new OptimisticListImplementation<Integer>();
    //    lists.add(1);

        //lists.size();
        //OptimisticListDefinition lists = new OptimisticListDefinition();


        //CoarseGrainedSynch list = new CoarseGrainedSynch();

        //JobCreator.createAddThreads(list,4,100000,10);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("total time is " + totalTime);
        list.size();
     //   list.read();

    }
}
