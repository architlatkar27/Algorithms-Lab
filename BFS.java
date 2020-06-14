import java.util.*;

class Point{
    int id;
    boolean visited;
    ArrayList<Point> neighbours = new ArrayList<Point>();
    Point(int id){
        this.id = id;
        visited = false;
    }
    void addNeighbour(Point p){
        neighbours.add(p);
    }
}

public class BFS {
    
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String args[]){
        System.out.println("DFS for undirected graph");
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Input number of nodes");
        n = sc.nextInt();
        Point[] graph = new Point[n];
        for(int i=0;i<n;i++){
            graph[i] = new Point(i);
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
        System.out.println("Input starting Point");
        int s = sc.nextInt();
        queue.add(graph[s]);
        algorithm();
        System.out.println("End");
    }
    
    static void algorithm(){
        while(queue.peek()!=null){
            Point p = queue.poll();
            if(p.visited == true) continue;
            p.visited = true;
            System.out.print(p.id+" -> ");
            for(int i=0;i<p.neighbours.size();i++){
                Point next = p.neighbours.get(i);
                if(next.visited == true) continue;
                queue.add(next);
            }
        }
    }
}