import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the " + n + " elements:");
        for(int i=0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // Call the quickSort method to sort the entire array
        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }

    public static void quickSort(int[] arr, int low, int high) {
        // The base case: if the segment has 1 or 0 elements, it's already sorted.
        if (low < high) {
            // Find the pivot element such that elements smaller than pivot are on the left,
            // and elements greater than pivot are on the right.
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the two sub-arrays
            quickSort(arr, low, pivotIndex - 1);  // Sort left sub-array
            quickSort(arr, pivotIndex + 1, high); // Sort right sub-array
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as the pivot
        int pivot = arr[high];

        // i is the index of the smaller element, acts as a boundary
        int i = (low - 1);

        // Iterate through the array segment
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++; // Move the boundary of the smaller element region

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // After the loop, the correct position for the pivot is (i + 1).
        // Swap the pivot (arr[high]) into its final sorted place.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        System.out.println("Pivot " + pivot + " placed at index " + (i + 1) + ": " + Arrays.toString(arr));

        // Return the index where the pivot was placed
        return (i + 1);
    }
}