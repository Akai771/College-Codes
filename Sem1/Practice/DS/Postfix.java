package Practice.DS;

import java.util.*;

public class Postfix {
    static int top = -1;

    public static int pop(int[] stack) {
        int num = stack[top];
        stack[top--] = 0;
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "23 3 +";
        int[] stack = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int num = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                i--;
                stack[++top] = num;
            }

            else {
                int num1;
                int num2;
                switch (str.charAt(i)) {
                    case '+':
                        num2 = pop(stack);
                        num1 = pop(stack);
                        stack[++top] = num1 + num2;
                        break;

                    case '-':
                        num2 = pop(stack);
                        num1 = pop(stack);
                        stack[++top] = num1 - num2;
                        break;

                    case '*':
                        num2 = pop(stack);
                        num1 = pop(stack);
                        stack[++top] = num1 * num2;
                        break;

                    case '/':
                        num2 = pop(stack);
                        num1 = pop(stack);
                        stack[++top] = num1 / num2;
                        break;

                    default:
                        break;
                }
            }
        }
        System.out.println("Value of the postfix expression is: " + stack[0]);
        sc.close();
    }
}
