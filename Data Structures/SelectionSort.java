//Selection Sort

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- Selection Sort -------");
        System.out.print("Enter the size of the Array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements");
        for(int i=0; i < n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("original Array:");
        printArray(arr);
        selectionSort(arr);
        System.out.println("Sorted Array:");
        printArray(arr);
        scanner.close();
    }
    
    public static void selectionSort(int[] arr){
        int n = arr.length;
        System.out.println("N Value: " + n);
        for (int i=0; i < n-1; i++){
            int minIndex = i;
            System.out.println("Min Index Value for i: " + minIndex);
            for (int j = i+1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                    System.out.println("Min Index Value for j: " + minIndex);
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp; 
            System.out.println("Min Index Array: " + arr[minIndex]);
            System.out.println("i Array: " + arr[i]);
            
            System.out.println("\n After pass: " + (i + 1) +":");
            printArray(arr);
        }
    }
    
    public static void printArray(int[] arr){
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
