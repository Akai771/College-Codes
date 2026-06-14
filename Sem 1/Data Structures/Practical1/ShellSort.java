import java.util.Scanner;
import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- Shell Sort -------");
        System.out.print("Enter the size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        shellSort(arr);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements arr[0..gap-1] are already in gapped order.
            // Keep adding one more element until the entire array is gap sorted.
            for (int i = gap; i < n; i++) {
                // Save arr[i] in temp and make a hole at position i
                int temp = arr[i];

                // Shift earlier gap-sorted elements up until the correct
                // location for arr[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }
}
