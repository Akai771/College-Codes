//Radix Sort

import java.util.Scanner;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- Radix Sort -------");
        System.out.print("Enter the size of the Array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements");
        for(int i=0; i < n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("Original Array:");
        printArray(arr);
        radixSort(arr);
        System.out.println("Sorted Array:");
        printArray(arr);
        scanner.close();
    }
    
    public static void radixSort(int[] arr) {
        int n = arr.length;
        System.out.println("Array Length: " + n);
        
        // Find the maximum number to know number of digits
        int max = getMax(arr);
        System.out.println("Maximum number in array: " + max);
        
        // Do counting sort for every digit position
        // exp is 10^i where i is current digit number
        int digitPosition = 1;
        for (int exp = 1; max / exp > 0; exp *= 10) {
            System.out.println("\n--- Sorting by digit position " + digitPosition + " (divisor = " + exp + ") ---");
            countingSort(arr, exp);
            System.out.println("After sorting by digit position " + digitPosition + ":");
            printArray(arr);
            digitPosition++;
        }
    }
    
    // A function to do counting sort of arr[] according to the digit represented by exp
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10];
        
        // Initialize count array as 0
        Arrays.fill(count, 0);
        
        // Store count of occurrences of each digit
        for (int i = 0; i < n; i++) {
            int digit = getDigit(arr[i], exp);
            count[digit]++;
            System.out.println("Element " + arr[i] + " has digit " + digit + " at current position");
        }
        
        System.out.println("Count array after counting digits:");
        printArray(count);
        
        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        System.out.println("Count array after calculating positions:");
        printArray(count);
        
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = getDigit(arr[i], exp);
            output[count[digit] - 1] = arr[i];
            count[digit]--;
            System.out.println("Placed " + arr[i] + " at position " + count[digit] + " in output array");
        }
        
        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to current digit
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    
    // A utility function to get the digit at the specified position
    public static int getDigit(int number, int exp) {
        return (number / exp) % 10;
    }
    
    // A utility function to get maximum value in arr[]
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
