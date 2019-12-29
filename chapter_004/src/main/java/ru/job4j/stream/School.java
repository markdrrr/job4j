package ru.job4j.stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    static List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> st = students.stream().filter(predict).collect(Collectors.toList());
        Collections.sort(st);
        st.forEach(System.out::println);
        return st;
    }

    public static Map<String, Student> toMap(List<Student> students) {
        Map<String, Student> result = students.stream().distinct().collect(Collectors.toMap(student -> student.getSurname(), student -> student));
    return result;
    }
}
