package Assignment;
import java.util.*;

class Assignment3 {
	public static void main(String[] args){
		Set<String> set = new HashSet<>();
		set.add("Raj");
		set.add("Ram");
		set.add("priya");

		System.out.println("Set Value in ascending order ");
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		System.out.println("Set Value in Decending order ");
		
		List<String> l1 = new ArrayList<>(set);
		
		ListIterator<String> itr1 = l1.listIterator(l1.size());
		while(itr1.hasPrevious()) {
			System.out.print(itr1.previous() + " ");
		}
	}
}