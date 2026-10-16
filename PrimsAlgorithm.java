import java.util.Scanner;

public class PrimsAlgorithm{
    int V;
    int[][] graph;

    PrimsAlgorithm(int v){
        V = v;
        graph = new int[V][V];
    }

    // Add edge
    void addEdge(int u, int v, int w){
        graph[u][v] = w;
        graph[v][u] = w; // undirected graph
    }

    // Find vertex with minimum key value
    int minKey(int[] key, boolean[] visited){
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Prim's Algorithm
    void primMST() {
        int[] parent = new int[V];   // Stores MST
        int[] key = new int[V];      // Minimum weights
        boolean[] visited = new boolean[V];

        // Initialize
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        key[0] = 0;      // Start from vertex 0
        parent[0] = -1;  // Root has no parent

        // MST will have V-1 edges
        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print MST
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        PrimsAlgorithm g = new PrimsAlgorithm(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            int weight = sc.nextInt();
            g.addEdge(u, w, weight);
        }

        g.primMST();

        sc.close();
    }
}
    
