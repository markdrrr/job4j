package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    Student petr = new Student(85, "Ivanov");
    Student jenya = new Student(55, "Petrov");
    Student ivan = new Student(73, "Grach");
    Student denis = new Student(63, "Petruhina");
    Student vadim = new Student(70);
    Student irina = new Student(98);
    Student grisha = new Student(48);

    @Test
    public void whenToMap() {
        List<Student> students = Arrays.asList(petr, jenya, ivan);
        Map<String, Student> result = School.toMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put(petr.getSurname(), petr);
        expected.put(jenya.getSurname(), jenya);
        expected.put(ivan.getSurname(), ivan);
        assertThat(result, is(expected));
    }

    @Test
    public void when10A() {
        List<Student> students = Arrays.asList(petr, jenya, ivan, denis, vadim, irina, grisha);
        List<Student> tenA = School.collect(students, student -> student.getScore() >= 70);
        List<Student> result = tenA;
        List<Student> expected = Arrays.asList(irina, petr, ivan, vadim);
        assertThat(result, is(expected));
    }

//    @Test
//    public void when10B() {
//        List<Student> students = Arrays.asList(petr, jenya, ivan, denis, vadim, irina, grisha);
//        List<Student> tenB = School.collect(students, student -> student.getScore() >= 70);
//        List<Student> result = tenB;
//        List<Student> expected = Arrays.asList(denis, jenya);
//        assertThat(result, is(expected));
//    }

    @Test
    public void when10V() {
        List<Student> students = Arrays.asList(petr, jenya, ivan, denis, vadim, irina, grisha);
        List<Student> tenV = School.collect(students, student -> student.getScore() >= 0 && student.getScore() < 50);
        List<Student> result = tenV;
        List<Student> expected = Arrays.asList(grisha);
        assertThat(result, is(expected));
    }

    @Test
    public void whenScoreMoreBound() {
        List<Student> students = Arrays.asList(petr, null, ivan, null, denis);
        List<Student> result = School.levelOf(students, 70);
        List<Student> expected = Arrays.asList(petr, ivan);
        assertThat(result, is(expected));
    }
}
