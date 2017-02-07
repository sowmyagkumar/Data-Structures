package trees;

import java.util.ArrayList;
import queues.Queue;
import stacks.Stack;

class Node<T>{
    Node left;
	Node right;
	Node nextRight;
	T data;
	
	Node(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public void setLeft(Node left){
	    this.left = left;
	}
	
	public Node getLeft(){
	    return left;
	}
	
	public void setRight(Node right){
	    this.right = right;
	}
	
	public Node getRight(){
	    return right;
	}
	
	public void setData(T data){
	    this.data = data;
	}
	
	public T getData(){
	    return data;
	}
}

public class BinaryTree<T>{
    Node root;
	static int index=0;
	
    public void setRoot(T data){
		root = new Node(data);
	}
	
	public void levelOrderTraversal(Node root){
		if(root == null)
			return;
		Queue<Node> queue = new Queue<Node>();
		Node start = root;
		queue.enqueue(start);
		queue.enqueue(null);
		int h = heightIterative(root);
		int i = 0;
		while(queue.size() != 0 && i<h){
			Node temp = queue.dequeue();
			if(temp != null){
			    System.out.print(temp.data+"\t");
				if(temp.left != null)
					queue.enqueue(temp.left);
				if(temp.right != null)
				queue.enqueue(temp.right);
			}else{
				System.out.println("\n");
				queue.enqueue(null);
				i++;
			}
		}
	}
	
