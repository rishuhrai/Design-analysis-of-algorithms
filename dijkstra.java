import java.util.*;
import java.lang.*;
import java.io.*;
class ShortestPath{
	
	static int V;
	
	int minDistance(int dist[], Boolean sptSet[])
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}
	
	void printSolution(int dist[], int n)
	{
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println("Source to "+(i+1)+ " is " + dist[i]);
	}
	
	void dijkstra(int graph[][], int src)
	{
		int dist[] = new int[V];
		Boolean sptSet[] = new Boolean[V];
		
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[src] = 0;
		
		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v] != 0 &&
						dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		
		printSolution(dist, V);
	}
	public static void main(String[] args)
	{
		V = 5;
		System.out.println("Enter the adjacency matric");
		int graph[][] = {   { 0, 10, 0, 0, 100 },
			                { 10, 0, 50, 0, 0 },
			                { 8, 50, 0, 20, 10},
			                { 0, 5, 20, 0, 60 },
			                { 100, 0, 10, 60, 0 } };
		ShortestPath t = new ShortestPath();
		long start = System.currentTimeMillis();
		t.dijkstra(graph, 0);
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("TimeElapsed: "+ timeElapsed+"ms");
	}
}
