package Lambdas;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByTest {
    public static void main(String[] args) {
        Map<Gender, Long> person = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(person);

        Map<Gender, String> p2 = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getName, Collectors.joining(", "))));

        System.out.println(p2);

        Map<Gender, Map<Object, String>> collect = Employee.persons()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.groupingBy(p -> p.getDob().getMonth(),
                                Collectors.mapping(Employee::getName, Collectors.joining(", ")))));

        System.out.println(collect);
    }
}
