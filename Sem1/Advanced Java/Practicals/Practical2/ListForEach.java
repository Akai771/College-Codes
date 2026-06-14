// Write a Java program to create List containing list of items of type String and use for-each loop to print the items of the list.

package Practicals.Practical2;
import java.util.*;

public class ListForEach {
    public static void main(String[] args){
		List<String> l1 = new ArrayList<>();
		l1.add("UP");
		l1.add("Bihar");
		l1.add("Haryana");

		// Using forEach to print elements
		for(String str : l1) {
			System.out.println(str);
		}
	}
}