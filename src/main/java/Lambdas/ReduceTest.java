package Lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReduceTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> sum = numbers.stream()
                                       .reduce(Integer::sum);

        sum.ifPresent(num -> System.out.println(num));
        String optionalName = "12";
        Optional<String> str = Optional.ofNullable(optionalName);
        if(str.isPresent()){
            System.out.println(str.get());
        }

        List<Employee> persons = Employee.persons();

        Optional<List<Employee>> persons1 = Optional.of(persons);



        Optional<Double> result = Employee.persons()
                                          .stream()
                                          .map(Employee::getIncome)
                                          .sorted(Comparator.comparingDouble(value -> value))
                                          .findFirst();

        result.ifPresent(System.out::println);
        Double aDouble = result.get();
    }
}
