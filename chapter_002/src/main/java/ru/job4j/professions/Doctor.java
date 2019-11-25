package ru.job4j.professions;

public class Doctor extends Profession {
    String department;
    int experience;

    public Diagnose heal(Pacient pacient) {
        Diagnose healthy = new Diagnose(true);
        return healthy;
    }
    public String getDepartment() {
        return department;
    }
    public int getExperience() {
        return experience;
    }
}
