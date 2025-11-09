package Practical4;

public class StackParantheses {
    static int top = -1;

    // Push operation
    public static void push(char[] stack, char ch) {
        stack[++top] = ch;
    }

    // Pop operation
    public static char pop(char[] stack) {
        char ch = stack[top];
        stack[top--] = '\0';
        return ch;
    }

    // Check if stack is empty
    public static boolean isEmpty() {
        return top == -1;
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    // Function to check balanced parentheses
    public static boolean isBalanced(String expression) {
        char[] stack = new char[expression.length()];
        top = -1; // Reset top for each new expression

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                push(stack, ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (isEmpty())
                    return false;

                char topChar = pop(stack);
                if (!matches(topChar, ch))
                return false;
            }
        }
        return isEmpty();
    }

    // Main method
    public static void main(String[] args) {
        String expr1 = "({[]})";
        String expr2 = "([{}])";
        String expr3 = "([)]";

        System.out.println(expr1 + " -> " + (isBalanced(expr1) ? "Balanced" : "Not Balanced"));
        System.out.println(expr2 + " -> " + (isBalanced(expr2) ? "Balanced" : "Not Balanced"));
        System.out.println(expr3 + " -> " + (isBalanced(expr3) ? "Balanced" : "Not Balanced"));
    }
}
