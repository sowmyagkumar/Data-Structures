package com.datastructures.linkedlist;

/**
 * Created by kumars217 on 12/27/2016.
 */
public class Main {
    public static LinkedList linkedList=new LinkedList();

    public static void main(String[] args){
        linkedList.addNode(10);
        linkedList.addNode(12);
        linkedList.addNode(10);
        linkedList.addNode(12);
        linkedList.addNode(1);
        System.out.println("nth node from end"+linkedList.getNodeFromEnd(1));
        System.out.println("middle node"+linkedList.getMiddle());
        System.out.println("check cycle:"+linkedList.checkCycle());
        linkedList.reverseListRecursive(LinkedList.getHead()).setNext(null);
        System.out.println("reverse list head element recursive:"+LinkedList.getHead().getData());
        linkedList.reverseListIterative(LinkedList.getHead());
        System.out.println("reverse list head element iterative:"+LinkedList.getHead().getData());
        linkedList.pairwiseSwap(LinkedList.getHead());
        System.out.println("head element after pairwise swap:"+LinkedList.getHead().getData());
        linkedList.setLeft();
        System.out.println(linkedList.isPalindrome(LinkedList.getHead()));
   }
}




