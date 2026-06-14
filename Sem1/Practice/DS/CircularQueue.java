package Practice.DS;
import java.util.Scanner;

public class CircularQueue {
    public static void main(String[] args) {
        int front = 0;
        int rear = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the queue");
        int n = sc.nextInt();
        int[] queue = new int[n + 1];
        int choice;

        do{
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //Enqueue
                    if((rear + 1) % (n + 1) == front ){
                        System.out.println("The Queue is full");
                    }
                    else{
                        System.out.print("Enter the Element: ");
                        queue[rear] = sc.nextInt();
                        rear = (rear + 1) % (n + 1);
                        System.out.println("Element Inserted");
                    }
                    break;

                case 2:
                    //Dequeue
                    if(front == rear){
                        System.out.println("The Queue is empty");
                    }
                    else{
                        System.out.println(queue[front] + "element is removed");
                        front = (front + 1) % (n + 1);
                    }
                    break;
                
                case 3:
                    //Peek
                    if (front == rear){
                        System.out.println("The Queue is empty");
                    }
                    else{
                        System.out.println("The First element is: " + queue[front]);
                    }
                    break;

                case 4:
                    //Display
                    if (front == rear){
                        System.out.println("The Queue is empty");
                    }
                    else{
                        System.out.println("Queue Elements: ");
                        int i = front;
                        while(i != rear){
                            System.out.println(queue[i] + " ");
                            i = (i+1) % (n + 1);
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    //Exit
                    System.out.println("Exiting...");
                    sc.close();
                    break;

                default:
                    // Error Handling
                    System.out.println("Invalid Choice");
                    break;
            }
        }while(choice != 5);
    }
}
