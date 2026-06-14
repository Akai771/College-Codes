// Write a Java program to create List containing list of items and use ListIterator interface to print items present in the list. 
// Also print the list in reverse / backward direction.

package Practicals.Practical2;
import java.util.*;

public class ListIteratorDemo {
    public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<>();
		l1.add(10);
		l1.add(50);
		l1.add(5);
		l1.add(30);
		
		System.out.println("List in Ascending order ");
		for(int i = 0; i < l1.size(); i++){
			System.out.print(l1.get(i) + " ");
		}
		System.out.println(); 

		System.out.println("List in Decending order ");
		ListIterator<Integer> itr = l1.listIterator(l1.size());
		while(itr.hasPrevious()) {
			System.out.print(itr.previous() + " ");
		}										
	}
}
