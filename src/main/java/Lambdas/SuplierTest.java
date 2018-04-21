package Lambdas;

import java.util.Date;
import java.util.function.Supplier;

public class SuplierTest {
    public static void main(String[] args) {
        Supplier<String> helloSupplier = () -> new String("Hello Supplier");
        String helloString = helloSupplier.get();
        System.out.println(helloString);

        System.out.println("=======================");

        Supplier<String> constructRef = String::new;
        String conStr = constructRef.get();
        System.out.println(conStr);
        System.out.println("=======================");

        Supplier<Date> dateSupplier = SuplierTest::getSysDate;
        Date sysDate = dateSupplier.get();
        System.out.println("Date = "+sysDate);
        System.out.println("=======================");

        //Supplier

    }
    public static Date getSysDate(){
        return new Date();
    }
}
