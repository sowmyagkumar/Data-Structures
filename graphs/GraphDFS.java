package graphs;

import java.util.LinkedList;
import java.util.Iterator;

public class GraphDFS{

    int vertices;
	LinkedList[] adj;
	
	GraphDFS(int vertices){
	    this.vertices = vertices;
		adj =  new LinkedList[vertices];
		for(int i = 0; i < vertices; i++){
		    adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int s, int e){
	    adj[s].add(e);
	}
	
	public void dfsUtil(int v, boolean[] visited){
	    visited[v] = true;
		System.out.println(v);
		Iterator<Integer> i = adj[v].iterator();
		while(i.hasNext()){
			int temp = i.next();
			if(visited[temp] != true)
				dfsUtil(temp, visited);
		}
	}
	
	public void dfs(int start, int vertices){
		boolean[] visited = new boolean[vertices];
		dfsUtil(start, visited);
	}
	
	public static void main(String[] args){
		GraphDFS g = new GraphDFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.dfs(2, 4);
	}
}