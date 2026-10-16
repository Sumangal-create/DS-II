import java.util.Scanner;
class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data=data;
        left=right=null;
    }
}

public class TreeLinkedList {
    static Scanner sc = new Scanner(System.in);

    static Node CreateTree(){
        System.out.println("Enter the node(-1 for no node): ");
        int data= sc.nextInt();

        if(data==-1) return null;

        Node root = new Node(data);

        System.out.println("Enter the left child of "+data);
        root.left= CreateTree();

        System.out.println("Enter the right child: ");
        root.right=CreateTree();

        return root;


    }
}
