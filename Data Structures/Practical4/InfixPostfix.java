package Practical4;
import java.util.*;

class InfixPostfix {
    static Scanner sc = new Scanner(System.in);

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }

    public static String infixToPostfix(String infix) {
        String operator = "+-/()";
        String result = "";
        char[] stack = new char[infix.length()];
        int top = -1;
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (!operator.contains(String.valueOf(ch))) {
                result += ch;
            } else if (ch == '(' || ch == ')') {
                if (ch == '(') {
                    stack[++top] = ch;
                } else {
                    while (top >= 0 && stack[top] != '(') {
                        result += stack[top--];
                    }
                    if (top >= 0 && stack[top] == '(') {
                        top--;
                    } else return "Invalid Expression";
                }
            } else {
                while (top >= 0 && precedence(stack[top]) >= precedence(ch)) {
                    result += stack[top--];
                }
                stack[++top] = ch;
            }

        }
        while (!(top == -1)) {
            result += stack[top--];
        }
        return result;
    }

    public static void main(String[] args) {
        String infix = "A(B+CD)+E";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }
}