package Lambdas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

@Data
@AllArgsConstructor
public class Persone {
    private int id;
    private String name;
    private Gender gender;
    private List<String> addrHist;

    public static List<Persone> myStuff(){
        Persone p1 = new Persone(1, "Jackie", Gender.FEMALE,
                (asList("Kiev", "Washington")));
        Persone p2 = new Persone(2, "Bill", Gender.MALE,
                (asList("Praha","London")));
        Persone p3 = new Persone(3, "Ross", Gender.MALE,
                (asList("Kiev","Paris")));

        List<Persone> persons = asList(p1, p2, p3);
        return persons;
    }

/*    private List<String> setAddrHist(List<String> val) {
        return this.setAddrHist(val);
    }*/

    @Override
    public String toString() {
        return "Persone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", addrHist=" + addrHist +
                '}';
    }
}
