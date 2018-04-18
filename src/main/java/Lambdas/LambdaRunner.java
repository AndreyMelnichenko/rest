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

        //Arrays.sort(cars, car::compare);
        System.out.println(Arrays.toString(cars));

        System.out.println("=======================================");
        Comparator carComparator = (o1, o2) -> {
            Car o21 = (Car) o1;
            Car o11 = (Car) o2;
            if (o11.price > o21.price) {
                return -1;
            } else if (o11.price < o21.price) {
                return 1;
            } else {
                return 0;
            }
        };
        Arrays.sort(cars, carComparator);
        System.out.println(Arrays.toString(cars));
    }
}