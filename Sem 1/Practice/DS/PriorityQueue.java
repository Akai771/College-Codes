package Practice.DS;
import java.util.Scanner;

public class PriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Size of queue: ");
        int n = sc.nextInt();

        int[] data = new int[n];
        int[] priority = new int[n];
        int size = 0;
        int choice;

        do{
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if(size == n){
                        System.out.println("The queue is full");
                    }
                    else{
                        System.out.println("Enter the element: ");
                        int val = sc.nextInt();
                        System.out.println("Enter Priority: ");
                        int pr = sc.nextInt();

                        int i;
                        for(i = size - 1; i >= 0; i--){
                            if(pr > priority[i]){
                                data[i+1] = data[i];
                                priority[i+1] = priority[i];
                            }
                            else{
                                break;
                            }
                        }
                        data[i + 1] = val;
                        priority[i + 1] = pr;
                        size++;
                    }
                    break;

                case 2:
                    if (size == 0) {
                        System.out.println("The Queue is empty");
                    }
                    else{
                        System.out.println("Deleted element " + data[0] + " (Priority " + priority[0] + ")");
                        for(int i = 1; i < size; i++){
                            data[i-1] = data[i];
                            priority[i-1] = priority[i];
                        }
                        size--;
                    }
                    break;
            
                case 3:
                    if(size == 0){
                        System.out.println("The queue is empty");
                    }
                    else{
                        System.out.println("Data\tPriority");
                        for(int i = 0; i < size; i++){
                            System.out.println(data[i] + "\t" + priority[i]);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    break;
            
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while(choice != 4);
    }
}
