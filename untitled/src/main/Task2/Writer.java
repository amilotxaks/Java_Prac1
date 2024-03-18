package main.Task2;

import java.util.concurrent.CopyOnWriteArrayList;

public class Writer implements Runnable {
    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Writer(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            listOfNumbers.add(i);
            System.out.println("Number written: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}