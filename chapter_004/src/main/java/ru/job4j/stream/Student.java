package ru.job4j.stream;

public class Student implements Comparable<Student> {
    private int score;
    private String surname;

    public Student(int score) {
        this.score = score;
    }

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + ", surname='" + surname + '\'' + '}';
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.getScore(), this.score);
    }
}
