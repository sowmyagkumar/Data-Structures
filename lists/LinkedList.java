package lists;

import java.util.HashSet;

class Node{
	int data;
	Node next;

	Node(){}
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	public int getData(){
		return data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
}

public class LinkedList{
	Node head;
	int i = 1;
	static int carry=1;
	
	public void addNode(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node start = head;
		while(start.getNext() != null){
			start = start.getNext();
		}
		start.next = new Node(data);
	}
	
	public void reverseLinkedList(){
		Node temp = reverseLinkedListUtil(head);
		temp.next = null;
	}
	
	public Node reverseLinkedListUtil(Node start){
		if(start == null || start.getNext() == null){
			head = start;
			return start;
		}
		Node temp = reverseLinkedListUtil(start.getNext());
		temp.next = start;
		return start;
	}
	
	public void NFromEnd(Node start, int n){
		if(start == null)
			return;
		NFromEnd(start.getNext(), n);
		if(i == n)
			System.out.println(n+"th node from end:"+start.getData());
		i++;
	}
	
	public void deleteAlternate(){
		head = deleteAlternateUtil(head);
	}
	
	public Node deleteAlternateUtil(Node prev){
		if(prev == null || prev.getNext() == null)
			return prev;
		Node curr = prev.getNext();
		Node temp = curr.getNext();
		prev.setNext(deleteAlternateUtil(temp));
		curr.setNext(null);
		return prev;
	}
	
	public void printReverse(Node start){
		if(start == null)
			return;
		printReverse(start.getNext());
		System.out.print(start.getData()+"--->");
		
	}
	
	public void printList(Node head){
		Node start = head;
		while(start != null){
			System.out.println(start.getData()+"-->");
			start = start.getNext();
		}
	}
	
	public void deleteNodeSinglePointer(Node start){
		Node nextNode = start.getNext();
		if(nextNode != null){
			start.setNext(nextNode.getNext());
			start.setData(nextNode.getData());
		}
		
	}
	
	public void printMiddle(){
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		if(slow != null){
			System.out.println("Middle element is:"+ slow.getData());
			return;
		}
		System.out.println("Empty list.");
	}
	
	public void insertAscending(int data){
		if(head == null || head.getData() > data){
			Node temp = new Node(data);
			temp.next = head;
			head = temp;
			return;
		}
		Node curr = head;
		while (curr.next != null && curr.next.data < data)
                  curr = curr.next;
		Node newNode = new Node(data);
        newNode.next = curr.next;
        curr.next = newNode;
	}
	
	public void moveLastElement(){
		Node prev = head;
		if(prev == null)
			return;
		Node curr = prev.getNext();
		if(curr == null)
			return;
		while(curr.getNext() != null){
			prev = curr;
			curr = curr.getNext();
		}
		prev.setNext(null);
		curr.setNext(head);
		head = curr;
	}
	
	public void rotateList(int k){
		int len = 0;
		int i = k;
		if(head == null || k == 0)
			return;
		Node start = head;
		while(start != null && k>1){
			len++;
			start = start.getNext();
			k--;
		}
		
		Node newHead = start.getNext();
		start.next = null;
		start = newHead;
		while(start.next != null)
			start = start.next;
		start.next = head;
		head = newHead;
	}
	
	public void reversePairsIterative(Node prev){
		if(prev == null || prev.getNext() == null)
			return;
		Node curr = prev.next;
		Node temp;
		head = curr;
		while(prev != null && prev.getNext() != null){
			curr = prev.getNext();
			temp = curr.getNext();
			curr.next = prev;
			if(temp != null){
				prev.next = temp.next;
			}else{
				prev.next = temp;
			}
			prev = temp;
		}
	}
	
	public void reversePairsRecursive(){
		head = reversePairsRecursiveUtil(head);
	}
	
	public Node reversePairsRecursiveUtil(Node prev){
		if(prev == null || prev.next == null)
			return prev;
		Node curr = prev.next;
		Node temp = curr.next;
		curr.next = prev;
		prev.next = reversePairsRecursiveUtil(temp);
		return curr;
	}
	
