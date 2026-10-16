import java.util.Scanner;
public class Hash 
{
    int size=10;
    int [] linear = new int[size];
    int [] Quadratic = new int[size];
    Node [] chaining = new Node[size];

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    void init(){
        for(int i=0;i<size;i++){
            linear[i]=-1;
            Quadratic[i]=-1;
            chaining[i]=null;
        }
    }

    void Linear_probing(int value){
        int index=value%size;

        while(linear[index]!=-1){
            index=(index+1)%size;
        }
        linear[index]=value;
    }

    void LinearDisplay(){
        System.out.println("Linear probing: ");
        for(int i=0;i<size;i++){
            System.out.println(i+" -> "+linear[i]);
        }
    }

    void Quadratic_probing(int value){
        int index = value%size;
        int i=1;

        while(Quadratic[index]!=-1){
            index=(index+i*i)%size;
        }
        Quadratic[index]=value;
    }
    
    void DisplayQuadratic(){
        System.out.println("Quadratic probing: ");
        for(int i=0;i<size;i++){
            System.out.println(i+" -> "+Quadratic[i]);
        }
    }

    void Chaining_Insert(int value){
        int index = value%size;

        Node newNode = new Node(value);
        if(chaining[index]==null){
            chaining[index]=newNode;
        }else{
            Node temp = chaining[index];
            while(temp.next==null){
                temp=temp.next;
            }
            temp.next=newNode;
            }
        }

        void displayChaining(){
            System.out.println("Displaying chaining: ");
            for(int i=0;i<size;i++){
                System.out.println(i+" -> "+chaining[i]);
                Node temp = chaining[i];
                while(temp!=null){
                    System.out.println(temp.data+" -> ");
                    temp=temp.next;
                }
            }
        }
    }
}
