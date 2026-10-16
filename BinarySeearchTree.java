import java.util.Scanner;

class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
}

public class BinarySeearchTree 
{
    Node root;
    Node insert(int value,Node root){
        if(root==null){
             return new Node(value);
        }

        if(value<root.data){
            root.left=insert(value,root.left);
        }else{
            root.right=insert(value,root.right);
        }
        return root;
    }

    


}
