// Write a Java program to create a Set containing list of items of type String and print the items in the list using Iterator interface.
// Also print the list in reverse / backward direction.

package Practicals.Practical3;
import java.util.*;

public class SetIteratorDemo {
    public static void main(String[] args){
		Set<String> set = new HashSet<>();
		set.add("Raj");
		set.add("Ram");
		set.add("priya");

		System.out.print("Set Value in ascending order: ");
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		System.out.print("Set Value in Decending order : ");
		
		List<String> l1 = new ArrayList<>(set);
		
		ListIterator<String> itr1 = l1.listIterator(l1.size());
		while(itr1.hasPrevious()) {
			System.out.print(itr1.previous() + " ");
		}
	}
}
