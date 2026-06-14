// WAP using Lambda expression to concatenate two strings.

package Practicals.Practical5;

interface Concat {
    String concatenate(String a, String b);
}

public class ConcatLambda {
    public static void main(String[] args) {
        Concat concatStrings = (a, b) -> a + b;
        System.out.println(concatStrings.concatenate("Hello, ", "Lambda!"));
    }
}
