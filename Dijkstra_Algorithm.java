import java.util.*;

class Node{
    int id;
    boolean visited = false;
    ArrayList<Edge> edges = new ArrayList<Edge>();
    int dist = Integer.MAX_VALUE;
    Node prev;
    Node(int id){
        this.id = id;
    }
    void addEdge(Edge e){
        edges.add(e);
    }
    void setDistance(Node prev,int d){
        if(dist>d){
            this.prev = prev;
            dist = d;
        }
    }
    public String toString(){
        return Integer.toString(id);
    }
}

class NodeCompare implements Comparator<Node>{
    public int compare(Node a,Node b){
        if(a.dist<b.dist) return -1;
        else if(a.dist>b.dist) return 1;
        return 0;
    }
}

class Edge{
    Node start,end;
    int weight;
    Edge(Node start,Node end,int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    public String toString(){
        return start+"-"+end;
    }
}

public class Dijkstra_Algorithm{
    public static void main(String args[]){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        n = sc.nextInt();
        Node[] node = new Node[n];
        for(int i=0;i<n;i++){
            node[i] = new Node(i);
        }
        System.out.println("Enter number of edges");
        int e;
        e = sc.nextInt();
        System.out.println("For every edge enter start, end and weight");
        for(int i=0;i<e;i++){
            int start,end,weight;
            start = sc.nextInt();
            end = sc.nextInt();
            weight = sc.nextInt();
            Edge ed1 = new Edge(node[start], node[end], weight);
            Edge ed2 = new Edge(node[end],node[start], weight);
            node[start].addEdge(ed1);
            node[end].addEdge(ed2);
        }
        int source;
        System.out.println("Input source node");
        source = sc.nextInt();
        algorithm(node,n,source);
        for(int i=0;i<n;i++){
            printPath(node[i]);
        }
        sc.close();
        System.out.println("Node -- Prev Node");
        for(int i=0;i<n;i++){
            try{
                System.out.println(node[i].id+" -- "+node[i].prev.id);
            }
            catch(Exception x){
                System.out.println(node[i].id+" -- null");
            }
            
        }
        System.out.println("End");
    }
    static void printPath(Node n){
        while(n!=null){
            System.out.print(n.id+" ");
            n = n.prev;
        }
        System.out.print("\n");
    }
    static void algorithm(Node[] node,int n,int source){
        node[source].dist = 0;
        node[source].prev = null;
        PriorityQueue<Node> pQueue = new PriorityQueue<Node>(1,new NodeCompare());
        pQueue.add(node[source]);
        while(pQueue.peek()!=null){
            Node curr = pQueue.poll();
            //if(curr.visited == true) continue;
            curr.visited = true;
            int arrsize = curr.edges.size();
            for(int i=0;i<arrsize;i++){
                if(curr.edges.get(i).end.visited == true) continue;
                curr.edges.get(i).end.setDistance(curr, curr.dist+curr.edges.get(i).weight);
                pQueue.remove(curr.edges.get(i).end);
                pQueue.add(curr.edges.get(i).end);
            }
        }
    }
}