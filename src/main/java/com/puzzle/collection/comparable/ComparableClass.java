package com.puzzle.collection.comparable;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/4/23 0023.
 */
public class ComparableClass {   //可进行排序的比较类

    public static void main(String[] args) {
        Car car1 = new Car("A",  5000);
        Car car2 = new Car("B", 5000);
        Car car3 = new Car("C", 4000);

        System.out.println("Car 1 equals Car 2: " + car1.compareTo(car2));
        System.out.println("Car 1 equals Car 3: " + car1.compareTo(car3));
        System.out.println("Car 2 equals Car 3: " + car2.compareTo(car3));

        Car[] carArray = new Car[] { car1, car2, car3 };
        Arrays.sort(carArray);

        for (Car car : carArray)
            System.out.println(car.toString());
    }
}

class Car implements Comparable {
    private String make;

    private int mileage;

    public Car(String make, int mileage) {
        this.make = make;
        this.mileage = mileage;
    }

    public int compareTo(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            if (this.mileage > car.getMileage())
                return 1;
            else if (this.mileage < car.getMileage())
                return -1;
        }
        return 0;
    }

    public int getMileage() {
        return mileage;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Make: " + make + ",Mileage: " + mileage);
        return buffer.toString();
    }
}
