package com.datastructures.trial.trees;

import java.util.*;

class Node{
    Node left;
	Node right;
	int data;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void setLeft(int data){
	    this.left = new Node(data);
	}
	
	public Node getLeft(){
	    return left;
	}
	
	public void setRight(int data){
	    this.right = new Node(data);
	}
	
	public Node getRight(){
	    return right;
	}
	
	public void setData(int data){
	    this.data = data;
	}
	
	public int getData(){
	    return data;
	}
}

public class BinaryTree{
    Node root;
	
    public void setRoot(int data){
		root = new Node(data);
	}
	
	public Node lca(Node start, int n1, int n2){
	    if(start == null)
		    return null;
		if(start.getData() == n1 || start.getData() == n2)
		    return start;
		Node l = lca(start.getLeft(), n1, n2);
		Node r = lca(start.getRight(), n1, n2);
		return (l!=null)?l:r;
	}
	
	private int height(Node start){
		if(start == null)
			return 0;
		return 1+ Math.max(height(start.getLeft()), height(start.getRight()));
	}
	
	public int diameter(Node start){
		if(start == null)
			return 0;
		int lheight = height(start.getLeft());
		int rheight = height(start.getRight());
		
		return Math.max(lheight+rheight+1, Math.max(diameter(start.getLeft()),diameter(start.getRight())));
	}
	
	public void verticalSum(Node start, TreeMap<Integer, Integer> tm, int hd){
		if(start == null)
			return;
		int prevSum = (tm.get(hd)!= null)? tm.get(hd): 0;
		tm.put(hd, prevSum+start.getData());
		
		verticalSum(start.getLeft(),tm, hd-1);
		verticalSum(start.getRight(),tm, hd+1);
    }
	
	public void printAncestors(Node start, ArrayList<Integer> ancestors, int n){
		if(start == null)
			return;
		if(start.getData() == n){
			printArrayList(ancestors);
		    return;
		}
		ancestors.add(start.getData());
		printAncestors(start.getLeft(), ancestors, n);
		printAncestors(start.getRight(), ancestors, n);
		ancestors.remove(ancestors.size() -1);
	}
	
	public void printArrayList(ArrayList<Integer> ancestors){
		for(Integer a: ancestors)
			System.out.println(a+"--->");
	}
}