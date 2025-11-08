// Insertion Sort

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Input Size of the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter" + n + "elements");
        for (int i = 0; i < n; i++){
                arr[i] = scanner.nextInt();
            }
        System.out.println("Original array: ");
        printArray(arr);
        // perform insertion sort with steps
        insertionSortWithSteps(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
        scanner.close();
    }
    // Insertion sort with step by step output
    public static void insertionSortWithSteps(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i]; //Current element to be inserted in key
            int j = i - 1;
            //Move elements of the sorted portion that are greater than key
            while (j >= 0 && arr[j] > key ){
                arr [j+1] = arr[j];
                j--;
            }
            // insert the correct element at the correct position
            arr[j + 1] = key;
            // Print the array after each insertion
            System.out.println("\nAfter inserting elements for pass " + i);
            printArray(arr);
        }
    }
    
    // Utility method to print array
    public static void printArray(int[] arr){
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
        
    }
}