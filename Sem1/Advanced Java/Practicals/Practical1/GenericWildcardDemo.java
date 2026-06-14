// Write a Java Program to demonstrate Wildcards in Java Generics.

package Practicals.Practical1;
import java.util.*;

public class GenericWildcardDemo {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        printList(intList);
    }

    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem);
        }
    }
}
