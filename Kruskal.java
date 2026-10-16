import java.util.Scanner;
public class Kruskal 
{
    Scanner sc = new Scanner(System.in);
    int [] src, dest, weight;
    int V,E;

    Kruskal(int v,int e){
        this.V=v;
        this.E=e;
        src=new int[E];
        dest=new int[E];
        weight=new int[E];
    }

    int Find(int parent[], int i){
        if(parent[i]!=i)
            parent[i]=Find(parent, parent[i]);
        return parent[i];
    }

    void union(int parent[],int x,int y){
        int px=Find(parent,x);
        int py=Find(parent,y);
        parent[px]=py;
    }

    void SortEdges(){
        for(int i=0;i<E-1;i++){
            for(int j=0;j<E-i-1;j++){
                if(weight[j]>weight[j+1]){
                    int temp=weight[j];
                    weight[j]=weight[j+1];
                    weight[j+1]=temp;

                    temp=src[j];
                    src[j]=src[j+1];
                    src[j+1]=temp;

                    temp=dest[j];
                    dest[j]=dest[j+1];
                    dest[j+1]=temp;
                }
            }
        }
    }

}
