package main.Task1;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }

}