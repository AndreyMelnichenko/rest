package Lambdas;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) throws Exception {
        String fieldForOptional = "My Optional Value";

        Optional<String> stringOptional = Optional.of(fieldForOptional);

        String optionalName = null;
        Optional<String> str = Optional.ofNullable(optionalName);
        if(str.isPresent()){
            System.out.println(str.get());
        }else {}

        str.ifPresent(s-> System.out.println(s));

        System.out.println("Present "+str.orElseGet(OptionalTest::suplyInfo));
        System.out.println("Present "+str.orElse("Fuck!!!"));
        System.out.println("Present "+(str.orElseThrow(() -> new Exception("EXCEPTION ERROR"))));
    }
    private static String suplyInfo(){
        return "EXCEPION MESSAGE";
    }
}
