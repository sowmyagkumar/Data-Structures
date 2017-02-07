package stacks;

public class Main{

public static void main(String args[]){
	StackProblems sp = new StackProblems();
	//sp.infixToPostfix("a+(b-c)*d");
	//sp.evaluatePostfix("123*+5-");
	/*StackUsingQueue<Integer> sq = new StackUsingQueue<Integer>();
	sq.push(9);
	sq.push(19);
	sq.push(29);
	sq.push(39);
	System.out.println(sq.pop());
	System.out.println(sq.pop());
	System.out.println(sq.pop());
	System.out.println(sq.pop());
	*/
	Stack<Integer> stack = new Stack<Integer>();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	stack.push(4);
	stack.push(5);
	//sp.reverseStackRecurse(stack);
	stack.printStack(stack);
}
}