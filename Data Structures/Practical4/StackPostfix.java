package Practical4;
import java.util.Stack;

public class StackPostfix {
    // Function to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char ch: expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // Convert char to int
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (ch) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                    default: System.out.println("Invalid Operator: " + ch);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr = "231*+9-"; // Equivalent to (2 + (3*1)) - 9
        System.out.println("Postfix Expression: " + expr);
        System.out.println("Result = " + evaluatePostfix(expr));
    }
}
