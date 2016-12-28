package com.datastructures.linkedlist;

/**
 * Created by kumars217 on 12/27/2016.
 */
class LinkedList {
    private static Node head;
    private static Node left;

    class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }

        public int getData(){
            return data;
        }
        public void setData(int data){
            this.data=data;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }

    public static Node getHead(){
        return head;
    }

    public void setHead(Node node){
        head=node;
    }
    public void setLeft(){
        left=head;
    }
    public int getHeadData(){
        return head.getData();
    }

    public void addNode(int data){
        if (head==null){
            head=new Node(data);
            return;
        }

        Node current=head;
        while(current.getNext()!=null){
            current=current.getNext();
        }
        Node temp=new Node(data);
        current.setNext(temp);
        return;
    }

    public int getNodeFromEnd(int n){
        Node slow=head;
        Node fast=head;
        if(head!=null && n>=0) {
            int i=0;
            while (i < n) {
                if( fast== null){
                    System.out.println("The length of the linked list is less than the value of n.");
                    return -1;
                }
                fast = fast.getNext();
                i++;
            }
            while (fast!= null) {
                fast = fast.getNext();
                slow = slow.getNext();
            }
            return slow.getData();
        }
        System.out.println("The linked list is empty or the value of n is illegal.");
        return -1;
    }

    public int getMiddle(){
        if(head!=null){
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.getNext()!=null){
                fast=fast.getNext().getNext();
                slow=slow.getNext();
            }
            return slow.getData();
        }
        return -1;
    }

    public boolean checkCycle(){
        if(head!=null){
            Node slow=head;
            Node fast=head;

            while(slow != null && fast!=null && fast.getNext()!=null){
                slow=slow.getNext();
                fast=fast.getNext().getNext();
                if(slow==fast){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Node reverseListRecursive(Node start){
        if(start.getNext()==null){
            setHead(start);
            return start;
        }
        Node reverse=reverseListRecursive(start.getNext());
        reverse.setNext(start);
        return start;
    }

    public Node reverseListIterative(Node start){
        if(start!=null){
            Node before=null;
            Node after=start.getNext();
            while(start.getNext()!=null){
                start.setNext(before);
                before=start;
                start=after;
                after=start.getNext();
            }
            start.setNext(before);
            setHead(start);
            return start;
        }
        return start;
    }

    public void pairwiseSwap(Node start){
        int temp;
        while(start!=null && start.getNext()!=null){
            temp = start.getData();
            start.setData(start.getNext().getData());
            start.getNext().setData(temp);
            start=start.getNext().getNext();
        }
    }

    public boolean isPalindrome(Node right){
        if(right==null){
            return true;
        }
        if (isPalindrome(right.getNext())==false){
            return false;
        }
        if (left.getData()==right.getData()){
            left=left.getNext();
            return true;
        }
        return false;
    }
}
