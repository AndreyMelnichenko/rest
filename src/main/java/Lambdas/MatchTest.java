package Lambdas;

import java.util.List;

public class MatchTest {
    public static void main(String[] args) {
        List<Employee> persons = Employee.persons();

        // Check if all persons are males
        boolean allMales = persons.stream()
                                  .allMatch(employee -> employee.getGender() == Gender.MALE);
        System.out.println("All  males: " + allMales);

        // Check if any person was born in 1971
        boolean anyoneBornIn1971 = persons.stream()
                                          .anyMatch(p -> p.getDob().getYear() == 1971);
//        asserTrue(anyoneBornIn1971);
        System.out.println("Anyone born  in 1971:  " + anyoneBornIn1971);

    }
}
