package Practical10;
import java.util.Scanner;

public class MaxHeap {

    static int[] heap;
    static int size = 0;
    static int capacity;


    static int parent(int i) {
        return (i - 1) / 2;
    }

    static int left(int i) {
        return 2 * i + 1;
    }

    static int right(int i) {
        return 2 * i + 2;
    }

    static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    static void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap Overflow!");
            return;
        }

        heap[size] = key;
        int i = size;
        size++;

        // Heapify Up
        while (i != 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }


    static void heapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] > heap[largest])
            largest = l;

        if (r < size && heap[r] > heap[largest])
            largest = r;

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    static void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }


    static void heapSort() {
        buildHeap();

        int tempSize = size;
        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            heapify(0);
        }
        size = tempSize;
        System.out.println("Heap Sort Completed.");
    }


    static void delete(int key) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (heap[i] == key) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Value not found!");
            return;
        }

        heap[index] = heap[size - 1];
        size--;
        heapify(index);

        System.out.println("Deleted " + key);
    }


    static void display() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        System.out.print("Max Heap: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter heap capacity: ");
        capacity = sc.nextInt();
        heap = new int[capacity];

        int choice;
        do {
            System.out.println("\n--- MAX HEAP MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Build Heap (Heapify)");
            System.out.println("3. Heap Sort");
            System.out.println("4. Delete a value");
            System.out.println("5. Display Heap");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    insert(sc.nextInt());
                    break;

                case 2:
                    buildHeap();
                    System.out.println("Heap built using heapify.");
                    break;

                case 3:
                    heapSort();
                    break;

                case 4:
                    System.out.print("Enter value to delete: ");
                    delete(sc.nextInt());
                    break;

                case 5:
                    display();
                    break;
            }

        } while (choice != 6);

        sc.close();
    }
}
