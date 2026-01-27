package Practical7;

import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class DoublyCircularLinkedList {

    private Node head = null;

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            last.next = newNode;
            newNode.prev = last;

            newNode.next = head;
            head.prev = newNode;
        }

        System.out.println("Inserted: " + data);
    }

    // Delete element by searching
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        Node curr = head;

        do {
            // If node to delete is found
            if (curr.data == data) {

                // Only one node in list
                if (curr.next == curr) {
                    head = null;
                } 
                // Deleting head node
                else if (curr == head) {
                    Node last = head.prev;
                    head = head.next;
                    head.prev = last;
                    last.next = head;
                } 
                // Deleting any other node
                else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }

                System.out.println("Deleted: " + data);
                return;
            }
            curr = curr.next;
        } while (curr != head);

        System.out.println("Element not found.");
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.print("Doubly Circular Linked List: ");
        Node temp = head;

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList dcll = new DoublyCircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int data = scanner.nextInt();
                    dcll.insert(data);
                    break;

                case 2:
                    System.out.print("Enter data to delete: ");
                    int deleteData = scanner.nextInt();
                    dcll.delete(deleteData);
                    break;

                case 3:
                    dcll.display();
                    break;

                case 4:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
