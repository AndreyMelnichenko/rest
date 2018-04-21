package Lambdas;

import java.util.function.BiFunction;

public class BeFunctionTest {
    public static void main(String[] args) {
        BiFunction<String, Integer, String> bi = (x,y)->x+" "+y;
        System.out.println(bi.apply("Hello", 11));
    }
}
