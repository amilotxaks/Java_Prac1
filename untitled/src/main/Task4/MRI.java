package main.Task4;

import java.util.Random;

class MRI {
    public void scan(Patient patient) {
        System.out.println("MRI is scanning patient " + patient.getName());
        try {
            Thread.sleep(new Random().nextInt(500) + 300); // Random duration of MRI scan
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Patient " + patient.getName() + " completed MRI scan");
    }
}
