package stacks;

public class Main{

public static void main(String args[]){
	StackProblems sp = new StackProblems();
	//sp.infixToPostfix("a+(b-c)*d");
	sp.evaluatePostfix("123*+5-");
}
}