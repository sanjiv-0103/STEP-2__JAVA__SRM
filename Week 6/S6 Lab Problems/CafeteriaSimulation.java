import java.util.Scanner;

class CafeteriaQueue {
    private String[] queue;
    private int front, rear, size;

    CafeteriaQueue(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(String name) {
        if (size == queue.length) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = name;
        size++;
        System.out.println("Added: " + name);
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. No students to serve.");
            return;
        }
        System.out.println("Served: " + queue[front]);
        front = (front + 1) % queue.length;
        size--;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue: []");
            return;
        }
        System.out.print("Queue: [");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % queue.length;
            System.out.print(queue[index]);
            if (i < size - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}

public class CafeteriaSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CafeteriaQueue cq = new CafeteriaQueue(50);

        while (true) {
            System.out.println("\n1. Add Student\n2. Serve Student\n3. Show Queue\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    cq.enqueue(name);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.display();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
