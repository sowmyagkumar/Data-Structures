package lists;

public class Main{

public static void main(String[] args){
	LinkedList linkedList = new LinkedList();
	linkedList.addNode(11);
	linkedList.addNode(15);
	linkedList.addNode(20);
	linkedList.addNode(25);
	linkedList.addNode(100);
	linkedList.addNode(6);
	linkedList.addNode(2);
	linkedList.addNode(3);
	
	LinkedList ll = new LinkedList();
	ll.addNode(9);
	ll.addNode(2);
	ll.addNode(7);

	//linkedList.reverseLinkedList();
	
	//linkedList.NFromEnd(linkedList.head, 6);
	//linkedList.printReverse(linkedList.head);
	//linkedList.deleteAlternate();
	//linkedList.deleteNodeSinglePointer(linkedList.head.getNext().getNext());
	//linkedList.moveLastElement();
	//linkedList.rotateList(5);
	//linkedList.reversePairsIterative(linkedList.head);
	//linkedList.printList();
	//linkedList.reversePairsRecursive();
	//Node sum = LinkedList.sameLengthSum(linkedList.head, ll.head);
	//linkedList.addOne();
	//System.out.println("Decimal value:"+linkedList.findDecimal(linkedList.head));
	//linkedList.printList(linkedList.intersection(linkedList.head, ll.head));
	//linkedList.printList(linkedList.removeDuplicates());
	//linkedList.printList(linkedList.deleteGreater());
	//linkedList.printList(linkedList.zigzag());
	linkedList.printList(linkedList.segregateOddEven());
}

}