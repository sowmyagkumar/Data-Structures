package bst;

import trees.BinaryTree;
import trees.Node;

public class Main{

    public static void main(String[] args){
	    BinarySearchTree bst = new BinarySearchTree();
		bst.insert(3);
		bst.insert(10);
		bst.insert(5);
		/*BinarySearchTree bs = new BinarySearchTree();
		bs.insert(4);
		bs.insert(2);
		bs.insert(6);*/
		//bst.inorderPreSucc(2);
		//System.out.println("lca: "+bst.lca(2,10));
		//bst.kthSmallestIterative(1);
		//System.out.println(bst.sumPresentOptimal(7));
		//bst.printMergedBST(bs.root);
		//bst.floor(4);
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
		binaryTree.setRoot(1);
		binaryTree.root.setLeft(new Node(2));
		binaryTree.root.setRight(new Node(3));
		binaryTree.root.getLeft().setLeft(new Node(4));
		binaryTree.root.getRight().setLeft(new Node(14));
		binaryTree.root.getLeft().getLeft().setLeft(new Node(9));
		binaryTree.root.getLeft().setRight(new Node(5));
		bst.convertToBST(binaryTree.root);
	}

}
