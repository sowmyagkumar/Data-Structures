package graphs;

import java.util.LinkedList;
import java.util.Iterator;

public class GraphCycleDetection{

    static int vertices;
	static LinkedList[] adj;
	
	public static void addEdge(int s, int e){
	    adj[s].add(e);
	}
	
	public static boolean detectCycleUtil(int s, boolean[] visited){
	    if(visited[s] == true)
		    return true;
		visited[s] = true;
		Iterator<Integer> i = adj[s].iterator();
		boolean b = false;
		while(i.hasNext()){
		    int t = i.next();
			if(visited[t] == true)
			   return true;
		    b = b || detectCycleUtil(t, visited);
		}
		return b;
	}
	
	public static boolean detectCycle(int s){
	    boolean[] visited = new boolean[vertices];
		return detectCycleUtil(s, visited);
	}
	
    public static void main(String[] args){
	    vertices = 4;
		adj = new LinkedList[vertices];
		for(int i = 0; i< vertices; i++){
		    adj[i] = new LinkedList<Integer>();
		}
		addEdge(0,1);
		addEdge(0,2);
		addEdge(1,2);
		addEdge(2,0);
		addEdge(2,3);
		addEdge(3,3);
		System.out.println(detectCycle(2));
	}

	

}