package main.Task4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ClinicSimulation {
    private static Queue<Patient> queue = new LinkedList<>();
    private static int maxQueueLength = 0;

    public static void main(String[] args) {
        int numOfPatients = 10; // Number of patients to simulate
        for (int i = 0; i < numOfPatients; i++) {
            Patient patient = new Patient("Patient-" + (i + 1));
            queue.add(patient);
            if (queue.size() > maxQueueLength) {
                maxQueueLength = queue.size();
            }
            Thread thread = new Thread(patient);
            thread.start();
            try {
                Thread.sleep(new Random().nextInt(300) + 300); // Random time between patient arrivals
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Max queue length: " + maxQueueLength);
    }
}