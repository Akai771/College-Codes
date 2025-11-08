package Practical6;
import java.util.Scanner;

class PriorityQueue {
    int[] data;
    int[] priority;
    int size;
    int capacity;

    PriorityQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        priority = new int[capacity];
        size = 0;
    }

    void enqueue(int value, int pr) {
        if (size == capacity) {
            System.out.println("Queue Overflow!");
            return;
        }
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (pr > priority[i]) {
                data[i + 1] = data[i];
                priority[i +
                        1] = priority[i];
            } else {
                break;
            }
        }
        data[i + 1] = value;
        priority[i + 1] = pr;
        size++;
    }

    void dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow!");
            return;
        }
        System.out.println("Deleted Element: " + data[0] + " (Priority " + priority[0] + ")");
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
            priority[i -
                    1] = priority[i];
        }
        size--;
    }

    void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Element\tPriority");
        for (int i = 0; i < size; i++) {
            System.out.println(data[i] + "\t" + priority[i]);
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Insert\n2. Delete\n3. Display\n4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int val = sc.nextInt();
                    System.out.print("Enter priority: ");
                    int pr = sc.nextInt();
                    pq.enqueue(val,
                            pr);
                    break;
                case 2:
                    pq.dequeue();
                    break;
                case 3:
                    pq.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }
}
