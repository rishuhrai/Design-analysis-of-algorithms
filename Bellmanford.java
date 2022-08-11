/*Algorithm 
	input: graph,source and edge lengths with no negative cycles
	for v in V:
		dist[v] = infinity;
	
	dist[source] = 0;

	repeat |V|- 1 times :
		for every e in E:
			update(e);


	function update ({u,v} : E):
		dist[v] = min(dist[v],dist[u]+length[u,v]);

Time Complexity: O(VE)
*/


class Bellmanford{
	static class Edge{
		int from,to;
		double cost;
		Edge(int from,int to,double cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	static double[] bellmanford(Edge [] edges,int V,int start){
		double []dist = new double[V];
		java.util.Arrays.fill(dist,Double.POSITIVE_INFINITY);

		dist[start] = 0;

		for(int i=0;i<V-1;i++){
			for(Edge edge: edges){
				if(dist[edge.from] + edge.cost < dist[edge.to])
					dist[edge.to] = dist[edge.from] + edge.cost;
			}
		}

		for(int i=0;i<V-1;i++){
			for(Edge edge: edges){
				if(dist[edge.from] + edge.cost < dist[edge.to])
					dist[edge.to] = Double.NEGATIVE_INFINITY;
			}
		}

		return dist;
	}

	public static void main(String[] args) {
		int E = 10;
		int V = 6;
		int start = 0;
		String [] vertex = {"a","b","c","d","e","t"};
		Edge edges[] = new Edge[E];
		edges[0] = new Edge(0,1,-4);
		edges[1] = new Edge(0,5,-3);
		edges[2] = new Edge(1,3,-1);
		edges[3] = new Edge(1,4,-2);
		edges[4] = new Edge(2,1,8);
		edges[5] = new Edge(2,5,3);
		edges[6] = new Edge(3,0,6);
		edges[7] = new Edge(3,5,4);
		edges[8] = new Edge(4,2,-3);
		edges[9] = new Edge(4,5,2);

		double d[] = bellmanford(edges,V,start);
		for(int i=0;i<V;i++){
			System.out.printf("The distance form %s to %s is %.2f\n",vertex[start],vertex[i],d[i]);
		}
	}
}
