class Node {
    int coeff;
    int pow;
    Node next;

    Node(int c, int p) {
        coeff = c;
        pow = p;
        next = null;
    }
}

public class PolynomialAddition {
    // Function to add two polynomials
    public static Node addPolynomials(Node poly1, Node poly2) {
        Node result = new Node(0, 0);
        Node temp = result;

        while (poly1 != null && poly2 != null) {
            if (poly1.pow > poly2.pow) {
                temp.next = new Node(poly1.coeff, poly1.pow);
                poly1 = poly1.next;
            } else if (poly1.pow < poly2.pow) {
                temp.next = new Node(poly2.coeff, poly2.pow);
                poly2 = poly2.next;
            } else {
                temp.next = new Node(poly1.coeff + poly2.coeff, poly1.pow);
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
            temp = temp.next;
        }

        while (poly1 != null) {
            temp.next = new Node(poly1.coeff, poly1.pow);
            poly1 = poly1.next;
            temp = temp.next;
        }

        while (poly2 != null) {
            temp.next = new Node(poly2.coeff, poly2.pow);
            poly2 = poly2.next;
            temp = temp.next;
        }

        return result.next;
    }

    // Function to print polynomial
    public static void printPolynomial(Node poly) {
        while (poly != null) {
            System.out.print(poly.coeff + "x^" + poly.pow);
            poly = poly.next;
            if (poly != null)
                System.out.print(" + ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // First polynomial: 5x^2 + 4x^1 + 2
        Node poly1 = new Node(5, 2);
        poly1.next = new Node(4, 1);
        poly1.next.next = new Node(2, 0);

        // Second polynomial: 5x^1 + 5
        Node poly2 = new Node(5, 1);
        poly2.next = new Node(5, 0);

        System.out.print("Polynomial 1: ");
        printPolynomial(poly1);

        System.out.print("Polynomial 2: ");
        printPolynomial(poly2);

        Node sum = addPolynomials(poly1, poly2);
        System.out.print("Sum of Polynomials: ");
        printPolynomial(sum);
    }
}
