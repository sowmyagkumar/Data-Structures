package graphs;

import java.util.LinkedList;
import java.util.Iterator;

public class GraphCycleDetectionUndirected{

    static int vertices;
	static LinkedList[] adj;
	
	public static void addEdge(int s, int e){
	    adj[s].add(e);
		adj[e].add(s);
	}
	
	public static boolean detectCycleUtil(int s, int parent, boolean[] visited){
	    visited[s] = true;
		Iterator<Integer> i = adj[s].iterator();
		while(i.hasNext()){
		    int t = i.next();
			if(visited[t] != true){
			    if(detectCycleUtil(t, s, visited)==true)
				    return true;
			}else{
			    if(t != parent){
				    return true;
				}
			}
		}
		return false;
	}
	
	public static boolean detectCycle(){
	    boolean[] visited = new boolean[vertices];
		
		for(int v = 0; v < vertices; v++){
		    if(visited[v] == false){
			    if(detectCycleUtil(v, -1, visited)==true)
				    return true;
			}
		}
		
		return false;
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
		//addEdge(2,0);
		addEdge(2,3);
		//addEdge(3,3);
		System.out.println(detectCycle());
	}

	

}