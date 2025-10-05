package Practice;
import java.util.*;

public class BinarySearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Note: Enter the elements in sorted order!!!");
        System.out.println("Enter the " + n +" Elements");
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element to search: ");
        int search = sc.nextInt();
        binarySearchAlgo(arr, search);
        sc.close();
    }

    public static void binarySearchAlgo(int[] arr, int search){
        int low = 0;
        int high = arr.length - 1;
        boolean found = false;
        while(low <= high){
            int mid = (low + high)/2;
            if (arr[mid] == search){
                found = true;
                System.out.println("Element found at: " + mid);
                break;
            }
            else if(arr[mid] < search){
                low = mid + 1;
            }
            else if (arr[mid] > search){
                high = mid - 1;
            }
        }
        if (!found){
            System.out.println("Element not found");
        }
    }
}
