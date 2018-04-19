package Lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaRunner {
    public static void main(String[] args) {
        MyLambda object = (a, b) -> a * b;
        int result = object.sum(100, 22);
        System.out.println(result);

        GetMessage print = (message) ->
                System.out.println("Hello " + message);
        print.getText("Java 8");

        System.out.println("======================================");
        Car car = new Car(123, "BMW");
        Car car1 = new Car(321, "Mercedes");
        Car car2 = new Car(44, "Ford");

        Car[] cars = {car, car1, car2};
        Arrays.sort(cars, car::compare);
        System.out.println(Arrays.toString(cars));

        System.out.println("======================================");

        House house = new House(600000, "Kennedy");
        House house1 = new House(100000,"Klinton");
        House house2 = new House(150000, "Trump");

        House[] houses = {house, house1, house2};

        Comparator houseComparator = (o1, o2) -> {
            House o21 = (House) o1;
            House o11 = (House) o2;
            if (o11.getPrice() > o21.getPrice()) {
                return -1;
            } else if (o11.getPrice() < o21.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        };
        Arrays.sort(houses, houseComparator);
        System.out.println(Arrays.toString(houses));
        System.out.println("======================================");
        Sayable sayable = SayService::saySomething;
        sayable.say();
        System.out.println("======================================");
        Sayable sayConstructor = SayService::new;
        sayConstructor.say();
        System.out.println("======================================");
        SayService sayService = new SayService();
        Sayable sayable1 = sayService::saySomethingMethod;
        System.out.println("======================================");
        sayable1.say();
    }
}