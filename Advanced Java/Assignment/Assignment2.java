// Aim of this program to create list and use List Iterator interface. also print list in backward //direction
package Assignment;
import java.util.*;

class Assignment2 {
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
