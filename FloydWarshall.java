import java.util.*;

class FloydWarshall{
	static int n = 4;
	static int infinity  = 99999;
	public static void main(String[] args) {
		int[][] graph = {{0,12,infinity,1},
                          	{12,0,3,infinity},
                          	{6,infinity,0,7},
                          	{infinity,5,infinity,0}};
		apsp(graph);
	}
	static void apsp(int[][] graph){
		int dist[][] = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				dist[i][j] = graph[i][j];
			}
		}

		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(dist[i][j] > dist[i][k]+dist[k][j]){
						dist[i][j] = dist[i][k]+dist[k][j];
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}
}
