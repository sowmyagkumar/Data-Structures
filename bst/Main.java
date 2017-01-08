package bst;

public class Main{

public static void main(String[] args){
    BinarySearchTree bst = new BinarySearchTree();
	bst.addNode(6);
	bst.addNode(8);
	bst.addNode(1);
	bst.addNode(3);
	bst.addNode(18);
	bst.addNode(28);
	bst.addNode(5);
	/*bst.printInorder(bst.root);
	System.out.println(bst.searchBst(bst.root, 180));
	bst.deleteNode(bst.root, 28);
	bst.printInorder(bst.root);
	System.out.println("Minimum value:"+bst.minNode(bst.root).getData());
	//bst.printPreSucc(bst.root, 18);
	System.out.println("lca is:"+bst.lca(bst.root, 5,28).getData());
	System.out.println("Is bst:"+bst.checkIfBst(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	bst.printSuccessor(bst.root,8);*/
	bst.printKSmallest(bst.root, 6);
	System.out.println(bst.findPairWithSum(bst.root, 9));
}
}