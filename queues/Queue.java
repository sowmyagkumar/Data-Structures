package queues;

import java.util.ArrayList;

public class Queue<T>{
	T front;
	ArrayList<T> queue;
	
	public Queue(){
	queue = new ArrayList<T>();
	}
	
	public void enqueue(T t){
		if(queue == null){
			System.out.println("Queue is null");
			return;
		}
		queue.add(queue.size(), t);
	}
	
	public T dequeue(){
	if(queue.size() != 0)
		return queue.remove(0);
	return null;
	}
	
	public int size(){
		return queue.size();
	}
	
}