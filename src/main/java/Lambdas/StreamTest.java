package Lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(4,65,34,234,1);
        myList.stream().forEach(System.out::print);
        System.out.println("\n======================");
        myList.forEach(System.out::print);
        System.out.println("\n======================");
        myList.forEach( item-> System.out.print(item+" "));
        System.out.println("\n======================");
        List<Employee> persons = Employee.persons();
        List<Employee> filtredEmployee = new ArrayList<>();
        persons.stream()
                .filter(person -> person.getIncome()>1)
                .sorted((o1,o2)-> {if (o1.getIncome()>o2.getIncome()) return 1;
                    if (o1.getIncome()<o2.getIncome())return  -1;
                    return 0;})
                .forEach(System.out::println);

        List<Employee> filtredList = Employee.persons()
                .stream()
                .filter(employee -> employee.isFemale())
                .collect(Collectors.toList());

        System.out.println(filtredList.toString());
    }
}
