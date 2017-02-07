package trees;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args){
	BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
	binaryTree.setRoot(1);
	binaryTree.root.setLeft(new Node(2));
	binaryTree.root.setRight(new Node(3));
	binaryTree.root.getLeft().setLeft(new Node(4));
	binaryTree.root.getRight().setLeft(new Node(14));
	binaryTree.root.getLeft().getLeft().setLeft(new Node(9));
	binaryTree.root.getLeft().setRight(new Node(5));
	//System.out.println(binaryTree.heightIterative());
	//System.out.println(binaryTree.findDistance(9, 3));
	//binaryTree.inorderIterative();
	//binaryTree.printRootToLeaf();
	
	//binaryTree.rootToLeafSum(16);
	//System.out.println(binaryTree.maxWidth());
	//binaryTree.morrisTraversal();
	//binaryTree.connectSameLevelNodes();
	//binaryTree.printSameLevel(binaryTree.root);
	//binaryTree.closestLeaf(1);
	//System.out.println("LL");
	binaryTree.levelOrderTraversal(binaryTree.deleteSumK(binaryTree.root, 0, 19));
	/*ArrayList<Integer> pre = new ArrayList<Integer>();
	pre.add(1);
	pre.add(2);
	pre.add(3);
	pre.add(4);
	pre.add(5);
	pre.add(6);
	pre.add(7);
	pre.add(8);
	pre.add(9);
	
	ArrayList<Character> preLN = new ArrayList<Character>();
	preLN.add('N');
	preLN.add('N');
	preLN.add('L');
	preLN.add('L');
	preLN.add('N');
	preLN.add('L');
	preLN.add('N');
	preLN.add('L');
	preLN.add('L');
	
	
	/*
	ArrayList<Integer> in = new ArrayList<Integer>();
	in.add(4);
	in.add(2);
	in.add(8);
	in.add(5);
	in.add(1);
	in.add(6);
	in.add(3);
	in.add(9);
	in.add(7);
	
	binaryTree.levelOrderTraversal(binaryTree.constructTree(pre, in, 0, in.size() - 1,0));*/
	
	//binaryTree.levelOrderTraversal(binaryTree.constructSpecialPreOrder(pre, preLN));
	
	}
}