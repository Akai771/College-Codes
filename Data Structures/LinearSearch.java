// Linear Search

import java.util.Scanner;

public class LinearSearch {
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
        System.out.print("Enter the element to search: ");
        int search = scanner.nextInt();
        // perform insertioan sort with steps
        linearSearchWithSteps(arr, search);
        scanner.close();
    }
    // Linear search with step by step output
    public static void linearSearchWithSteps(int[] arr, int search){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if(arr[i] == search){
                System.out.println("Element found at " + i);
            }
            else{
                continue;
            }
        }
    }
}
