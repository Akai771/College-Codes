package Practice.DS;
import java.util.*;

public class InfixPostfix {
    static Scanner sc = new Scanner(System.in);
    static int precedence(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            
            case '*':
            case '/':
                return 2;

            default:
                return -1;
        }
    }

    public static String infixToPostfix(String infix) {
        String operator = "+-*/";
        String result = "";
        char[] stack = new char[infix.length()];
        int top = -1;
        for(int i = 0; i < infix.length(); i++){
            char ch = infix.charAt(i);
            if(ch == ' '){
                continue;
            }

            if(!operator.contains(String.valueOf(ch))){
                result += ch;
            }
            else{
                while(top >= 0 && precedence(stack[top])>= precedence(ch)){
                    result += stack[top--];
                }
            }
        }
        while (!(top == -1)) {
            result += stack[top--];
        }
        return result;
    }

    public static void main(String[] args) {
        String infix = "A*B+C*D+E";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix: " + infix); 
        System.out.println("Postfix: " + postfix); 
    }
}
