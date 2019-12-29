package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    public Address address;

    public Profile(Address address) {
        this.address = address;
    }

    static List<Address> collect(List<Profile> profiles) {
        List<Address> adres = profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
        for (Address address : adres) {
            System.out.println("Город: " + address.getCity() + " Улица: " + address.getStreet() + " Дом: " +  address.getHome() + " Квартира: " + address.getApartment());
        }
        return adres;
    }

    public static void main(String[] args) {
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("Moscow", "Lenina", 27, 2)));
        profiles.add(new Profile(new Address("Minsk", "Novaya", 17, 3)));
        profiles.add(new Profile(new Address("London", "Grov", 2, 5)));
        collect(profiles);
    }
}

