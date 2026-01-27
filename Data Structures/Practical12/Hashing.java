package Practical12;
import java.util.*;

public class Hashing {
    static final int SIZE = 10;
    static int[] linearTable = new int[SIZE];
    static int[] quadTable = new int[SIZE];
    static int[] doubleTable = new int[SIZE];
    static LinkedList<Integer>[] chainTable = new LinkedList[SIZE];

    static void init() {
        for (int i = 0; i < SIZE; i++) {
            linearTable[i] = quadTable[i] = doubleTable[i] = -1;
            chainTable[i] = new LinkedList<>();
        }
    }

    static int hash1(int key) {
        return key % SIZE;
    }

    static int hash2(int key) {
        return 1 + (key % (SIZE - 1));
    }

    static void linearInsert(int key) {
        int index = hash1(key);
        while (linearTable[index] != -1) {
            index = (index + 1) % SIZE;
        }
        linearTable[index] = key;
    }

    static void quadraticInsert(int key) {
        int index = hash1(key);
        int i = 1;
        while (quadTable[index] != -1) {
            index = (hash1(key) + i * i) % SIZE;
            i++;
        }
        quadTable[index] = key;
    }

    static void doubleInsert(int key) {
        int index = hash1(key);
        int step = hash2(key);
        int i = 1;
        while (doubleTable[index] != -1) {
            index = (hash1(key) + i * step) % SIZE;
            i++;
        }
        doubleTable[index] = key;
    }

    static void chainInsert(int key) {
        int index = hash1(key);
        chainTable[index].add(key);
    }

    static void display(int[] table, String name) {
        System.out.println(name);
        for (int i = 0; i < SIZE; i++)
            System.out.println(i + " -> " + table[i]);
    }

    static void displayChain() {
        System.out.println("Chaining Table");
        for (int i = 0; i < SIZE; i++)
            System.out.println(i + " -> " + chainTable[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        while (true) {
            System.out.println("\n1.Linear 2.Quadratic 3.Double 4.Chaining");
            System.out.println("5.Display All 6.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            if (ch == 6)
                break;
            if (ch >= 1 && ch <= 4) {
                System.out.print("Enter key: ");
                int key = sc.nextInt();
                if (ch == 1)
                    linearInsert(key);
                if (ch == 2)
                    quadraticInsert(key);
                if (ch == 3)
                    doubleInsert(key);
                if (ch == 4)
                    chainInsert(key);
            }
            if (ch == 5) {
                display(linearTable, "Linear Probing");
                display(quadTable, "Quadratic Probing");
                display(doubleTable, "Double Hashing");
                displayChain();
            }
        }
        sc.close();
    }
}