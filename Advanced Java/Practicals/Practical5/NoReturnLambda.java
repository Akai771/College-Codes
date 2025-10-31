// WAP using Lambda expression with or without return keyword.

package Practicals.Practical5;

public class NoReturnLambda {
    public static void main(String[] args) {
        Runnable task1 = () -> System.out.println("Task 1 executed");
        task1.run();

        Runnable task2 = () -> {
            System.out.println("Task 2 executed");
            return;
        };
        task2.run();
    }
}
