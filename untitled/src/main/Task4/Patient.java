package main.Task4;

class Patient implements Runnable {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Therapist therapist = new Therapist();
        therapist.checkUp(this);
    }

    public String getName() {
        return name;
    }
}
