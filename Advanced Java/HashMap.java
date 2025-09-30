// Hash Map
import java.util.*;

public class MapMethodsDemo{
	public static void main(String[] args){
		// Create a map container
		Map<String, Integer> marks = new HashMap<String,Integer>();
		marks.put("Rohit", 50);
		marks.put("Rahul", 40);
		marks.put("Rakesh", 30);
		marks.put("Ramesh", 20);
		marks.put("Rishabh", 10);
		System.out.println(marks);
		System.out.println("Marks is empty?:" + marks.isEmpty());
		System.out.println("Size: " + marks.size());
		System.out.println("Is Rohit in map: " + marks.containsKey("Rohit"));
		System.out.println("All Values: " + marks.values());
		System.out.println("All Keys: " + marks.keySet());
		marks.remove("Rishabh");
		System.out.println("Updated Keys: " + marks);
		System.out.println("Updated Keys: " + marks.get("Rohit"));

		Map<String, Integer> newMarks = new HashMap<String,Integer>();
		// Restore all the values of marks in marksheet
		newMarks.putAll(marks);
		System.out.println(newMarks);
		marks.clear();
		System.out.println(marks);
	}// main end
}// class end
