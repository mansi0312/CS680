package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ComparatorTest {

	private String[] carsToStringArray(ArrayList<Car> cars) {
        String[] carsMake =  new String[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            carsMake[i] = cars.get(i).getMake();
        }
        return carsMake;
    }

    private static ArrayList<Car> cars = new ArrayList<>();;

    @BeforeAll
    public static void setUp() {
        cars.add(new Car("Ford", "Tunner", 200, 2010, 500));
        cars.add(new Car("Toyota", "RAV4", 190, 2018, 300));
        cars.add(new Car("BMW", "XM6", 10, 2019, 200));
        cars.add(new Car("Mercedes", "SL550", 0, 2020, 100));

    }

    @Test
    public void compareYear() {
        String[] expected = {"Mercedes", "BMW", "Toyota", "Ford"};
        Collections.sort(cars, new PriceComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void compareMileage() {
        String[] expected = {"Mercedes", "BMW", "Toyota", "Ford"};
        Collections.sort(cars, new MileageComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void comparePrice() {
        String[] expected = {"Mercedes", "BMW", "Toyota", "Ford"};
        Collections.sort(cars, new PriceComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void comparePareto() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }

        String[] expected = {"Mercedes", "BMW", "Toyota", "Ford"};
        Collections.sort(cars, new ParetoComparator());
        String[] actual = carsToStringArray(cars);
        assertArrayEquals(expected, actual);
    }

}
