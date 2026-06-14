package Practical2;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array Size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " Elements:");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Array:");
        printArray(arr);
        System.out.println("Enter the Search Element:");
        int search = sc.nextInt();
        LinearSearchAlgo(arr, search);
        sc.close();
    }

    public static void LinearSearchAlgo(int[] arr, int search){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (arr[i] == search){
               System.out.println("Element found at " + i);
               break;
            }
            else if (i == n - 1){
                System.out.println("Element not found");
            }
        }
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
