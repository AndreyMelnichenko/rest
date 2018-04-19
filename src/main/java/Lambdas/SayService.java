package Lambdas;

public class SayService {
    public SayService() {
        System.out.println("Hello World from Constructor");
    }

    public static void saySomething() {
        System.out.println("Hello, this is static method.");
    }


    public void saySomethingMethod() {
        System.out.println("Hello, this is not static method.");
    }
}
