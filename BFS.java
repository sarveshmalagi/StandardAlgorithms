import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BFS {
    public static class Graph {
        boolean adjacency[][];
        int size;
        public Graph(int size) {
            this.size = size;
            adjacency = new boolean[size][size];
        }

        public void addEdge(int first, int second) {
            adjacency[first][second] = true;
            adjacency[second][first] = true;
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            for(int i=0;i<size;i++)
                distances[i] = -1;
            distances[startId] = 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(startId);
            while(!queue.isEmpty()){
                int current = queue.remove();
                for(int i=0;i<size;i++){
                    if(adjacency[current][i] == true){
                        if(distances[i] == -1){
                            distances[i] = distances[current]+6;
                            queue.add(i);
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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println(); 
            //graph.printGraph();
        }
        scanner.close();
    }
}