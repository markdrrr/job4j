package ru.job4j.stream;

public class Student implements Comparable<Student> {
    private int score;

    public Student(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "score=" + score + '}';
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.getScore(), this.score);
    }
}
