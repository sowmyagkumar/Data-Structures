package stacks;

public class StackProblems{

private boolean isOperand(char c){
	return ((c >= 65 && c <= 90) || (c>=97 && c<= 122));
}

private boolean isHigher(char c, char top){
	return ((c == '*' || c == '/') && (top == '+' || top == '-')); 
}

public void infixToPostfix(String str){
	if(str == null)
		return;
	Stack<Character> stack = new Stack<Character>();
	
	int len = str.length();
	for(int i = 0; i < len; i++){
		char c = str.charAt(i);
		if(isOperand(c)){
			System.out.print(c);
		}else{
			if(c == '('){
				stack.push(c);
			}else{
				if(c == ')'){
					while(stack.peek() != '('){
						System.out.print(stack.pop());
					}
					stack.pop();
				}else{
					if(stack.size() == 0){
						stack.push(c);
					}else{
						if(stack.peek() =='('){
							stack.push(c);
						}else{
							if(isHigher(c, stack.peek())){
								System.out.print(c);
							}else{
								System.out.print(stack.pop());
								stack.push(c);
							}
						}
					}
				}
			}
		}
	}
	while(stack.size() > 0)
		System.out.print(stack.pop());
}

public void pushBottom(Stack<Integer> stack, int x){
	if(stack.size() == 0){
		stack.push(x);
		return;
	}
	int y = stack.pop();
	pushBottom(stack, x);
	stack.push(y);
}

public void reverseStackRecurse(Stack<Integer> stack){
	if(stack.size() == 0){
		return;
	}
	int x = stack.pop();
	reverseStackRecurse(stack);
	pushBottom(stack, x);
}

/*public void infixToPrefix(String str){
	int len = str.length();
	Stack<Character> stack1 = new Stack<Character>();
	Stack<String> stack2 = new Stack<String>();
	
	for(int i = 0; i < len; i++){
		char c = str.charAt(i);
		if(isOperand(c)){
			stack2.push(c);
		}else{
			if(stack1.size() == 0){
				stack1.push(c);
			}else{
				if(c == '('){
					stack1.push(c);
				}else{
					if(c == ')'){
						while(stack1.peek() != '('){
							String op = stack1.pop();
							String s2 = stack2.pop();
							String s1 = stack2.pop();
							op = op.concat(s1);
							op = op.concat(s2);
							stack2.push(op);
						}
						stack1.pop();
					}else{
						if(stack1.peek() == '('){
							stack1.push(c);
						}else{
							if(isHigher(c, stack1.peek()){
								stack1.push(c);
							}else{
								String op = stack1.pop();
							String s2 = stack2.pop();
							String s1 = stack2.pop();
							op = op.concat(s1);
							op = op.concat(s2);
							stack2.push(op);
								stack1.push(c);
							}
						}
					}
				}
			}
		}
	} 
}*/

public void evaluatePostfix(String str){
	Stack<Integer> stack = new Stack<Integer>();
	int len = str.length();
	for(int i = 0; i < len; i++){
		char c = str.charAt(i);
		if(!isOperator(c)){
			stack.push(Character.getNumericValue(c));
		}else{
			int y = stack.pop();
			int x = stack.pop();
			stack.push(operate(x, y, c));
		}
	}
	System.out.println("Postfix evaluation:"+ stack.pop());
}

public int operate(int x, int y, char c){
	if(c == '+')
		return x+y;
	if(c == '-')
		return x-y;
	if(c == '*')
		return x*y;
	if(c == '/')
		return x/y;
	return -1;
}

public boolean isOperator(char c){
	return (c == '+' || c == '-' || c== '*' || c == '/'); 
}

}