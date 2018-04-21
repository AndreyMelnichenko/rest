package Lambdas;

import java.util.function.Consumer;

public class ConsummerRunner {
    public static void main(String[] args) {
        Consumer<Integer> integerConsumer = ConsummerRunner::getNumber;
        integerConsumer.accept(100);
        integerConsumer.accept(22);
        integerConsumer.accept(54);

    }

    public static void getNumber(int num){
        System.out.println("Integer number is: "+num);
    }
}
