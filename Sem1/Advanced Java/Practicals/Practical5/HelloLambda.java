// WAP using Lambda expression to print "Hello, Lambda!".
package Practicals.Practical5;

interface greet {
    public String sayHello(String text);
}

public class HelloLambda {
    public static void main(String[] args) {
        greet greeting = (text) -> "Hello, " + text + "!";
        System.out.println(greeting.sayHello("Lambda"));
    }
}