	public static int len(Node s){
		int l=0;
		while(s!=null){
			l++;
			s = s.next;
		}
		return l;
	}
	public static Node sameLengthSum(Node s1, Node s2){
		int l1 = len(s1);
		int l2 = len(s2);
		if(l1<l2){
			Node exchange = s1;
			s1 = s2;
			s2 = exchange;
		}
		if(l1 != l2){
			int diff = l1-l2;
			for(int i=0; i<diff; i++){
				Node dumb = new Node(0);
				dumb.next = s2;
				s2 = dumb;
			}
		}
		Node headOfSum = sameLengthSumUtil(s1, s2);
		if(carry != 0){
			Node temp = new Node(carry);
			temp.next = headOfSum;
			headOfSum = temp;
			carry=0;
		}
		return headOfSum;
	}
	
	public static Node sameLengthSumUtil(Node s1, Node s2){
		if(s1 == null)
			return null;
		
		Node temp = new Node();
		temp.next = sameLengthSumUtil(s1.next, s2.next);
		int val = s1.getData()+s2.getData()+carry;
		temp.data = val%10;
		carry = val/10;
		return temp;
	}
	
	public Node addOne(){
		addOneUtil(head);
		if(carry != 0){
			Node temp = new Node(carry);
			temp.next = head;
			head = temp;
		}
		return head;
	}
	
	public void addOneUtil(Node start){
		if(start == null)
			return;
		addOneUtil(start.next);
		int val = start.data +carry;
		start.data = val%10;
		carry = val/10;
	}
	
	public int findDecimal(Node start){
		if(start == null)
			return 0;
		int val = 0;
		while(start!= null){
			val = 2*val +start.data;
			start = start.next;
		}
			return val;
	}
	
	public Node addLists( Node h1, Node h2){
		Node h=null;
		Node curr=null;
		int carry = 0;
		while(h1 != null || h2 != null){
			int val = carry + ((h1 == null)?0:h1.data) +((h2 == null)? 0:h2.data);
			carry = val / 10;
			Node temp = new Node( val %10);
			if(h == null){
				h = temp;
			}else{
				curr.next = temp;
			}
			curr = temp;
			if(h1 != null)
				h1 = h1.next;
			if(h2 != null)
				h2 = h2.next;
		}
		return h;
	}
	
	public Node union(Node h1, Node h2){
		HashSet<Integer> hs = new HashSet<Integer>();
		Node h = null;
		Node prev = null;
		while(h1 != null){
				if(h == null){
					h = new Node(h1.data);
					prev = h;
				}else{
					if(!hs.contains(h1.data)){
					prev.next = new Node(h1.data);
					prev = prev.next;
					}
				}
				hs.add(h1.data);
				h1 = h1.next;
		}
		while(h2 != null){
			if(!hs.contains(h2.data)){
				if(h == null){
					h = new Node(h2.data);
					prev = h;
				}else{
					prev.next = new Node(h2.data);
					prev = prev.next;
				}
			}
			h2 = h2.next;
		}
		return h;	
	}
	
	public Node intersection(Node h1, Node h2){
		HashSet<Integer> hs = new HashSet<Integer>();
		Node h = null;
		Node prev = null;
		while(h1 != null){
				hs.add(h1.data);
				h1 = h1.next;
		}
		while(h2 != null){
			if(hs.contains(h2.data)){
				if(h == null){
					h = new Node(h2.data);
					prev = h;
				}else{
					prev.next = new Node(h2.data);
					prev = prev.next;
				}
			}
			h2 = h2.next;
		}
		return h;	
	}
	
	public Node removeDuplicates(){
		if(head == null)
			return null;
		
		Node prev = head;
		Node curr;
		
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(prev.data);
		
		while(prev.next != null){
			curr = prev.next;
			if(hs.contains(curr.data)){
				prev.next = curr.next;
			}
			hs.add(curr.data);
			prev = prev.next;
			
		}
		
		return head;
	}
	
	public Node deleteGreater(){
		if(head == null || head.next == null)
			return head;
		Node prev = null;
		Node curr = head;
		Node temp = null;
		while(curr.next != null){
			temp = curr.next;
			if(curr.data < temp.data){
				if(prev != null){
					prev.next = temp;
				}else{
					curr = null;
					head = temp;
				}
			}
			prev = curr;
			curr = temp;
		}
		return head;
	}
	
