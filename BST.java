import java.util.Scanner;
public class BST 
{
    static int Tree[];
    static int size;
    
    void Tree(int n){ //Initialising the tree!
        int size=n;
        Tree=new int[size];
        for(int i=0;i<size;i++){
            Tree[i]=-1;
        }
    }

    public void Insert(int value, int i){
        if(i>size){
            System.out.println("Tree Overflow!");
        }
        if(Tree[i]==-1){
            Tree[i]=value;
            return;
        }

        if(value<Tree[i]){
            Insert(value,2*i+1);
        }
        else{
            Insert(value,2*i+2);
        }
    }

    public boolean Search(int value, int i){
        if(i>=size || Tree[i]==-1 ){
            return false;
        }
         if(Tree[i]==value){
            return true;
         }

         if(value>Tree[i]){
            return Search(value, 2*i+1);
         }
         else
            return Search(value, 2*i+2);
    }

    public int FindMin(int value,int i){
        if(Tree[i]==-1)return -1;

        while(2*i+1<size && Tree[2*i+1]!=-1){
            i=2*i+1;
        }
        return Tree[i];
    }

    public static void Inorder(int i){
        if(i>=size || Tree[i]==-1) return;

        Inorder(2*i+1);
        System.out.println(Tree[i]+" ");
        Inorder(2*1+2);
    }

    public static void PreOrder(int i){
        if(i>=size || Tree[i]==-1)return ;

        System.out.println(Tree[i]+" ");
        PreOrder(2*i+1);
        PreOrder(2*i+2);
    }

    public static void PostOrder(int i){
        if(i>=size || Tree[i]==-1)return;

        PostOrder(2*i+1);
        PostOrder(2*i+2);
        System.out.println(Tree[i]+" ");
    }

    public static int Height(int i){
        if(i>=size || Tree[i]==-1)return -1;

        int lh = Height(2*i+1);
        int rh = Height(2*i+1);

        if(lh>rh){
            return lh+1;
        }
        else
            return rh+1;
    }

    public int Delete(int i, int value){
        if(i>size || Tree[i]==-1)return -1;

        if(Tree[i]>value){
            Tree[i]=Delete(2*i+1,value);
        }else if(value>Tree[i]){
            Tree[i]=Delete(2*i+2,value);
        }else{
            if((2*i+1>=size || Tree[2*i+1]==-1) && //Having no child
        (2*i+2>=size || Tree[2*i+2]==-1)){
            Tree[i]=-1;
        }
        //Having one child
        else if((2*i+1<size || Tree[2*i+1]!=-1) &&
    (2*i+2>=size || Tree[2*i+2]==-1)){
        Tree[i]=Tree[2*i+1];
        Delete(Tree[2*i+1],2*i+1);
    }

    else if((2*i+2<size || Tree[2*i+2]!=-1)&& 
2*i+1>=size || Tree[2*i+1]==-1){
    Tree[i]=Tree[2*i+2];
    Delete(Tree[2*i+2], 2*i+2);
}
}
return Tree[i];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree= new BST();

        int val,choice;

        do {
            System.out.println("1.Insert");
            System.out.println("2.Search");
            System.out.println("3.Find Minimum");
            System.out.println("4.Inorder");
            System.out.println("5.Preorder");
            System.out.println("6.Postorder");
            System.out.println("7.Height");
            System.out.println("8.Delete");
            System.out.println("Enter your choice: ");
            choice=sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter any value: ");
                    val=sc.nextInt();
                    tree.Insert(val,0);
                    break;

                case 2:
                    System.out.println("Enter any value: ");
                    val=sc.nextInt();
                    tree.Search(val, 0);
                    break;

                case 3:
                    System.out.println("Enter any value: ");
                    val=sc.nextInt();
                    tree.FindMin(val, 0);
                case 4:
                    Inorder(0);
                    System.out.println();
                    break;
                case 5:
                    PreOrder(0);
                    System.out.println();
                    break;
                case 6:
                    PostOrder(0);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Enter any value: ");
                    val=sc.nextInt();
                    tree.Delete(val, 0);
                    break;
                case 8:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (choice!=8);
        sc.close();
    }
}
