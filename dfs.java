import java.util.*;
class DFS{
	private int V;
	private LinkedList<Integer> adj[];
	private boolean visited[];
	private char[] vertex = {'A','B','C','D','E','F','G','H','S'};
	DFS(int V){
		this.V = V;
		visited = new boolean[V];
		adj = new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList();
		}
	}

	void addEdge(int a,int b){
		adj[a].add(b);
		adj[b].add(a);
	}

	void DFS(int n){
		visited[n] = true;
		System.out.print(vertex[n]+ " ");
		Iterator<Integer> i = adj[n].listIterator();
		while(i.hasNext()){
			int s = i.next();
			if(!visited[s]){
				visited[s] = true;
				DFS(s);
			}
		}
	}

	public static void main(String[] args) {
		DFS b = new DFS(9);
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

		b.DFS(0);
	}
}
