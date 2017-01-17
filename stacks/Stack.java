package stacks;

import java.util.ArrayList;

public class Stack<T>{
	ArrayList<T> stack;
	
	Stack(){
		stack = new ArrayList<T>();
	}
	
	public void push(T data){
		stack.add(stack.size(), data);
	}
	
public T pop(){
	if(stack.size() != 0){
		return stack.remove(stack.size() -1);
	}
	return null;
}

public T peek(){
	if(stack.size() > 0){
		return stack.get(stack.size()-1);
	}
	return null;
}

public int size(){
	return stack.size();
}
}