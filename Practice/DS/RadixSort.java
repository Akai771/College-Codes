package Practice.DS;
import java.util.*;


public class RadixSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- Radix Sort -------");
        System.out.print("Enter the size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }

    public static void radixSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digitIndex = (arr[i] / exp) % 10;
            output[count[digitIndex] - 1] = arr[i];
            count[digitIndex]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
