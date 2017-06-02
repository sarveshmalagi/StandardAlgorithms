import java.util.*;

class Edge{
	int src,dest,wt;
	public Edge(int src,int dest,int wt){
		this.src = src;
		this.dest = dest;
		this.wt = wt;
	}
}
class BellmanFord{
	static int n = 5;
	public static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		ArrayList<Edge> edges = new ArrayList<Edge>();
	edges.add(new Edge(0,1,9));
        edges.add(new Edge(0,2,-1));
        edges.add(new Edge(1,0,-2));
	edges.add(new Edge(1,3,2));
        edges.add(new Edge(2,1,-3));
        edges.add(new Edge(2,3,9));
        edges.add(new Edge(3,1,16));
        edges.add(new Edge(3,4,5));
        edges.add(new Edge(4,0,12));
        bellmanFord(edges,4);
	}

	static void bellmanFord(ArrayList<Edge> edges,int src){
		int[] distance = new int[n];
		Arrays.fill(distance, INF);
		distance[src] = 0;
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < edges.size(); ++j){
				if (distance[edges.get(j).src] == INF) continue;
				if (distance[edges.get(j).src] + edges.get(j).wt < distance[edges.get(j).dest])
					distance[edges.get(j).dest] = distance[edges.get(j).src] + edges.get(j).wt;
			}
		for(int i=0;i<n;i++){
			System.out.print(distance[i]+" ");
		}
	}
}
