package Practical5;
import java.util.*;

class OrdinaryQueue {
    public static void main(String[] args) {
        int front = -1;
        int rear = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the Queue: ");
        int n = sc.nextInt();

        int[] queue = new int[n];
        int choice;
        do {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (front == -1) {
                        front++;
                    }
                    if (rear == 5 ) {
                        System.out.println("Can not enqueue as queue is empty.");
                    } else {
                        System.out.println("Enter element to insert: ");
                        queue[rear++] = sc.nextInt();
                        System.out.println("Element inserted");
                    }
                    break;

                case 2:
                    if (front == -1 || front >= rear ) {
                        System.out.println("Can not dequeue as queue is full.");
                    } else {
                        front++;
                    }
                    break;

                case 3:
                    if (front == -1 || front >= rear) {
                        System.out.println("Can not show peek as queue is empty.");
                    } else {
                        System.out.println("First element is: " + queue[front]);
                    }
                    break;

                case 4:
                    if (front == -1 || front >= rear) {
                        System.out.println("Can not display as queue is empty.");
                    } else {
                        for (int i = front; i < rear; i++) {
                            System.out.print(queue[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println("Exiting from the application...");
                    break;

                default:
                    System.out.println("Wrong input kindly select again: ");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
