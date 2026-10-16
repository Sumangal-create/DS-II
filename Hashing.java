import java.util.Scanner;

public class Hashing {

    static int size = 10;

    // Linear & Quadratic tables
    static int[] linear = new int[size];
    static int[] quadratic = new int[size];

    // Chaining (array of linked lists)
    static Node[] chain = new Node[size];

    // Node for chaining
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Initialize tables
    static void init() {
        for (int i = 0; i < size; i++) {
            linear[i] = -1;
            quadratic[i] = -1;
            chain[i] = null;
        }
    }

    // ================= LINEAR PROBING =================
    static void insertLinear(int value){
        int index = value % size;

        while (linear[index] != -1) {
            index = (index + 1) % size;
        }

        linear[index] = value;
    }

    static void displayLinear() {
        System.out.println("Linear Probing Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + linear[i]);
        }
    }

    // ================= QUADRATIC PROBING =================
    static void insertQuadratic(int value) {
        int index = value % size;
        int i = 1;

        while (quadratic[index] != -1) {
            index = (value + i * i) % size;
            i++;
        }

        quadratic[index] = value;
    }

    static void displayQuadratic() {
        System.out.println("Quadratic Probing Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + quadratic[i]);
        }
    }

    // ================= CHAINING =================
    static void insertChaining(int value) {
        int index = value % size;

        Node newNode = new Node(value);

        if (chain[index] == null) {
            chain[index] = newNode;
        } else {
            Node temp = chain[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    static void displayChaining() {
        System.out.println("Chaining Table:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " -> ");
            Node temp = chain[i];
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("NULL");
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();

        int choice, val;

        do {
            System.out.println("\n1.Insert Linear 2.Insert Quadratic 3.Insert Chaining");
            System.out.println("4.Display Linear 5.Display Quadratic 6.Display Chaining 7.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    insertLinear(val);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    insertQuadratic(val);
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    insertChaining(val);
                    break;

                case 4:
                    displayLinear();
                    break;

                case 5:
                    displayQuadratic();
                    break;

                case 6:
                    displayChaining();
                    break;

                case 7:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 7);
    }
}
    

