package Practice.DS;
import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Original array:");
        System.out.print(Arrays.toString(arr));
        bubbleSortAlgo(arr);
        sc.close();
    }

    public static void bubbleSortAlgo(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            boolean swapped = false;
            System.out.print("Pass " + (i + 1) + " :");
            System.out.print(Arrays.toString(arr));
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        } 
    }
}
