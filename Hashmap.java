import java.util.Scanner;
public class Hashmap 
{
    class Node{
        int data;
        Node next;

        Node(int d){
            this.data=d;
            this.next=null;
        }
    }
    int size=10;
    int [] linear = new int[size];
    Node []chaining = new Node[size];

    void init(){
        for(int i=0;i<size;i++){
            linear[i]=-1;
            chaining[i]=null;
        }
    }

    void Linear_probing(int value){
        int index = value%size;

        while(linear[index]!=-1){
            index=(index+1)%size;
        }
        linear[index]=value;
    }

    void display_linear(){
        System.out.println("Liear chaining: ");
        for(int i=0;i<size;i++){
            System.out.println(i+" -> "+linear[i]);
        }
    }

    void insert_chaining(int value){
        int index = value%size;

        Node newNode = new Node(value);

        if(chaining[index]==null){
            chaining[index]=newNode;
        }else{
            Node temp = chaining[index];
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }

    void displayChaining(){
        System.out.println("Chaining: ");
        for(int i=0;i<size;i++){
            System.out.println(i+" -> ");
            Node temp=chaining[i];
            while(temp!=null){
                System.out.println(temp.data+" -> ");
                temp=temp.next;
            }
            System.out.println("Null");
        }
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Hashmap h = new Hashmap();
        h.init();
        int choice=0;

        while(choice!=5){
            System.out.println("1.Insert Linear\n2.Insert by chaining\n3.Display linear probing\n4.Display Chaining\n5.Exit");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter a value: ");
                    int val=sc.nextInt();
                    h.Linear_probing(val);
                    break;
                case 2:
                    System.out.println("Enter a value: ");
                    val=sc.nextInt();
                    h.insert_chaining(val);
                    break;
                case 3:
                    h.display_linear();
                    break;
                case 4:
                    h.displayChaining();
                    break;
                case 5:
                    System.out.println("Exiting!");
                    break;
                default:
                    System.out.println("Invalid input!");
                    return;
            }
            sc.close();
        }
    }
}
