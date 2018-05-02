package Lambdas;

import java.util.Map;
import java.util.stream.Collectors;

public class CollectToMapTest {
    public static void main(String[] args) {
        Map<Gender, Double> stringList = Employee.persons()
                .stream()
                .filter(person->person.isMale())
                .collect(Collectors.toMap(Employee::getGender, Employee::getIncome,
                                                    (oldSlary, newSlary)->oldSlary+newSlary));
        System.out.println(stringList);
    }
}
