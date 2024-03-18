package main.Task4;

import java.util.Random;

class Therapist {
    public void checkUp(Patient patient) {
        System.out.println("Therapist is examining patient " + patient.getName());
        try {
            Thread.sleep(new Random().nextInt(500) + 300); // Random duration of examination
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MRI mri = new MRI();
        mri.scan(patient);
    }
}