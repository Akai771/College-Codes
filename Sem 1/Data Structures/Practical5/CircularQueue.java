package Practical5;
import java.util.*;

class CircularQueue {
    public static void main(String[] args) {
        int front = 0;
        int rear = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the Queue: ");
        int n = sc.nextInt();

        int[] queue = new int[n + 1]; // +1 to differentiate full vs empty
        int choice;
        do {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Enqueue
                    if ((rear + 1) % (n + 1) == front) {
                        System.out.println("Cannot enqueue as queue is full.");
                    } else {
                        System.out.println("Enter element to insert: ");
                        queue[rear] = sc.nextInt();
                        rear = (rear + 1) % (n + 1);
                        System.out.println("Element inserted");
                    }
                    break;

                case 2:
                    // Dequeue
                    if (front == rear) {
                        System.out.println("Cannot dequeue as queue is empty.");
                    } else {
                        System.out.println("Deleted element: " + queue[front]);
                        front = (front + 1) % (n + 1);
                    }
                    break;

                case 3:
                    // Peek
                    if (front == rear) {
                        System.out.println("Cannot show peek as queue is empty.");
                    } else {
                        System.out.println("First element is: " + queue[front]);
                    }
                    break;

                case 4:
                    // Display
                    if (front == rear) {
                        System.out.println("Cannot display as queue is empty.");
                    } else {
                        System.out.println("Queue elements:");
                        int i = front;
                        while (i != rear) {
                            System.out.print(queue[i] + " ");
                            i = (i + 1) % (n + 1);
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    // Exiting
                    System.out.println("Exiting from the application...");
                    break;

                default:
                    // Error Handling
                    System.out.println("Wrong input kindly select again: ");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}