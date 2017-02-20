package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

public class GraphBFS{

    int vertices;
	LinkedList[] adj;
	
	GraphBFS(int vertices){
	    this.vertices = vertices;
		adj = new LinkedList[vertices];
		for(int i = 0; i < vertices; i++){
		    adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int s, int e){
	    adj[s].add(e);
	}

	public void bfs(int s, int vertices){
	    boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		while(queue.size() != 0 ){
		    int temp = queue.remove();
			System.out.println(temp);
			Iterator<Integer> i = adj[temp].iterator();
			while(i.hasNext()){
			    int val = i.next();
				if(visited[val] != true){
				    queue.add(val);
					visited[val] = true;
				}
			}
		}
	}
	
	public static void main(String[] args){
		GraphBFS g = new GraphBFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.bfs(2, 4);
	}
}