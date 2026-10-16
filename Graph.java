import java.util.Scanner;
public class Graph {
    int V;
    int[][] A;

    Graph(int V){
         this.V=V;
         A=new int[V][V];
    }

    void addEdge(int v,int u,int w){
        A[u][v]=w;

        A[v][u]=w;
    }

    void Display(){
        System.out.println("Adjacency Matrix: ");

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.println(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String []args)
}
