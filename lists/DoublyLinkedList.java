package lists;

class DllNode{
	int data;
	DllNode prev;
	DllNode next;
	
	DllNode(){}
	
	DllNode(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class DoublyLinkedList{
	DllNode head;
	
	public DllNode push(int data){
		if(head == null){
			head = new DllNode(data);
		}else{
			DllNode temp = new DllNode(data);
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		return head;
	}
	
	public DllNode insertAt(int data, int index){
		DllNode start = head;
		if (index == 0)
			return push(data);
		for(int i = 0; i < index && start != null; i++){
			start = start.next;
		}
		DllNode temp = new DllNode(data);
		start.prev.next = temp;
		temp.next = start;
		start.prev = temp;
		return head;
	}
	
	public DllNode insertAtEnd(int data){
		DllNode start = head;
		DllNode temp = new DllNode(data);
		if(start == null){
			start = temp;
		}else{
			while(start.next != null){
				start = start.next;
			}
			start.next = temp;
			temp.prev = start;
		}
		return head;
	}
	
	public void printDll(DllNode start){
		while(start != null){
			System.out.println(start.data);
			start = start.next;
		}
	}
	
	public DllNode deleteDllNode(int data){
		if(head == null || head.next == null)
			return null;
		DllNode start = head;
		while(start != null){
			if(start.data == data){
				if(start.prev != null){
					start.prev.next = start.next;
				}else{
					head = start.next;
					head.prev = null;
				}
				if(start.next != null){
					start.next.prev = start.prev;
				}
				break;
			}
			start = start.next;
		}
		return head;
	}
	
	public DllNode reverseDll(){
		DllNode start = head;
		while(start != null){
			DllNode temp = start.next;
			if(temp == null)
				head = start;
			start.next = start.prev;
			start.prev = temp;
			start = start.prev;
		}
		return head;
	}
}