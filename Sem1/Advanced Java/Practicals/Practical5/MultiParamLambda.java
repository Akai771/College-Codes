// WAP using Lambda expression with multiple parameters to add two numbers.
package Practicals.Practical5;

interface Add {
    int add(int a, int b);
}

public class MultiParamLambda {
    public static void main(String[] args) {
        Add addition = (a, b) -> a + b;
        System.out.println("Sum: " + addition.add(5, 10));
    }
}
