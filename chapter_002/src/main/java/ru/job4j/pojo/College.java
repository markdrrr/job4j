package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Andrey");
        student.setGroup("Группа 161-б-н-1");
        student.setReceipt(new Date());

        System.out.println(student.getName() + " учится в " + student.getGroup() + " дата поступления " + student.getReceipt());
    }
}
