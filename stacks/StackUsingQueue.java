package stacks;

import queues.Queue;
import java.util.ArrayList;

public class StackUsingQueue<T>{
	Queue<T> q1;
	Queue<T> q2;
	
	StackUsingQueue(){
		q1 = new Queue<T>();
		q2 = new Queue<T>();
	}
	
	public void push(T data){
		if(q1.size() == 0){
			q1.enqueue(data);
			return;
		}
		q2.enqueue(data);
		while(q1.size() > 0){
			q2.enqueue(q1.dequeue());
		}
		Queue<T> temp;
		temp = q1;
		q1 = q2;
		q2 = temp;
	}
	
	public T pop(){
		if(q1.size() == 0)
			return null;
		return q1.dequeue();
	}

}