package Lambdas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class House implements Comparator {
    private int price;
    private String owner;

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public String toString() {
        return "House{" +
                "price=" + price +
                ", owner='" + owner + '\'' +
                '}';
    }
}
