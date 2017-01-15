package lists;

public class Main{

public static void main(String[] args){
	LinkedList linkedList = new LinkedList();
	linkedList.addNode(3);
	linkedList.addNode(16);
	linkedList.addNode(70);
	linkedList.addNode(8);
	linkedList.addNode(9);
	linkedList.addNode(10);
	linkedList.addNode(11);
	linkedList.addNode(180);
	linkedList.addNode(19);
	
	LinkedList ll = new LinkedList();
	ll.addNode(9);
	ll.addNode(9);
	ll.addNode(9);
	ll.addNode(4);
	
	/*DoublyLinkedList dll = new DoublyLinkedList();
	dll.push(20);
	dll.push(80);
	dll.insertAtEnd(90);
	dll.insertAt(50, 0);
	System.out.println("Before reversal:");
	dll.printDll(dll.head);
	System.out.println("After reversal:");
	dll.reverseDll();
	dll.printDll(dll.head);
	*/
	
	
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
	//linkedList.printList(linkedList.segregateOddEven());
	//linkedList.printList(linkedList.sortedIntersectionRecur(linkedList.head, ll.head));
	//linkedList.printList(linkedList.swapNodes(20,11));
	//linkedList.printList(linkedList.deleteMiddle());
	//linkedList.deleteNM(2,2);
	//linkedList.printList(linkedList.reverseAltK(linkedList.head, 1, 3));
	//linkedList.swapKth(2);
	//linkedList.printList(linkedList.head);
	//linkedList.alternateSplit();
	//linkedList.reverseAltAppend();
	//linkedList.printList(linkedList.reverseK(linkedList.head, 5));
	//linkedList.printList(linkedList.mergeListsIter(linkedList.head, ll.head));
	//linkedList.printList(linkedList.mergeSorted(linkedList.head, ll.head));
	//linkedList.printList(linkedList.diff(linkedList.head, ll.head));
	//linkedList.sumPair(17);
	linkedList.printList(linkedList.mergeSort(linkedList.head));
}

}