package com.datastructures.trial.trees;

import java.util.*;

public class Main{

    public static void main(String[] args){
	BinaryTree binaryTree = new BinaryTree();
	TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
	ArrayList<Integer> ancestors = new ArrayList<Integer>();
	
	binaryTree.setRoot(1);
	binaryTree.root.setLeft(2);
	binaryTree.root.setRight(3);
	binaryTree.root.getLeft().setLeft(4);
	binaryTree.root.getLeft().setRight(5);
	binaryTree.root.getLeft().getLeft().setLeft(6);
	binaryTree.root.getLeft().getLeft().setRight(7);
	System.out.println(binaryTree.diameter(binaryTree.root));
	
	binaryTree.verticalSum(binaryTree.root, tm, 0);
	Set set  = tm.entrySet();
	Iterator i = set.iterator();
	while(i.hasNext()){
		Map.Entry me = (Map.Entry)i.next();
		System.out.println(me.getKey()+" "+me.getValue());
	}
	System.out.println("Ancestors:");
	binaryTree.printAncestors(binaryTree.root, ancestors, 7);
	}
}