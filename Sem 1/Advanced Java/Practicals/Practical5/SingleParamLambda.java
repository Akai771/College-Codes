// WAP using Lambda expression with a single parameter.

package Practicals.Practical5;

interface SingleParamInterface {
    void greet(String name);
}

public class SingleParamLambda {
    public static void main(String[] args) {
        SingleParamInterface singleParam = (name) -> System.out.println("Hello, " + name + "!");
        singleParam.greet("Lambda");
    }
}
