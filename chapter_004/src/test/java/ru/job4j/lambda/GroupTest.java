package ru.job4j.lambda;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class GroupTest {

    @Test
    public void whenCreateStudents() {
        List<Student> students = new ArrayList<Student>();
        Set<String> unit = new HashSet<>();
        unit.add("Geography");
        unit.add("Math");
        Student st = new Student("Student name", unit);
        students.add(st);
        Map<String, Set<String>> expected = Group.sections(students);
        Map<String, Set<String>> result = new HashMap<String, Set<String>>();
        Set<String> stud = new HashSet<>();
        stud.add("Student name");
        result.put("Geography", stud);
        result.put("Math", stud);
        assertThat(result, is(expected));
    }
} 