// Write a Java program using Map interface containing list of items having keys and associated values and perform the following operations:
// a. Add items in the map.
// b. Remove items from the map
// c. Search specific key from the map
// d. Get value of the specified key
// e. Insert map elements of one map in to other map.
// f. Print all keys and values of the map.

package Practicals.Practical4;
import java.util.*;

public class MapInterface {
    public static void main(String[] args){
		// Create a map container
		Map<String, Integer> marks = new HashMap<String,Integer>();
		marks.put("Rohit", 50);
		marks.put("Rahul", 40);
		marks.put("Rakesh", 30);
		marks.put("Ramesh", 20);
		marks.put("Rishabh", 10);

        // Perform various operations
		System.out.println(marks); // Print the map
		System.out.println("Marks is empty?:" + marks.isEmpty()); // Check if map is empty
		System.out.println("Size: " + marks.size()); // Get the size of the map
		System.out.println("Is Rohit in map: " + marks.containsKey("Rohit")); // Check if key exists
		System.out.println("All Values: " + marks.values()); // Get all values
		System.out.println("All Keys: " + marks.keySet()); // Get all keys
		marks.remove("Rishabh"); // Remove a key-value pair
		System.out.println("Updated Keys: " + marks); // Print updated map
		System.out.println("Updated Keys: " + marks.get("Rohit")); // Get value for a key

        // Create another map container
		Map<String, Integer> newMarks = new HashMap<String,Integer>();

		// Restore all the values of marks in marksheet
		newMarks.putAll(marks);
		System.out.println(newMarks);
		marks.clear();
		System.out.println(marks);
	}// main end
}// class end
