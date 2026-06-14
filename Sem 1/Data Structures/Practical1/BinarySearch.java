// Binary Search
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements");
        for (int i = 0; i < n; i++){
                arr[i] = scanner.nextInt();
            }
        System.out.print("Enter the element to search: ");
        int search = scanner.nextInt();
        binarySearchWithSteps(arr, search);
        scanner.close();
    }
    public static void binarySearchWithSteps(int[] arr, int search){
        int low = 0;
        int high = arr.length - 1;
        boolean found = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == search) {
                System.out.println("Element found at " + mid);
                found = true;
                break;
            } else if (arr[mid] < search) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }
}