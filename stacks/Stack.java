package stacks;

import java.util.ArrayList;

public class Stack<T>{
	ArrayList<T> stack;
	
	public Stack(){
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

public void printStack(Stack<T> stack){
		if(stack.size() == 0)
			return;
		T x = stack.pop();
		System.out.println(x);
		printStack(stack);
		stack.push(x);
}

}