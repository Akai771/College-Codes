package Practice.DS;
import java.util.*;

public class ShellSort {

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
        shellSort(arr);
        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }

    public static void shellSort(int[] arr){
        int n = arr.length;
        int pass = 1;
        for(int gap = n/2; gap > 0; gap /= 2){
            System.out.println("Gap " + gap + " :");
            for(int i = gap; i < n; i++){
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap ){
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
                System.out.println("Pass " + pass + " :" + Arrays.toString(arr));
                pass++;
            }
        }
    }
}