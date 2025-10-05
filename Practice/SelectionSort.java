//Selection Sort

package Practice;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------- Selection Sort -------");
        System.out.print("Enter the size of the Array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the " + n + " elements");
        for(int i=0; i < n;i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println("original Array:");
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
        scanner.close();
    }
    
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int index = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            System.out.println("\n After pass: " + (i + 1) +":");
            System.out.println(Arrays.toString(arr));
        }
    }

    
    // public static void selectionSort(int[] arr){
    //     int n = arr.length;
    //     for (int i=0; i < n-1; i++){
    //         int index = i;
    //         for (int j = i+1; j < n; j++){
    //             if(arr[j] < arr[index]){
    //                 index = j;
    //             }
    //         }
    //         int temp = arr[index];
    //         arr[index] = arr[i];
    //         arr[i] = temp; 
    //         System.out.println("\n After pass: " + (i + 1) +":");
    //         printArray(arr);
    //     }
    // }
}
