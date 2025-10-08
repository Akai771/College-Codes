// Write a Java program using Set interface containing list of items and perform the following operations:
// a. Add items in the set.
// b. Insert items of one set in to other set.
// c. Remove items from the set
// d. Search the specified item in the set

package Practicals.Practical3;
import java.util.*;

public class SetOperations {
    public static void main(String[] args){
		// Add items in the set
		Set<String> set1 = new HashSet<>();
		set1.add("Apple");
		set1.add("Banana");
		set1.add("Orange");
		set1.add("Mango");
		
		System.out.println("Set 1 after adding items: " + set1);
		
		// Insert items of one set into other set
		Set<String> set2 = new HashSet<>();
		set2.add("Grapes");
		set2.add("Pineapple");
		
		System.out.println("\nSet 2: " + set2);
		
		set2.addAll(set1);
		System.out.println("Set 2 after inserting items from Set 1: " + set2);
		
		// Remove items from the set
		set1.remove("Banana");
		System.out.println("\nSet 1 after removing 'Banana': " + set1);
		
		// Search the specified item in the set
		String searchItem = "Orange";
		if(set1.contains(searchItem)) {
			System.out.println("\n'" + searchItem + "' is found in Set 1");
		} else {
			System.out.println("\n'" + searchItem + "' is not found in Set 1");
		}
	}
}