	public int height(Node root){
		if(root == null || (root.left == null && root.right == null))
			return 0;
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	public int heightIterative(Node root){
		int maxHeight = Integer.MIN_VALUE;
		int height = 0;
		Stack<Node> stack = new Stack<Node>();
		Node start = root;
		
		while(true){
			while(start != null){
				stack.push(start);
				start = start.left;
				height++;
			}
			if(height > maxHeight){
				maxHeight = height;
			}
			if(stack.size() == 0)
				break;
			start = stack.pop();
			height--;
			start = start.right;	
		}
		return maxHeight;
	}
	
	public Node lca(Node start, T a, T b){
		if(start == null){
			return null;
		}
		if(start.data == a || start.data == b){
			return start;
		}
		Node leftLca = lca(start.left, a, b);
		Node rightLca = lca(start.right, a, b);
		if(leftLca != null && rightLca != null){
			return start;
		}
		if(leftLca != null)
			return leftLca;
		return rightLca;
	}
	
	public int findDistance(T a, T b){
		Node lca = lca(root, a, b);
		return findDistanceUtil(lca, a, 0) + findDistanceUtil(lca, b, 0);
	}
	
	public int findDistanceUtil(Node start, T a, int d){
		if(start == null)
			return Integer.MAX_VALUE;
		if(start.data == a)
			return d;
		return Math.min(findDistanceUtil(start.left, a, d+1), findDistanceUtil(start.right, a, d+1));
	}

	
	public void inorderIterative(Node root){
		if(root == null)
			return;
		Node start = root;
		Stack<Node> stack = new Stack<Node>();
		while(true){
			while(start != null){
			stack.push(start);
			start = start.left;
			}
			if(stack.size() <= 0){
				break;
			}
			start = stack.pop();
			System.out.println(start.data);
			start = start.right;
		}
		
	}
	
	public void printRootToLeaf(){
		ArrayList<Node> arrayList = new ArrayList<Node>();
		printRootToLeafUtil(root, arrayList);
	}
	
	public void printRootToLeafUtil(Node start, ArrayList<Node> arrayList){
		if(start == null){
			return;
		}
		arrayList.add(start);
		if(start.left == null && start.right == null){
			printArrayList(arrayList);
		}
		printRootToLeafUtil(start.left, arrayList);
		printRootToLeafUtil(start.right, arrayList);
		arrayList.remove(arrayList.size() - 1);
	}
	
	public void printArrayList(ArrayList<Node> arrayList){
		for(Node node: arrayList){
			System.out.print(node.data);
		}
		System.out.println("\n");
	}
	
	/*public Node constructTree(ArrayList<T> post, ArrayList<T> inorder, int in1, int in2){
		if(in1 > in2)
			return null;
		int inIndex = findIndex(inorder, in1, in2, postIndex);
		if(inIndex != -1){
			Node temp = new Node(post.get(postIndex));
			postIndex --;
			temp.right = constructTree(post, inorder, inIndex + 1, in2);
			temp.left = constructTree(post, inorder, in1, inIndex - 1);
			return temp;
		}
		return null;
	}
	*/
	public void findAncestors(T data){
		ArrayList<Node> arrayList = new ArrayList<Node>();
		findAncestorsUtil(root, arrayList, data);
	}
	
	public void findAncestorsUtil(Node start, ArrayList<Node> arrayList, T data){
		if(start == null)
			return;
		arrayList.add(start);
		if(start.data == data){
			//printArrayList(arrayList);
			closestLeafUtil(arrayList);
			return;
		}
		findAncestorsUtil(start.left, arrayList, data);
		findAncestorsUtil(start.right, arrayList, data);
		arrayList.remove(arrayList.size()-1);
	}
	
	public void rootToLeafSum(int sum){
		System.out.println(rootToLeafSumUtil(root, sum, 0));
	}
	
	public boolean rootToLeafSumUtil(Node<Integer> start, int sum, int total){
		if(start == null){
			return false;
		}
		
		total += start.data;
		
		if(start.left == null && start.right == null){
			return sum == total;
		}
		
		return rootToLeafSumUtil(start.left, sum, total) || rootToLeafSumUtil(start.right, sum, total) ;
		
	}
	
	public int maxWidth(){
		Queue<Node> queue = new Queue<Node>();
		queue.enqueue(root);
		int maxWidth = 0;
		while(queue.size() != 0){
			int count = queue.size();
			maxWidth = Math.max(count, maxWidth);
			while(count>0){
				Node temp = queue.dequeue();
				count--;
				if(temp.left != null){
					queue.enqueue(temp.left);
				}
				if(temp.right != null){
					queue.enqueue(temp.right);
				}
			}
		}
		return maxWidth;
	}
	
	/*
	Space Complexity: O(1)
	*/
	public void connectSameLevelNodes(){                                  
		Node start = root;
		Node nextLevel = root;
		root.nextRight = null;
		while(nextLevel != null){
			start = nextLevel;
			while(start != null){
				if(start.left != null){
					if(start.right != null){
						start.left.nextRight = start.right;
						start.right.nextRight = getNextRight(start);
					}else{
						start.left.nextRight = getNextRight(start);
					}
				}else{
					if(start.right != null){
						start.right.nextRight = getNextRight(start);
					}
				}
				start = start.nextRight;
			}
			if(nextLevel.left != null){
				nextLevel = nextLevel.left;
			}else if(nextLevel.right != null){
				nextLevel = nextLevel.right;
			}else{
				nextLevel = getNextRight(nextLevel);
			}
		}
	}
	
	public Node getNextRight(Node start){
		if(start.nextRight != null){
			if(start.nextRight.left != null)
				return start.nextRight.left;
			
			return start.nextRight.right;
		}
		return null;
	}
	
	public void printSameLevel(Node start){
		if(start == null)
			return;
		Node temp = start;
		while(temp != null){
			System.out.print(temp.data+"---->");
			temp = temp.nextRight;
		}
		System.out.println("\n");
		if(start.left != null){
			printSameLevel(start.left);
		}else if(start.right != null){
			printSameLevel(start.right);
		}else{
			printSameLevel(getNextRight(start));
		}
	}
	
	public void morrisTraversal(){
		Node start = root;
		Node current;
		while(start != null){
			if(start.left == null){
				System.out.println(start.data);
				start = start.right;
			}else{
				current = start.left;
				while(current.right != null && current.right != start){
					current = current.right;
				}
				if(current.right == null){
					System.out.println(start.data);
					current.right = start;
					start = start.left;
				}
				if(current.right == start){
					current.right = null;
					start = start.right;
				}
			}
		}
	}
	
	public Node constructTree(ArrayList<Integer> pre, ArrayList<Integer> in, int inIndex1, int inIndex2, int preIndex){
		if(inIndex1 > inIndex2){
			return null;
		}
		if(inIndex1 == inIndex2){
			Node<Integer> temp = new Node<Integer>(in.get(inIndex1));
			return temp;
		}
		int index = findIndex(pre.get(preIndex), in);
		Node<Integer> temp = new Node<Integer>(in.get(index));
		
		temp.left = constructTree(pre, in, inIndex1, index-1, preIndex+1);
		temp.right = constructTree(pre, in, index+1, inIndex2, preIndex+index - inIndex1+1);
		return temp;
	}
	
	int findIndex(int x, ArrayList<Integer> arrayList){
		for(int i = 0; i < arrayList.size(); i++){
			if(x == arrayList.get(i)){
				return i;
			}
		}
		return -1;
	}
	
	public Node constructSpecialPreOrder(ArrayList<Integer> pre, ArrayList<Character> preLN){
			if(index >= pre.size()){
				return null;
			}
			
			Node<Integer> temp = new Node<Integer>(pre.get(index));
			index++;
			try{
			if(preLN.get(index-1) == 'N'){
				temp.left = constructSpecialPreOrder(pre, preLN);
				temp.right = constructSpecialPreOrder(pre, preLN);
			}}catch(Exception ex){
				System.out.println(ex);
			}
			
			return temp;
	}
	
	void closestLeaf(T key){
		findAncestors(key);
	}
	
	void closestLeafUtil(ArrayList<Node> anc){
		ArrayList<Integer> dist = new ArrayList<Integer>();
		int minLeafDist = Integer.MAX_VALUE;
		for(int i=0; i < anc.size(); i++){
			if(anc.get(i).left == null && anc.get(i).right == null){
				minLeafDist = 0;
			}else{
				minLeafDist = Math.min(height(anc.get(i).left),height(anc.get(i).right))+1;
			}
			System.out.println("For"+anc.get(i).data+"min height is:"+minLeafDist);
			for(int j = i-1; j >= 0; j--){
				if(dist.get(j) > minLeafDist)
					break;
				minLeafDist = Math.min(minLeafDist, dist.get(j)+i-j);
			}
			dist.add(i, minLeafDist);
		}
		System.out.println("Closest leaf from node is at a distance of:"+minLeafDist);
	}
	
	Node deleteSumK(Node<Integer> start, int sum, int k){
		if(start == null)
			return null;
		sum = sum + start.data;
		start.left = deleteSumK(start.left,sum , k);
		start.right = deleteSumK(start.right, sum , k);
		if(start.left == null && start.right == null && sum<k){	
			return null;
		}
		return start;
	}
}