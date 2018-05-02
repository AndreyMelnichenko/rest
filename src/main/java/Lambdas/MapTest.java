package Lambdas;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MapTest {
    public static void main(String[] args) {
        List<String> stringList = Employee.persons()
                .stream()
                .map(Employee::getName)
                .filter(name -> name.equals("Jack"))
                .collect(toList());

        System.out.println(stringList.toString());
        List<String> person = Persone.myStuff()
                .stream()
                .flatMap(persone -> persone.getAddrHist().stream().filter(s -> s.equals("Paris")))
                .collect(toList());

        System.out.println(person.toString());
        System.out.println(Persone.myStuff().get(0));

        Integer totalId = Persone.myStuff()
                .stream()
                .mapToInt(Persone::getId)
                .sum();

        System.out.println(totalId);
    }
}
