package trees;

public class Node<T>{
    public Node left;
	public Node right;
	public Node nextRight;
	public T data;
	
	public Node(T data){
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