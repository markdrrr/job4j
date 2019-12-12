package ru.job4j.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DepartamentSort {

    public static Set<Department> sort(List<Department> users) {
        return new TreeSet<Department>(users);
    }

//    public static void main(String[] args) {
//        ArrayList<Department> cods = new ArrayList<>();
//        cods.add(new Department("K1" + '\\' + "SK1"));
//        cods.add(new Department("K1" + '\\' + "SK2"));
//        cods.add(new Department("K1" + '\\' + "SK1" + '\\' + "SSK1"));
//        cods.add(new Department("K1" + '\\' + "SK1" + '\\' + "SSK2"));
//        cods.add(new Department("K2"));
//        cods.add(new Department("K2" + '\\' + "SK1" + '\\' + "SSK1"));
//        cods.add(new Department("K2" + '\\' + "SK1" + '\\' + "SSK2"));
//        cods.add(new Department("K1"));
//
//        System.out.println(cods);
//        System.out.println(sort(cods));
//    }

}
