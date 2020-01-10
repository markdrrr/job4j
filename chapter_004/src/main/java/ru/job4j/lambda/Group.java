package ru.job4j.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    static class Holder {
        String key, value;

        Holder(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static Map<String, Set<String>> sections(List<Student> students) {
        return students.stream().flatMap(student -> student.getUnits().stream()
                .map(group -> new Holder(group, student.getName())))
                .collect(Collectors.groupingBy(hold -> hold.key,
                        Collector.of(HashSet::new,
                                (set, el) -> {
                                    set.add(el.value);
                                },
                                (left, right) -> {
                                    left.addAll(right);
                                    return left;
                                }))

                );
    }
}