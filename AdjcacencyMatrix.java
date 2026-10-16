public // Ayush Bhartal 1012411160
import java.util.Scanner;

public class GraphAdjacencyMatrix
{
    int V;
    int[][] A;

    // Constructor
    GraphAdjacencyMatrix(int V)
    {
        this.V = V;
        A = new int[V][V];
    }

    // Add edge with weight
    void addEdge(int u, int v, int w)
    {
        A[u][v] = w;

        //bcz this is a non directional graph
        A[v][u] = w;
    }

    // Display matrix
    void display()
    {
        System.out.println("Adjacency Matrix:");

        for(int i = 0; i < V; i++)
        {
            for(int j = 0; j < V; j++)
            {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(n);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        for(int i = 0; i < e; i++)
        {
            System.out.print("Enter edge (u v weight): ");

            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            g.addEdge(u, v, w);
        }

        g.display();

        sc.close();
    }
} {
    
}
