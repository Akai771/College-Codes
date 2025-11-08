package Practical4;
import java.util.Stack;

public class StackParantheses {

    // Function to check balanced parentheses
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (!matches(top, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    // Helper method to match brackets
    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    // Main method
    public static void main(String[] args) {
        String expr1 = "({[]})";
        String expr2 = "([{}])";
        String expr3 = "([)]";

        System.out.println(expr1 + " -> " + (isBalanced(expr1) ? "Balanced": "Not Balanced"));
        System.out.println(expr2 + " -> " + (isBalanced(expr2) ? "Balanced": "Not Balanced"));
        System.out.println(expr3 + " -> " + (isBalanced(expr3) ? "Balanced": "Not Balanced"));
    }
}
