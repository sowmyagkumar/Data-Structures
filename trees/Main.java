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
	
	}
}