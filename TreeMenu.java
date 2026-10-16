import java.util.Scanner;

public class TreeMenu{
    static int []arr;
    static int n;

    static void InOrder(int i){
        if(i>=n)return;

        InOrder(2*i+1);
        System.out.println(arr[i]+" ");
        InOrder(2*i+2);
    }

    static void PreOrder(int i){
        if(i>=n)return;

        System.out.println(arr[i]+" ");
        PreOrder(2*i+1);
        PreOrder(2*i+2);
    }

    static void PostOrder(int i){
        if(i>=n)return;

        PostOrder(2*i+1);
        PostOrder(2*i+2);
        System.out.println(arr[i]+" ");
    }

    static int Height(int i){
        if (i>=n) return 0;

        int lh= Height(2*1+1);
        int rh= Height(2*1+2);

        if(lh>rh)
            return lh+1;
        else 
            return rh+1;
    } 

    static int CountNodes(int i){
        if (i>=n)return 0;

        return 1+ CountNodes(2*i+1) + CountNodes(2*i+2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number of Nodes: ");
        n=sc.nextInt();
        arr= new int[n];

        System.out.println("Enter the Elements of array: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        while(true){
            System.out.println("1. Inorder Traversal");
            System.out.println("2. Preorder Traversal");
            System.out.println("3. Postorder Traversal");
            System.out.println("4. Height of Tree");
            System.out.println("5. Count Number of Nodes");
            System.out.println("6. Count Number of Nodes");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Inorder Traversal: ");
                    InOrder(0);
                    break;
                case 2:
                    System.out.println("PreOrder Traversal: ");
                    PreOrder(0);
                    break;
                case 3:
                    System.out.println("PostOrder Traversal: ");
                    PostOrder(0);
                    break;
                case 4:
                    System.out.println("No. of Nodes are: "+CountNodes(0));
                    break;
                case 5:
                    System.out.println("Height is: "+Height(0));
                    break;
                case 6:
                    System.out.println("Exiting the program!");
                    break;
                default:
                    System.out.println("Invalid Input!");
            }
        }
    }
}