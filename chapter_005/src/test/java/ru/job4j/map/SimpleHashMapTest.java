package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    private SimpleHashMap<User, String> container;
    private User u1;
//    private User u2;
//    private User u3;
//    private User u4;
//    private User u5;
//    private User u6;
//    private User u7;
//    private User u8;
//    private User u9;
//    private User u10;
//    private User u11;

    @Before
    public void init() {
        container = new SimpleHashMap<>();
        u1 = new User("name", 1, new GregorianCalendar());
//        u2 = new User("name", 2, new GregorianCalendar());
        container.insert(u1, "first");
    }

    @Test
    public void whenInsertThenReturnValue() {
        assertThat(container.get(u1), is("first"));
    }

    @Test
    public void whenGetElementExistInMapThenReturnValue() {
        System.out.println(container.get(u1));
        assertThat(container.get(u1), is("first"));
    }

    @Test
    public void whenDeleteElementExistInMapThenReturnTrue() {
        assertThat(container.delete(u1), is(true));
    }

//    @Test
//    public void whenDeleteElementExistInMapThenReturnTrue22() {
//        u2 = new User("name", 2, new GregorianCalendar());
//        u3 = new User("name", 5, new GregorianCalendar());
//        u4 = new User("name", 6, new GregorianCalendar());
//        u5 = new User("name", 7, new GregorianCalendar());
//        u6 = new User("name", 8, new GregorianCalendar());
//        u7 = new User("name", 9, new GregorianCalendar());
//        u8 = new User("name", 10, new GregorianCalendar());
//        u9 = new User("name", 11, new GregorianCalendar());
//        u10 = new User("name", 12, new GregorianCalendar());
//        u11 = new User("name", 13, new GregorianCalendar());
//        container.insert(u2, "fir2st");
//        container.insert(u3, "first2");
//        container.insert(u4, "first3");
//        container.insert(u5, "firs4t");
//        container.insert(u6, "fi2rst");
//        container.insert(u7, "fir12st");
//        container.insert(u8, "fi2rst");
//        container.insert(u9, "fir4st");
//        container.insert(u10, "fi4rst");
//        container.insert(u11, "fi1rst");
//        System.out.println(container.getSize());
//
//        assertThat(container.delete(u1), is(true));
//    }
}