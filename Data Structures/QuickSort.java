//Quick Sort

import java.util.Scanner;

public class QuickSort {
    private static int recursionLevel = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- Quick Sort -------");
        System.out.print("Enter the size of the Array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements");
        for(int i=0; i < n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("Original Array:");
        printArray(arr);
        System.out.println("\n--- Starting Quick Sort ---");
        quickSort(arr, 0, n - 1);
        System.out.println("\n--- Quick Sort Complete ---");
        System.out.println("Sorted Array:");
        printArray(arr);
        scanner.close();
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        recursionLevel++;
        String indent = getIndent(recursionLevel);
        
        System.out.println(indent + "QuickSort called: low=" + low + ", high=" + high);
        
        if (low < high) {
            System.out.println(indent + "Array segment to sort:");
            printArraySegment(arr, low, high, indent);
            
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);
            
            System.out.println(indent + "After partitioning around pivot " + arr[pivotIndex] + ":");
            printArraySegment(arr, low, high, indent);
            System.out.println(indent + "Pivot is at index " + pivotIndex);
            
            // Recursively sort elements before and after partition
            System.out.println(indent + "Sorting left subarray [" + low + " to " + (pivotIndex-1) + "]:");
            quickSort(arr, low, pivotIndex - 1);
            
            System.out.println(indent + "Sorting right subarray [" + (pivotIndex+1) + " to " + high + "]:");
            quickSort(arr, pivotIndex + 1, high);
        } else {
            System.out.println(indent + "Base case reached (low >= high), no sorting needed");
        }
        
        recursionLevel--;
    }
    
    public static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high];
        String indent = getIndent(recursionLevel + 1);
        
        System.out.println(indent + "Partitioning with pivot: " + pivot + " (index " + high + ")");
        
        // Index of smaller element indicates the right position of pivot found so far
        int i = (low - 1);
        
        for (int j = low; j <= high - 1; j++) {
            System.out.println(indent + "Comparing arr[" + j + "]=" + arr[j] + " with pivot " + pivot);
            
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // increment index of smaller element
                System.out.println(indent + "  " + arr[j] + " <= " + pivot + ", swapping arr[" + i + "] and arr[" + j + "]");
                
                // Swap elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                System.out.println(indent + "  After swap:");
                printArraySegment(arr, low, high, indent + "  ");
            } else {
                System.out.println(indent + "  " + arr[j] + " > " + pivot + ", no swap needed");
            }
        }
        
        // Swap the pivot element with the element at i+1
        System.out.println(indent + "Final step: placing pivot at correct position");
        System.out.println(indent + "Swapping pivot arr[" + high + "]=" + arr[high] + " with arr[" + (i+1) + "]=" + arr[i+1]);
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        System.out.println(indent + "Pivot " + arr[i+1] + " is now at index " + (i+1));
        
        return (i + 1);
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void printArraySegment(int[] arr, int low, int high, String indent) {
        System.out.print(indent);
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static String getIndent(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  "); // Two spaces per level
        }
        return sb.toString();
    }
}
