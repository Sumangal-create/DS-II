import java.util.Scanner;
public class Linear_quadratic_chaining {
    static int size=10;

    static int[] linear = new int[size];
    static int[] quadratic = new int[size];

    static Node []chain= new Node[size];

   static class Node{
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }

    static void init(){
        for(int i=0;i<size;i++){
            linear[i]=-1;
            quadratic[i]=-1;
            chaining[i]=null;
        }
    }

    static void LinearProbing(int value){
        int index = value%size;

        while(linear[index]!=-1){
            index=(index+1)%size;
        }
        linear[index]=value;
    }

    static void displayLinear(){
        System.out.println("Linear Probing: ");
        for(int i=0;i<size;i++){
            System.out.println(i+"->"+linear[i]);
        }
    }

    static void QuadraticProbing(int value){
        int index=value%size;
        int i=1;

        while(quadratic[index]!=-1){
            index=(index+i*i)%size;
            i++;
        }
        quadratic[index]=value;
    }

    static void DisplayQuadratic(){
        System.out.println("Quadratic probing: ");
        for(int i=0;i<size;i++){
            System.out.println(i+"->"+quadratic[i]);
        }
    }

    static void Chaining(int value){
       int index= value%size;
       Node newNode = new Node(value);

       if(chain[index]==null){
            chain[index]=newNode;
        } else{
            Node temp = chain[index];
                while(temp.next!=null){
                    temp=temp.next;
                }
             temp.next=newNode;
       }
    }

    static void DisplayChaining(){
        System.out.println("Chaining table: ");
        for(int i=0;i<size;i++){
            System.out.println(i+"->");
            Node temp = chain[i];

            while(temp!=null){
                System.out.println(temp.next+"->");
                temp=temp.next;
            }
            System.out.println("NULL");
        } 
    }
}


