// Hash Set

import java.util.*;

public class TestHashSet{
	public static void main(String[] args){
		Set<String> set = new HashSet<>(); // creating empty set
		set.add("London");
		set.add("Paris");
		set.add("Mumbai");
		System.out.println(set);// Set does not display data in sequential order
		// set doesn't acept duplicate elements 
		set.add("London");
		System.out.println(set);
		// Set does not display elements index wise
		// for (int i = 0; i<set.size();i++){
		//	System.out.println(set.get(i));
		//}
		// store the set elements in list
		List<Object> list = new LinkedList<>(set);
		// for (int i = 0; i<list.size(); i++){
			// System.out.println(list.get(i));
		// } 
		Set<String> lset = new LinkedHashSet<>(set);
		lset.add("Red");
		lset.add("Green");
		lset.add("Blue");
		System.out.println(lset);
	}
}