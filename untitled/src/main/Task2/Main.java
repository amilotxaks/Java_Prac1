package main.Task2;

import main.Task2.Reader;
import main.Task2.Writer;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        Reader reader = new Reader(listOfNumbers);
        Writer writer = new Writer(listOfNumbers);

        Thread readerThread = new Thread(reader);
        Thread writerThread = new Thread(writer);

        readerThread.start();
        writerThread.start();
    }
}