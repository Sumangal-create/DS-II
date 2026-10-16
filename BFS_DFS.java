import java.util.Scanner;
import java.util.zip.Adler32;

class Node{
    Node next;
    int data;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class BFS_DFS{
    int vertices;
    Node AdjList[];

    BFS_DFS(int v){
        this.vertices=v;
        AdjList= new Node[v];
    }

    void addEdge(int v, int u){
        Node newNode= new Node(v);
        newNode.next = AdjList[u];
        AdjList[u]= newNode;

        newNode = new Node(u);
        newNode.next= AdjList[v];
        AdjList[v]= newNode;
    }

    void BFS(int start){
        boolean[] visited = new boolean[vertices];
        int[] queue = new int[vertices];
        int front=0,rear=0;

        visited[start]=true;
        queue[rear++]=start;

        System.out.println("BFS: ");
        while(front>rear){
            int node=queue[front++];
            System.out.println("Node"+" ");

            Node te
        }
    }
}