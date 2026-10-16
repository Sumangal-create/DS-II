import java.util.Scanner;

public class HashingMenu{
    static int size=10;

    static int [] linear= new int[size];
    static int[] quadratic = new int[size];

    static Node [] chain = new Node[size];

    static class Node{
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }

    static void init(){ //Initailise the table
        for(int i=0;i<size;i++){
            linear[i]=-1;
            quadratic[i]=-1;
            chain[i]=null;
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
        int i =1;

        while(quadratic[index]!=-1){
            index=(value+i*i)%size;
            i++;
        }
        quadratic[index]=value;
    }

    static void display(){
        System.out.println("Quadratic Probing: ");
        for(int i=0;i<size;i++){
            System.out.println(i+"->"+quadratic[i]);
        }
    }

    static void Chaining(int value){
        
    }
}

