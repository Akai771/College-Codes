import java.util.Scanner;

public class SparseMatrix {
    // Node representing non-zero element
    static class SparseNode {
        int row, col, value;
        SparseNode next;

        SparseNode(int r, int c, int v) {
            row = r;
            col = c;
            value = v;
            next = null;
        }
    }

    // Sparse Matrix using linked list
    static class SparseListMatrix {
        SparseNode head = null;
        int rows, cols;

        SparseListMatrix(int r, int c) {
            rows = r;
            cols = c;
        }

        // Insert non-zero element
        void insert(int r, int c, int v) {
            if (v == 0) {
                System.out.println("Zero is not stored in sparse matrix.");
                return;
            }
            SparseNode newNode = new SparseNode(r, c, v);
            if (head == null) {
                head = newNode;
                return;
            }
            SparseNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }

        // Display linked list of sparse entries
        void displayList() {
            System.out.println("\nRow\tCol\tValue");
            System.out.println("------------------------");
            SparseNode temp = head;
            while (temp != null) {
                System.out.println(temp.row + "\t" + temp.col + "\t" + temp.value);
                temp = temp.next;
            }
        }

        // Display full matrix
        void displayFullMatrix() {
            int[][] matrix = new int[rows][cols];
            SparseNode temp = head;
            while (temp != null) {
                matrix[temp.row][temp.col] = temp.value;
                temp = temp.next;
            }
            System.out.println("\nFull Matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");

        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        SparseListMatrix sm = new SparseListMatrix(rows, cols);
        System.out.print("Enter number of non-zero elements: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for non-zero element " + i);
            System.out.print("Row index: ");
            int r = sc.nextInt();
            System.out.print("Column index: ");
            int c = sc.nextInt();
            System.out.print("Value (non-zero): ");
            int v = sc.nextInt();
            sm.insert(r, c, v);
        }
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Display Sparse List");
            System.out.println("2. Display Full Matrix");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    sm.displayList();
                    break;
                case 2:

                    sm.displayFullMatrix();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}