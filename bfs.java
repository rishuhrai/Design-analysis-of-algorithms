import java.util.*;
class BFS{
	private int V;
	private LinkedList<Integer> adj[];
	private boolean visited[];
	private char[] vertex = {'A','B','C','D','E','F','G','H','S'};
	BFS(int V){
		this.V = V;
		adj = new LinkedList[V];
		visited = new boolean[V];
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList();
		}
	}

	void addEdge(int a,int b){
		adj[a].add(b);
		adj[b].add(a);
	}

	void BFS(int s){
		LinkedList<Integer> queue = new LinkedList();
		visited[s] = true;
		queue.add(s);
		while(queue.size() != 0){
			s = queue.poll();
			System.out.print(vertex[s]+" ");
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		BFS b = new BFS(9);
		b.addEdge(0,1);
		b.addEdge(0,8);
		b.addEdge(8,2);
		b.addEdge(8,6);
		b.addEdge(2,3);
		b.addEdge(2,4);
		b.addEdge(2,5);
		b.addEdge(6,7);
		b.addEdge(6,5);
		b.addEdge(4,7);

		b.BFS(0);
	}
}
