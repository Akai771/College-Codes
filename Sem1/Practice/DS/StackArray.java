package Practice.DS;
import java.util.Scanner;

public class StackArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of stack: ");
        int maxSize = sc.nextInt();
        int[] stack = new int[maxSize];
        int top = -1;
        int choice = 0;
        do{
            System.out.println("\nStack Operations Menu:");
            System.out.println("1. Push an element");
            System.out.println("2. Pop an element");
            System.out.println("3. Peek the top element");
            System.out.println("4. Display the stack");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // push
                    if (top == maxSize - 1){
                        System.out.println("Stack Full (Overflow)");
                    }
                    else{
                        System.out.println("Enter the element");
                        int val = sc.nextInt();
                        stack[++top] = val;
                        System.out.println(val + " pushed to stack");
                    }
                    break;
                
                case 2:
                    //Pop
                    if(top == -1){
                        System.out.println("Stack is empty");
                    }
                    else{
                        int popped = stack[top--];
                        System.out.println(popped + " has been popped from the stack");
                    }
                    break;
                
                case 3:
                    //Peek
                    if(top == -1){
                        System.out.println("Stack is empty");
                    }
                    else{
                        System.out.println("Stack top element: " + stack[top]);
                    }
                    break;
                
                case 4:
                    if (top == -1){
                        System.out.println("Stack is empty");
                    }
                    else{
                        System.out.println("Stack Elements");
                        for (int i = 0; i <= top; i++){
                            System.out.println(stack[i] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
        while(choice!=5);
    }
}
