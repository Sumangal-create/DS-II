import java.util.Scanner;
public class BinaryTree 
{
    int array[];
    int capacity=100;
    int n;

    BinaryTree(){
        array=new int[capacity];
        n=0;
    }

    void Insert(int value){
        if(n==capacity){
            System.out.println("Tree is full!");
            return;
        }
        array[n]=value;
        n++;
    }

    void Delete(int key){
        if(n==0){
            System.out.println("Tree is empty!");
            return;
        }

        int i;
        for(i=0;i<n;i++){
            if(array[i]==key){
                break;
            }
        }

        if(i==-1){
            System.out.println("Element not found!");
            return;
        }

        array[i]=array[n-1];
        n--;
    }

    void Inorder(int i){
        if(i>=n)return;

        Inorder(2*i+1);
        System.out.println(array[i]+" ");
        Inorder(2*i+2);
    }

    void PreOrder(int i){
        if(i>=n)return;

        System.out.println(array[i]+" ");
        PreOrder(2*i+1);
        PreOrder(2*i+2);
    }

    void PostOrder(int i){
        if(i>=n)return;

        PostOrder(2*i+1);
        PostOrder(2*i+2);
        System.out.println(array[i]+" ");
    }

    int Height(int i){
        if(i>=n) return 0;

        int lh = Height(2*i+1);
        int rh = Height(2*i+2);
        return(lh>rh?lh:rh)+1;
    }

    int CountNodes(int i){
        if(i>=n)return 0;

        return 1+ CountNodes(2*i+1)+CountNodes(2*i+2);
    }

    void display(){
        for(int i=0;i<n;i++){
            System.out.println(array[i]+" "+" \n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println("Enter the number of nodes: ");
        tree.n = sc.nextInt();

        System.out.println("Enter the elements of array: ");
        for(int i=0;i<tree.n;i++){
            tree.array[i]=sc.nextInt();
        }

        while(true){
            System.out.println("1.Inorder Traversal");
            System.out.println("2.Preorder Traversal");
            System.out.println("3.Postorder Traversal");
            System.out.println("4.Insert");
            System.out.println("5.Delete");
            System.out.println("6.Height");
            System.out.println("7.Count number of nodes");
            System.out.println("8.Display");
            System.out.println("9.Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Inorder Traversal: ");
                    tree.Inorder(0);
                    break;
                case 2:
                    System.out.println("Preorder Traversal: ");
                    tree.PreOrder(0);
                    break;
                case 3:
                    System.out.println("Postorder Traversal: ");
                    tree.PostOrder(0);
                    break;
                case 4:
                    System.out.println("Insert: ");
                    int val = sc.nextInt();
                    tree.Insert(val);
                    break;
                case 5:
                    System.out.println("Delete: ");
                    val = sc.nextInt();
                    tree.Delete(val);
                    break;
                case 6:
                    System.out.println("Height: "+tree.Height(0));
                    break;
                case 7:
                    System.out.println("Total nodes: "+tree.CountNodes(0));
                    break;
                case 8:
                    System.out.println("Tree: ");
                    tree.display();
                    break;
                case 9:
                    System.out.println("Exiting!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
