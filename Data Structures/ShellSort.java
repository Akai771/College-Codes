//Shell Sort

import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- Shell Sort -------");
        System.out.print("Enter the size of the Array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements");
        for(int i=0; i < n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("Original Array:");
        printArray(arr);
        shellSort(arr);
        System.out.println("Sorted Array:");
        printArray(arr);
        scanner.close();
    }
    
    public static void shellSort(int[] arr) {
        int n = arr.length;
        System.out.println("Array Length: " + n);
        
        // Start with a big gap, then reduce the gap
        int gapSequence = 1;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("\n=== Gap Sequence " + gapSequence + ": Gap = " + gap + " ===");
            
            // Do a gapped insertion sort for this gap size
            // The first gap elements arr[0..gap-1] are already in gapped order
            // Keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // Add arr[i] to the elements that have been gap sorted
                // Save arr[i] in temp and make a hole at position i
                int temp = arr[i];
                System.out.println("Processing element at index " + i + " (value = " + temp + ")");
                
                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    System.out.println("  Comparing " + temp + " with arr[" + (j - gap) + "] = " + arr[j - gap]);
                    System.out.println("  " + arr[j - gap] + " > " + temp + ", shifting " + arr[j - gap] + " from index " + (j - gap) + " to index " + j);
                    arr[j] = arr[j - gap];
                }
                
                // Put temp (the original arr[i]) in its correct location
                if (j != i) {
                    System.out.println("  Placing " + temp + " at index " + j);
                    arr[j] = temp;
                } else {
                    System.out.println("  " + temp + " is already in correct position at index " + i);
                }
                
                System.out.println("  Array after processing index " + i + ":");
                printArray(arr);
            }
            
            System.out.println("Array after gap " + gap + " sorting:");
            printArray(arr);
            gapSequence++;
        }
        
        System.out.println("\nShell Sort Complete! Final gap was 1 (regular insertion sort)");
    }
    
    public static void printArray(int[] arr) {
        System.out.print("  ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
