import java.util.*;

class Vertex{
    int id;
    boolean visited;
    ArrayList<Vertex> neighbours = new ArrayList<Vertex>();
    Vertex(int node){
        id = node;
        visited = false;
    }
    void addNeighbour(Vertex v){
        //Vertex v = new Vertex(x);
        neighbours.add(v);
    }
}

public class DFS {
    public static void main(String args[]){
        System.out.println("DFS for undirected graph");
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Input number of nodes");
        n = sc.nextInt();
        Vertex[] graph = new Vertex[n];
        for(int i=0;i<n;i++){
            graph[i] = new Vertex(i);
        }
        System.out.println("Input number of edges");
        int edg;
        edg = sc.nextInt();
        System.out.println("For every edge input the ends");
        for(int i=0;i<edg;i++){
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            graph[a].addNeighbour(graph[b]);
            graph[b].addNeighbour(graph[a]);
        }
        System.out.println("Input starting vertex");
        int s = sc.nextInt();
        long t1 = System.nanoTime();
        algorithm(graph[s]);
        long t2 = System.nanoTime();
        System.out.println("End");
        System.out.println("Execution Time: "+(t2-t1));
    }
    static void algorithm(Vertex v){
        v.visited = true;
        System.out.print(v.id+" -> ");
        for(int i=0;i<v.neighbours.size();i++){
            if(v.neighbours.get(i).visited == true) continue;
            algorithm(v.neighbours.get(i));
        }
    }
}