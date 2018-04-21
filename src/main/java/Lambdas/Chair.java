package Lambdas;

import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class Chair implements Comparator{
    int price;
    String color;



    @Override
    public String toString() {
        return "Chair{" +
                "price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
