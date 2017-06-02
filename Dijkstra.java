import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Dijkstra {
    public static class Graph {
        int adjacency[][];
        int size;
        public Graph(int size) {
            this.size = size;
            adjacency = new int[size][size];
        }

        public void addEdge(int first, int second,int weight) {
            if(adjacency[first][second] == 0 || adjacency[first][second] > weight){
                adjacency[first][second] = weight;
                adjacency[second][first] = weight;   
            }
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            for(int i=0;i<size;i++)
                distances[i] = 1000001;
            distances[startId] = 0;
            PriorityQueue<Node> queue = new PriorityQueue<Node>();
            queue.add(new Node(startId,0));
            for(int i=0;i<size;i++){
                if(i != startId)
                    queue.add(new Node(i,1000001));
            }
            while(!queue.isEmpty()){
                Node current = queue.remove();
                for(int i=0;i<size;i++){
                    if(adjacency[current.name][i] != 0){
                        if(distances[i] > current.priority+adjacency[current.name][i]){
                            queue.remove(new Node(i,distances[i]));
                            distances[i] = current.priority+adjacency[current.name][i];
                            queue.add(new Node(i,distances[i]));
                        }
                    }
                }
            }
            return distances;
        }
        
        public void printGraph(){
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    System.out.print(adjacency[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queries = Integer.parseInt(br.readLine());//scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            String[] ip1 = br.readLine().split(" ");
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(Integer.parseInt(ip1[0]));
            int m = Integer.parseInt(ip1[1]);
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                String[] ip2 = br.readLine().split(" ");
                int u = Integer.parseInt(ip2[0]) - 1;
                int v = Integer.parseInt(ip2[1]) - 1;
                int weight = Integer.parseInt(ip2[2]);
                // add each edge to the graph
                graph.addEdge(u, v, weight);
            }
            
            // Find shortest reach from node s
            int startId = Integer.parseInt(br.readLine()) - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId && distances[i] != 1000001) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
                else if(distances[i] == 1000001){
                    System.out.print("-1");
                    System.out.print(" ");
                }
            }
            System.out.println();
            //graph.printGraph();
        }
        //scanner.close();
    }
}

class Node implements Comparable{
    int name;
    int priority;
    
    public Node(int name,int priority){
        this.name = name;
        this.priority = priority;
    }
    
    public int compareTo(Object o) {
       Node n = (Node)o;
       if(this.priority > n.priority)
           return 1;
        else if(this.priority < n.priority)
            return -1;
        else
            return 0;
    }
}