package ru.job4j.map;

import java.util.*;


/**
 * 4. Переопределить только equals[#223117]
 *
 * @author Andrey Markushin
 * @version 1.0
 * @since 04.04.2020
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, children, birthday);
//    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User first = new User("Jonh", 2,new GregorianCalendar(1990, Calendar.JANUARY , 25));
        User second = new User("Jonh", 2,new GregorianCalendar(1990, Calendar.JANUARY , 25));
        Map<User, Object> map = new HashMap<>();
        map.put(first, first);
        map.put(second, second);
        System.out.println(map);
        System.out.println(first.equals(second));
        System.out.println(first.hashCode() + " " + second.hashCode());
        /*
        Все равно на печать вышло два идентичных объекта,
        метод equals() дает true, а hashCode() результат.
        */
    }
}
