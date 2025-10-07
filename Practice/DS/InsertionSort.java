package Practice.DS;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter" + n + "elements");
        for (int i = 0; i < n; i++){
                arr[i] = scanner.nextInt();
            }
        System.out.println("Original array: ");
        System.out.println(Arrays.toString(arr));
        insertionSortAlgo(arr);
        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }

    public static void insertionSortAlgo(int[] arr){
       int n = arr.length;
       for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];  
                j--;
            }
            arr[j+1] = key;
            System.out.println(Arrays.toString(arr));
       }
    }
}
