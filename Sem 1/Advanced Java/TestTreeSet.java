// WAP to create a tree set of integers and display the elements

import java.util.*;

public class TestTreeSet{
	public static void main(String[] args){
		Set<Integer> set = new TreeSet<>(); // creating empty set
		set.add(20);
		set.add(10);
		set.add(30);
		System.out.println(set);// Set does not display data in sequential order
	}
}