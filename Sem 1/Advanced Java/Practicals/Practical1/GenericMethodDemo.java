// Write a Java Program to demonstrate a Generic Method.

package Practicals.Practical1;

public class GenericMethodDemo {
    public static void main(String[] args){
		int[] i = {1,2,3,4,5}; // primitive data type
		Integer[] integers={1,2,3,4,5}; //non-primitive data type
		String[] strings={"Mumbai", "Pune", "Delhi"};
		printArray(strings);
		printArray(integers);On
	} //end main
	
	public static<E> void printArray(E[] value){
		for (int i=0; i<value.length; i++){
			System.out.println("Value at index "+ i + " : " + value[i]);	
		}
		System.out.println("-----------------------");
	}
}// end
