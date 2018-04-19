package Lambdas;

import lombok.AllArgsConstructor;
import java.util.Comparator;

@AllArgsConstructor
public class Car implements Comparator {
    int price;
    String brand;

    @Override
    public int compare(Object o1, Object o2) {
        Car o21 = (Car) o1;
        Car o11 = (Car) o2;
        if (o11.price > o21.price) {
            return -1;
        } else if (o11.price < o21.price) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
