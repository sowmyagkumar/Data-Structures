package bst;

import java.util.Stack;
import java.util.HashSet;

class Node{
    int data;
    Node left;
    Node right;

	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public void setLeft(Node left){
		this.left = left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public void setRight(Node right){
		this.right = right;
	}
	
}

public class BinarySearchTree{

    Node root;
	Node pre;
	Node succ;
	
	BinarySearchTree(){
		this.root = null;
	}
	
	public void addNode(int data){
		root = addNodeUtil(root, data);
	}
	
	public Node addNodeUtil(Node start, int data) {
	    if(start == null){
		    start = new Node(data);
		    return start;
		}
		if(start.getData() >data){
		    start.setLeft(addNodeUtil(start.getLeft() , data));
			return start;
		}
		start.setRight(addNodeUtil(start.getRight(), data));
		return start;
	}
	
	public void printInorder(Node start){
		if(start == null)
			return;
		printInorder(start.getLeft());
		System.out.println(start.getData());
		printInorder(start.getRight());
	}
	
	public boolean searchBst(Node start, int data){
		if(start == null)
			return false;
		if(start.getData() == data)
			return true;
		if(start.getData() > data)
			return searchBst(start.getLeft(), data);
		return searchBst(start.getRight(), data);
	}
	
	public int minVal(Node start){
		while(start.getLeft() != null)
			start = start.getLeft();
		return start.getData();
	}
	
	public Node deleteNode(Node start, int data){
		if(start == null){
			return start;
		}
		if(start.getData() < data){
			start.setRight(deleteNode(start.getRight(), data));
		}else if(start.getData() > data){
				start.setLeft(deleteNode(start.getLeft(), data));
		}else{
			if(start.getLeft() == null)
				return start.getRight();
			if(start.getRight() == null)
				return start.getLeft();
			int val = minVal(start.getRight());
			start.setData(val);
			start.setRight(deleteNode(start.getRight(), val));
		}
		return start;
	}
	
	public Node minNode(Node start){
		if(start == null)
			return null;
		while(start.getLeft() != null)
			start = start.getLeft();
		return start;
	}
	
	public Node maxNode(Node start){
		if(start == null)
			return null;
		while(start.getRight() != null)
			start = start.getRight();
		return start;
	}

	public void printPreSucc(Node root, int data){
		inOrderPreSucc(root, data);
		int preVal = (pre != null)?pre.getData():-1;
		int succVal = (succ != null)?succ.getData():-1;
		System.out.println("Predecessor:"+preVal+"\tSuccessor:"+succVal);
	}
	
	public void inOrderPreSucc(Node start, int data){
		if(start == null)
			return;
		if(start.getData() == data){
			if(start.getLeft() != null)
				pre = maxNode(start.getLeft());
			if(start.getRight() != null)
				succ = minNode(start.getRight());
			return;
		}else if(start.getData() > data){
			succ = start;
			inOrderPreSucc(start.getLeft(), data);
		}else{
			if(start.getData() < data){
				pre = start;
				inOrderPreSucc(start.getRight(), data);
			}
		}	
		
	}
	
	public Node lca(Node start, int n1, int n2){
		if(start == null)
			return null;
		if(start.getData() > n1 && start.getData() > n2)
			return lca(start.getLeft(), n1, n2);
		if(start.getData() < n1 && start.getData() < n2)
			return lca(start.getRight(), n1, n2);
		return start;
	}
	
	public boolean checkIfBst(Node root, int min, int max){
		if(root == null)
			return true;
		if(root.getData() < min || root.getData() >max)
			return false;
		return checkIfBst(root.getLeft(), min, root.getData() - 1) && checkIfBst(root.getRight(), root.getData()+1, max);
	}
	
	public void printSuccessor(Node start, int data){
		if(start == null)
			return;
		if(start.getData() > data){
			succ = start;
			printSuccessor(start.getLeft(), data);
		}else if (start.getData() < data){
			printSuccessor(start.getRight(), data);
		} else if(start.getData() == data){
					int succVal = (minNode(start.getRight())!=null)?minNode(start.getRight()).getData():-1;
					System.out.println("Successor is:"+ succVal);
		}
	}
	
	public void printKSmallest(Node start, int k){
		if(start == null)
			return;
		int i = 1;
		Stack<Node> stack = new Stack<Node>();
		while(true){
			while(start!= null){
				stack.push(start);
				start = start.getLeft();
			}
			if(stack.size() <=0){
				break;
			}
			start = stack.pop();
			if(i == k){
				System.out.println("kth element is:"+start.getData());
			}
			i++;
			start = start.getRight();
			
		}
	
	}
	
	public void inOrderTraversal(Node start, HashSet<Integer> hs){
		if(start == null)
			return;
		hs.add(start.data);
		inOrderTraversal(start.getLeft(), hs);
		inOrderTraversal(start.getRight(), hs);
	}
	
	public boolean findPairWithSum(Node start, int data){
		if(root == null)
			return false;
		HashSet<Integer> hs = new HashSet<Integer>();
		inOrderTraversal(start, hs);
		for(int i: hs){
			if(hs.contains(data-i))
				return true;
		}
		return false;
	}
}