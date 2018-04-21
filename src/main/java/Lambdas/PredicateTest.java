package Lambdas;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = (s) -> s.length()>=5;

        System.out.println(stringPredicate.test("Lucky"));
    }
}
