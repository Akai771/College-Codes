import java.util.*;

public class binarySearchTree {
    static class Node { // node class
        int data;
        Node left, right; // left and right child nodes

        Node(int data) { // constructor
            this.data = data; // assign data
        }
    }

    static Node root; // Root object of the BST

    static Node insert(Node root, int key) { 
        if (root == null)
            return new Node(key);
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        return root;
    }

    static Node delete(Node root, int key) {
        if (root == null)
            return null;
        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    static int height(Node root) {
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    static int findMax(Node root) {
        while (root.right != null)
            root = root.right;
        return root.data;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data + " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data + " ");
        }

    }

    static void displayTree(Node root, int space) {
        if (root == null)
            return;
        else {
            space += 10;
            displayTree(root.right, space);
            System.out.println("");
            for (int i = 10; i < space; i++)
                System.out.print(" ");
            System.out.println(root.data);
            displayTree(root.left, space);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, value;

        while (true) {
            System.out.println("\n----- BST Menu -----");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Height Of Tree");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Find Max");
            System.out.println("8. Find Min");
            System.out.println("9. Display Tree");
            System.out.println("10. Exit");

            System.out.print("\nEnter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Value to insert: ");
                    value = sc.nextInt();
                    root = insert(root, value);
                    System.out.println("Value inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    root = delete(root, value);
                    System.out.println("Value deleted successfully!");
                    break;

                case 3:
                    System.out.println("Height: " + height(root));
                    break;

                case 4:
                    System.out.println("Inorder Traversal:");
                    inorder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Preorder Traversal:");
                    preorder(root);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Postorder Traversal:");
                    postorder(root);
                    System.out.println();
                    break;

                case 7:
                    if (root != null)
                        System.out.println("Max: " + findMax(root));
                    else
                        System.out.println("Tree is empty!");
                    break;

                case 8:
                    if (root != null)
                        System.out.println("Min: " + findMin(root));
                    else
                        System.out.println("Tree is empty!");
                    break;

                case 9:
                    System.out.println("Displaying Tree:");
                    displayTree(root, 0);
                    break;

                case 10:
                    System.out.println("Exiting....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}