package edu.umb.cs680.hw14;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class ComparatorTest {

    private String[] carsToStringArray(ArrayList<Car> cars) {
        String[] carsMake =  new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            carsMake[i] = cars.get(i).getMake();
        }
        return carsMake;
    }

    private static ArrayList<Car> cars = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        cars.add(new Car("Toyota", "RAV4", 190, 2018, 300));
        cars.add(new Car("BMW", "XM6", 10, 2019, 200));
        cars.add(new Car("Ford", "Tunner", 200, 2010, 500));
        cars.add(new Car("Mercedes", "SL550", 0, 2020, 100));

    }

    @Test
    public void compareYear() {
        String[] expected = {"Mercedes", "BMW", "Toyota", "Ford"};
        Collections.sort(cars, Comparator.comparing(Car::getYear, Comparator.reverseOrder()));

        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void compareMileage() {
        String[] expected = {"Mercedes", "BMW", "Toyota", "Ford"};
        Collections.sort(cars, Comparator.comparing((Car car) -> car.getMileage()));

        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void comparePrice() {
        String[] expected = {"Mercedes", "BMW", "Toyota", "Ford"};
        Collections.sort(cars, Comparator.comparing(Car::getPrice));

        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void comparePareto() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }

        String[] expected = {"Mercedes", "BMW", "Toyota", "Ford"};
        Collections.sort(cars, Comparator.comparing((Car car) -> car.getDominationCount(), Comparator.reverseOrder()));
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

}
