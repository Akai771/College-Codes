//Selection Sort

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the Array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements");
        for(int i=0;i < n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("original Array:");
        printArray(arr);
        selectionsort(arr);
        System.out.println("Sorted Array:");
        printArray(arr);
    }
    
    public static void selectionsort(int[] arr){
        int n = arr.length;
        for (int i=0; i < n-1; i++){
            int minIndex = i;
            for (int j = i+1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;    
        }
        System.out.println("\n After pass: " + (i + 1) +":");
        printArray(arr);
    }
    
    public static void printArray(int[] arr){
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

