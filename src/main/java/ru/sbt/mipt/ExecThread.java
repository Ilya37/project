package ru.sbt.mipt;

/**
 * Created by alex on 09.01.16.
 */
public class ExecThread extends Thread {
    String id;

    public ExecThread(Runnable target, String id) {
        super(target);
        this.id = id;
    }

    public String getMyId() {
        return id;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " started");
        super.run();
        System.out.println("Thread " + id + " ended");
    }
}