	public Node zigzag(){
		if(head == null || head.next == null)
			return head;
		Node prev = head;
		Node curr = head.next;
		int operation = 0; //if 0 then increasing fashion; 1 decreasing
		int temp;
		while(curr != null){
			if(operation == 0){
				if(prev.data > curr.data){
					temp = curr.data;
					curr.data = prev.data;
					prev.data = temp;
				}
				operation = 1;
			}else{
				if(prev.data < curr.data){
					temp = curr.data;
					curr.data = prev.data;
					prev.data = temp;
				}
				operation = 0;
			}
			prev = curr;
			curr = curr.next;
		}
		return head;
	}
	
	public Node segregateOddEven(){
		if(head == null || head.next == null)
			return head;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		Node curr = head;
		while(curr != null){
			if(curr.data % 2 == 0){
				if(evenEnd == null)
					head = curr;
				if(evenEnd != null)
					evenEnd.next = curr;
				evenEnd = curr;
			}else{
				if(oddStart == null)
					oddStart = curr;
				if(oddEnd != null)
					oddEnd.next = curr;
				oddEnd = curr;
			}
			curr = curr.next;
		}
		if(evenEnd != null)
			evenEnd.next = oddStart;
		if(oddEnd != null)
			oddEnd.next = null;
		return head;
	}
	
	public Node sortedIntersectionIter(Node h1, Node h2){
		if(h1 == null || h2 == null)
			return null;
		Node h = null;
		Node curr = null;
		while(h1 != null && h2 != null){
			if(h1.data == h2.data){
				if(h == null){
					h = new Node(h1.data);
					curr = h;
				}else{
					curr.next = new Node(h1.data);
					curr = curr.next;
				}
				h1 = h1.next;
				h2 = h2.next;
			}
			if(h1.data > h2.data){
				h2 = h2.next;
			}
			if(h1.data < h2.data){
				h1 = h1.next;
			}
		}
		return h;
	}
	
	public Node sortedIntersectionRecur(Node h1, Node h2){
		if(h1 == null || h2 == null)
			return null;
		if(h1.data == h2.data){
			Node temp = new Node(h1.data);
			temp.next = sortedIntersectionRecur(h1.next, h2.next);
			return temp;
		}else if(h1.data > h2.data){
			return sortedIntersectionRecur(h1, h2.next);
		}
		return sortedIntersectionRecur(h1.next, h2);
	}
	
	
	public Node swapNodes(int xVal, int yVal){
		Node currX = head, prevX = null, currY = head, prevY = null;
		
		while(currX != null){
			if(currX.data == xVal){
				break;
			}
			prevX = currX;
			currX = currX.next;
		}
		while(currY != null){
			if(currY.data == yVal){
				break;
			}
			prevY = currY;
			currY = currY.next;
		}
		if(prevX == null){
			head = currY;
		}
		if(prevY == null){
			head = currX;
		}
		if(prevX!=null)
			prevX.next=currY;
		if(prevY!=null)
			prevY.next=currX;
		Node nextX= currX.next, nextY=currY.next;
		currX.next=nextY;
		currY.next=nextX;
		return head;
	}
	
	public Node deleteMiddle(){
		if(head == null || head.next == null)
			return null;
		
		Node slow = head;
		Node fast = head;
		Node prev = null;
		
		while(fast != null && fast.next !=null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;
		return head;
	}
	
	public void deleteNM(int n, int m){
		head = deleteNMUtil(head, n, m);
	}
	
	public Node deleteNMUtil(Node start, int n, int m){
		if(start == null)
			return start;
		
		int i = 0;
		Node curr = start;
		while(curr != null && i < n-1){
			curr = curr.next;
			i++;
		}
		if(curr == null)
			return start;
		Node temp = curr.next;
		i = 0;
		while(temp != null && i < m-1){
			temp = temp.next;
			i++;
		}
		
		if(temp == null)
			return start;
	
		curr.next = deleteNMUtil(temp.next, n, m);
		return start;
	}
	
	public Node reverseAltK(Node start, int rev, int k){
		if(start == null)
			return start;
		
		/* No reversal, only traverse k nodes*/
		if(rev == 0){
			Node curr = start;
			for(int i = 0; i < k-1 && curr != null ; i++)
				curr = curr.next;
			if(curr == null)
				return start;
			curr.next = reverseAltK(curr.next, 1, k);
			return start;
		}else{
			Node last = start;
			Node prev = start;
			Node curr = start.next;
			
			for(int i = 0; i < k-1 && curr != null; i++){
				Node temp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = temp;
			}
			last.next = reverseAltK(curr, 0, k);
			return prev;
		}
	}
}