package Practice;

import java.util.*;

interface greet {
    String sayHello(String text);
}

public class PracticeMain {
    public static void main(String[] args) {
        greet Greeting = (text) -> "Hello " + text;
        System.out.print(Greeting.sayHello("Akai"));
    }
}
