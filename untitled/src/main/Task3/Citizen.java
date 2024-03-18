package main.Task3;

import java.util.Random;

public class Citizen implements Runnable {
    private String category;
    private boolean served;

    public Citizen(String category) {
        this.category = category;
        this.served = false;
    }

    public String getCategory() {
        return category;
    }

    public boolean isServed() {
        return served;
    }

    @Override
    public void run() {
        Random random = new Random();
        int windowNumber = random.nextInt(3); // Randomly choose a window

        // Businessmen category can only go to third window
        if (category.equals("Businessmen") && windowNumber != 2) {
            System.out.println("Businessman could not be served in window " + windowNumber);
            return;
        }

        // Elderly category can only go to second window
        if (category.equals("Elderly") && windowNumber != 1) {
            System.out.println("Elderly person could not be served in window " + windowNumber);
            return;
        }

        // Young and any category can go to any window
        System.out.println(category + " is being served in window " + windowNumber);
        served = true;
    }

    public static void main(String[] args) {
        int totalCitizens = 1000;
        int elderlyLeft = 0;
        int youngLeft = 0;
        int businessmenLeft = 0;

        for (int i = 0; i < totalCitizens; i++) {
            Random random = new Random();
            int num = random.nextInt(3); // Randomly choose a category
            String category;
            if (num == 0) {
                category = "Young";
            } else if (num == 1) {
                category = "Elderly";
            } else {
                category = "Businessmen";
            }

            Citizen citizen = new Citizen(category);
            Thread thread = new Thread(citizen);
            thread.start();

            if (!citizen.isServed()) {
                if (category.equals("Young")) {
                    youngLeft++;
                } else if (category.equals("Elderly")) {
                    elderlyLeft++;
                } else {
                    businessmenLeft++;
                }
            }
        }

        double youngPercent = ((double)youngLeft / totalCitizens) * 100;
        double elderlyPercent = ((double)elderlyLeft / totalCitizens) * 100;
        double businessmenPercent = ((double)businessmenLeft / totalCitizens) * 100;

        System.out.println("Percentage of young citizens left: " + youngPercent + "%");
        System.out.println("Percentage of elderly citizens left: " + elderlyPercent + "%");
        System.out.println("Percentage of businessmen left: " + businessmenPercent + "%");
    }
}