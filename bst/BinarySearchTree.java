package bst;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

import trees.Node;

public class BinarySearchTree{
    Node<Integer> root;

	//To insert an element into the BST
	public void insert(int data){
	    if(root == null){
		    root = new Node(data);
			return;
		}
		Node start = root;
		Node parent = null;
		
		while(start != null){
		    parent = start;
			if((int)start.data > data){
			    start = start.left;
				continue;
			}
			start = start.right;
		}
		if((int)parent.data > data){
		    parent.left = new Node(data);
		}else{
		    parent.right = new Node(data);
		}
	}

	public Node<Integer> search(int data){
	    if(root == null)
		    return null;
	    Node<Integer> start = root;
		while(start != null){
		    if((int)start.data == data){
			    return start;
			}
			if((int)start.data > data){
			    start = start.left;
			}else{
			    start = start.right;
			}
		}
		return null;
	}
	
	//To delete a given element from the BST
	public Node delete(Node start, int data){
        if(start == null)
		    return null;
			
		if((int)start.data == data){
			if(start.left == null){
			    return start.right;
			}
			if(start.right == null){
			    return start.left;
			}
			Node temp = start.right;
			while(temp.left != null){
			    temp = temp.left;
			}
			start.data = temp.data;
			start.right = delete(start.right, (int)temp.data);
			return start;
		}
		
		if((int)start.data > data){
		    start.left = delete(start.left, data);
		}
		
		if((int)start.data < data){
		    start.right = delete(start.right, data);
		}
		
		return start;
	}
	
	//To print the inorder traversal of the BST
	public void inorder(Node root){
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		
		Node start = root;
		while(true){
		    while(start != null){
			    stack.push(start);
			    start = start.left;
		    }
		    if(stack.size() == 0)
			    break;
		    start = stack.pop();
		    System.out.println(start.data);
		    start = start.right;
	    }
	}
	
	//To print the inorder predecessor and successor of a given key
	public void inorderPreSucc(int data){
		if(root == null)
			return;
		
		Node start = root;
		Node pre = null;
		Node succ = null;
		
		while(start != null){
			if((int)start.data > data){
				succ = start;
				start = start.left;
				continue;
			}
			if((int)start.data < data){
				pre = start;
				start = start.right;
				continue;
			}
			if((int)start.data == data){
				if(start.left != null){
					Node temp = start.left;
					while(temp.right != null){
						temp = temp.right;
					}
					pre = temp;
				}
				if(start.right != null){
					Node temp = start.right;
					while(temp.left != null){
						temp = temp.left;
					}
					succ = temp;
				}
				int p = (pre == null)? 0:(int)pre.data;
				int s = (succ == null)? 0: (int)succ.data;
				System.out.println("Inorder predecessor: "+p+" successor:"+s);
				return;
			}
			
		}
		
	}
	
	//To find the least common ancestor of two keys
	public int lca(int k1, int k2){    //Assuming that both the keys are present in the tree
		if(root == null)
		    return -1;
		Node start = root;
		if(k1>k2){
			int temp = k1;
			k1 = k2;
			k2 = temp;
		}
		while(start != null){
			if((int)start.data > k1 && (int)start.data < k2)
				break;
			if((int)start.data > k2){
				start = start.right;
				continue;
			}
			if((int)start.data < k1){
				start = start.left;
				continue;
			}
		}
		int s = (start == null)?-1: (int)start.data;
		return s;
	}
	
	//To find the kth smallest element iteratively
	public void kthSmallestIterative(int k){
		Stack<Node> stack = new Stack<Node>();
		if(root == null || k == 0)
			return;
		int count = 0;
		Node start = root;
		while(true){
		    while(start != null){
			    stack.push(start);
			    start = start.left;
		    }
			if(stack.size() == 0)
				break;
			start = stack.pop();
			count++;
			if(count == k){
				System.out.println(start.data);
				return;
			}
			start = start.right;
		}
	}
	
	//Returns true if there exists a pair whose sum is as given. Time complexity: O(n). Space complexity: O(n)
    public boolean sumPresent(int sum){
		if(root == null){
			if(sum == 0)
			    return true;
			if(sum != 0)
				return false;
        }
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		Node start = root;
		while(true){
			while(start != null){
				stack.push(start);
				start = start.left;
			}
			if(stack.size() == 0)
				break;
			start = stack.pop();
			arr.add((int)start.data);
			start = start.right;
		}
		
		int i = 0, j = arr.size()-1; 
		while(i < j){
			if(arr.get(i) + arr.get(j) == sum)
				return true;
			if(arr.get(i) + arr.get(j) > sum){
				j--;
				continue;
			}
			i++;
		}
		return false;
	}
	
	public boolean sumPresentOptimal(int sum){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node p1 = root;
		Node p2 = root;
		while(true){
			while(p1 != null){
				s1.push(p1);
				p1 = p1.left;
			}
			while(p2 != null){
				s2.push(p2);
				p2 = p2.right;
			}
			
			if(s1.size() == 0 || s2.size() == 0)
				return false;
			
			if( (int)s1.peek().data >= (int)s2.peek().data)
				return false;
			
			if(((int)s1.peek().data != (int)s2.peek().data) && ((int)s1.peek().data + (int)s2.peek().data == sum))
				return true;
			
			if((int)s1.peek().data + (int)s2.peek().data < sum){
				p1 = s1.pop();
				p1 = p1.right;
			}else{
				p2 = s2.pop();
				p2 = p2.left;
			}
			
		}
	}
	
	public void printMergedBST(Node root2){
		Node root1 = root;
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node p1 = root1;
		Node p2 = root2;
		
		while(true){
			while(p1 != null){
				s1.push(p1);
				p1 = p1.left;
			}
			while(p2 != null){
				s2.push(p2);
				p2 = p2.left;
			}
			if(s1.size() == 0 || s2.size() == 0)
				break;
			if((int)s1.peek().data < (int)s2.peek().data){
				p1 = s1.pop();
				System.out.println((int)p1.data);
				p1 = p1.right;
			}else{
			    p2 = s2.pop();
				System.out.println((int)p2.data);
				p2 = p2.right;
			}
		}
		
		while(s1.size() != 0){
		    p1 = s1.pop();
			System.out.println(p1.data);
			inorder(p1.right);
		}
		
		if(s2.size() != 0){
		    p2 = s2.pop();
			System.out.println(p2.data);
			inorder(p2.right);
		}
			
	}
	
	public void floor(int key){
		if(root == null){
			System.out.println("Floor is -1.");
			return;
		}
		Node start = root;
		Node floor = null;
		while(start != null){
			if((int)start.data == key){
				System.out.println("Floor is "+start.data);
				return;
			}
			if((int)start.data < key){
				floor = start;
				start = start.right;
				continue;
			}
			start = start.left;
		}
		if(floor != null){
			System.out.println("Floor is "+floor.data);
				return;
		}else{
		    System.out.println("Floor is -1.");
		}
	}
	
	public Node convertToBST(Node<Integer> root){
		if(root == null)
			return null;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		Node start = root;
		
		while(true){
			while(start != null){
				stack.push(start);
				start = start.left;
			}
			if(stack.size() == 0)
				break;
			start = stack.pop();
			arr.add((int)start.data);
			start = start.right;
		}
		
		Collections.sort(arr);
		
		start = root;
		int i = 0;
		while(true){
			while(start != null){
				stack.push(start);
				start = start.left;
			}
			if(stack.size() == 0)
				break;
			start = stack.pop();
			start.data = arr.get(i);
			i++;
			start = start.right;
		}
		inorder(root);
	    return null;	
	}
	
}