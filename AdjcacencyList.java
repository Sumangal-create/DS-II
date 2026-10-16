public import java.util.Scanner;

public class GraphAdjacencyList
{
    int V;

    int[][] adj;
    int[] size; 

    // Constructor
    GraphAdjacencyList(int V)
    {
        this.V = V;

        adj = new int[V][V * 2]; 
        size = new int[V];
    }

    // Add edge with weight
    void addEdge(int u, int v, int w)
    {
        adj[u][size[u]++] = v;
        adj[u][size[u]++] = w;

        adj[v][size[v]++] = u;
        adj[v][size[v]++] = w;
    }

    // Display adjacency list
    void display()
    {
        System.out.println("Adjacency List:");

        for(int i = 0; i < V; i++)
        {
            System.out.print(i + " -> ");

            for(int j = 0; j < size[i]; j += 2)
            {
                System.out.print("(" + adj[i][j] + ", " + adj[i][j+1] + ") ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        GraphAdjacencyList g = new GraphAdjacencyList(n);

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
