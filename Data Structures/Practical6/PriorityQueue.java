package Practical6;
import java.util.Scanner;

class PriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the Queue: ");
        int n = sc.nextInt();
        
        int[] data = new int[n];
        int[] priority = new int[n];
        int size = 0;
        
        int choice;
        do {
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Insert
                    if (size == n) {
                        System.out.println("Cannot insert as queue is full.");
                    } else {
                        System.out.println("Enter element: ");
                        int value = sc.nextInt();
                        System.out.println("Enter priority: ");
                        int pr = sc.nextInt();
                        
                        int i;
                        for (i = size - 1; i >= 0; i--) {
                            if (pr > priority[i]) {
                                data[i + 1] = data[i];
                                priority[i + 1] = priority[i];
                            } else {
                                break;
                            }
                        }
                        data[i + 1] = value;
                        priority[i + 1] = pr;
                        size++;
                        System.out.println("Element inserted");
                    }
                    break;

                case 2:
                    // Delete
                    if (size == 0) {
                        System.out.println("Cannot delete as queue is empty.");
                    } else {
                        System.out.println("Deleted element: " + data[0] + " (Priority " + priority[0] + ")");
                        for (int i = 1; i < size; i++) {
                            data[i - 1] = data[i];
                            priority[i - 1] = priority[i];
                        }
                        size--;
                    }
                    break;

                case 3:
                    // Display
                    if (size == 0) {
                        System.out.println("Cannot display as queue is empty.");
                    } else {
                        System.out.println("Element\tPriority");
                        for (int i = 0; i < size; i++) {
                            System.out.println(data[i] + "\t" + priority[i]);
                        }
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting from the application...");
                    break;

                default:
                    // Error Handling
                    System.out.println("Wrong input kindly select again: ");
                    break;
            }
        } while (choice != 4);
        sc.close();
    }
}
