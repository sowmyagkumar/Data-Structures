package com.datastructures.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by kumars217 on 12/28/2016.
 */

class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;

    Node(int data){
        this.data=data;
        left=null;
        right=null;
        nextRight=null;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }

    public Node getLeft(){
        return left;
    }

    public void setLeft(Node left){
        this.left=left;
    }

    public Node getRight(){
        return right;
    }

    public void setRight(Node right){
        this.right=right;
    }
}

public class BinaryTree {
    Node root;

    public void setRoot(Node start){
        root=start;
    }

    public void inorderRecursive(Node start){
        if(start==null){
            return;
        }
        inorderRecursive(start.getLeft());
        System.out.println(start.getData());
        inorderRecursive(start.getRight());
    }

    public void preorderRecursive(Node start){
        if(start==null){
            return;
        }
        System.out.println(start.getData());
        preorderRecursive(start.getLeft());
        preorderRecursive(start.getRight());
    }

    public void postorderRecursive(Node start){
        if(start==null){
            return;
        }
        postorderRecursive(start.getLeft());
        postorderRecursive(start.getRight());
        System.out.println(start.getData());
    }

    public void inorderIterative(Node start){
        Stack<Node> stack = new Stack<Node>();
        while (start!=null){
            stack.push(start);
            start=start.left;
        }
        while (stack.size()>0){
            start = stack.pop();
            System.out.println(start.getData());
            if(start.getRight()!=null){
                start=start.getRight();
                while(start!=null){
                    stack.push(start);
                    start=start.getLeft();
                }
            }
        }
    }

    public void preorderIterative(Node start){
        Stack<Node> stack = new Stack<Node>();
        while(true) {
            while (start != null) {
                System.out.println(start.getData());
                stack.push(start);
                start = start.left;
            }
            if(stack.size()<=0)
                return;
            start = stack.pop();
            start = start.getRight();
        }
    }

    public int heightOfTree(Node start){
        if (start == null){
            return 0;
        }
        int leftHeight = heightOfTree(start.getLeft());
        int rightHeight = heightOfTree(start.getRight());

        if (leftHeight>rightHeight)
            return leftHeight+1;

        return rightHeight+1 ;
    }

    public void levelorder(Node start){
        int height = heightOfTree(start);
        for(int i=1;i<=height;i++){
            printLevel(start, i);
        }
    }

    public void reverseLevelorder(Node start){
        int height = heightOfTree(start);
        for(int i=height;i>=1;i--){
            printLevel(start, i);
        }
    }

    public void printLevel(Node start, int level){
        if(start!=null) {
            if (level == 1) {
                System.out.println(start.getData());
                return;
            }
            printLevel(start.getLeft(),level-1);
            printLevel(start.getRight(),level-1);
        }
    }

    public Node lca(int n1, int n2, Node start){
        if(isPresent(n1,start) && isPresent(n2,start)){
            return lcaUtil(n1, n2, start);
        }
        return null;
    }

    public Node lcaUtil(int n1, int n2, Node start){
        if(start == null)
            return null;
        if (start.getData() == n1 || start.getData() == n2)
            return start;
        Node leftSub = lcaUtil(n1, n2, start.getLeft());
        Node rightSub = lcaUtil(n1, n2, start.getRight());
        if (leftSub!=null && rightSub!= null)
            return start;
        return (leftSub!=null)? leftSub: rightSub;
    }

    public boolean isPresent(int n, Node start){
        if (start == null)
            return false;
        if (start.getData() == n)
            return true;
        return isPresent(n, start.getLeft()) || isPresent(n, start.getRight());
    }

    public int diameter(Node start){
        if(start == null){
            return 0;
        }

        int leftHeight = heightOfTree(start.getLeft());
        int rightHeight = heightOfTree(start.getRight());
        return Math.max(leftHeight+rightHeight+1, Math.max(diameter(start.getLeft()), diameter(start.getRight())));
    }

    public void mirror(Node start){
        if(start == null)
            return;
        mirror(start.getLeft());
        mirror(start.getRight());
        Node temp = start.getLeft();
        start.setLeft(start.getRight());
        start.setRight(temp);
        return;
    }

    public boolean areIdentical(Node p, Node q){
        if(p == null && q == null)
            return true;
        if((p == null && q != null)|| (q == null && p != null))
            return false;
        return (areIdentical(p.getLeft(),q.getLeft()) && areIdentical(p.getRight(), q.getRight()));
    }

    public boolean areMirrorImages(Node p, Node q){
        if(p == null && q == null)
            return true;
        if(p != null && q != null){
            if(p.getData() == q.getData()){
                return areMirrorImages(p.getLeft(), q.getRight()) && areMirrorImages(p.getRight(),q.getLeft());
            }
        }
        return false;
    }

    public void verticalSum(Node start, int horizontalDistance, HashMap<Integer, Integer> hashMap){
        if(start == null)
            return;
        if(start.getLeft() != null)
            verticalSum(start.getLeft(), horizontalDistance-1, hashMap);
        int prevSum = (hashMap.get(horizontalDistance) != null)? hashMap.get(horizontalDistance): 0;
        hashMap.put(horizontalDistance, prevSum + start.getData());
        if (start.getRight() != null)
            verticalSum(start.getRight(), horizontalDistance+1, hashMap);
        return;
    }

    public void ancestors(Node start, int n, Stack<Integer> stack){
        if (start == null)
            return;
        if (start.getData() == n ){
            while(!stack.isEmpty()){
                System.out.println(stack.pop());
            }
        }
        stack.push(start.getData());
        ancestors(start.getLeft(), n, stack);
        ancestors(start.getRight(), n, stack);
        if(!stack.isEmpty())
            stack.pop();
    }

    public void leafToRoot(Node start, ArrayList<Integer> arrayList){
        if(start == null)
            return;
        arrayList.add(start.getData());
        if(start.getLeft() == null && start.getRight() == null){
            printArrayList(arrayList);
        }
        leafToRoot(start.getLeft(), arrayList);
        leafToRoot(start.getRight(), arrayList);
        arrayList.remove(arrayList.size()-1);
    }

    public void printArrayList(ArrayList<Integer> arrayList){
        for (int i=0; i<arrayList.size(); i++)
            System.out.print(arrayList.get(i)+" ");
        System.out.println("\n");
    }

    public void printK(Node start, int k){
        if(start == null || k<0)
            return;
        if(k == 0){
            System.out.println(start.getData());
            return;
        }
        printK(start.getLeft(), k-1);
        printK(start.getRight(), k-1);
    }

    public void width(Node start, int level, HashMap<Integer, Integer> hm){
        if(start == null)
            return;
        int prev = (hm.get(level) == null)?0:hm.get(level);
        hm.put(level, prev+1);

        width(start.getLeft(), level+1, hm);
        width(start.getRight(), level+1, hm);
    }

    public int maxWidth(HashMap<Integer, Integer> hm){
        int maxWidth=0;
        for(int val : hm.values()){
            maxWidth=(maxWidth<val)?val:maxWidth;
        }
        return maxWidth;
    }

    public void connectSameLevel(Node start){
        if(start == null)
            return;
        if (start.getLeft()!= null){
            if(start.getRight()!= null){
                start.getLeft().nextRight=start.getRight();
                if(start.nextRight!=null)
                    start.getRight().nextRight=(start.nextRight.getLeft()!=null)?start.nextRight.getLeft():start.nextRight.getRight();
            }else{
                if(start.nextRight!=null)
                    start.getLeft().nextRight=(start.nextRight.getLeft()!=null)?start.nextRight.getLeft():start.nextRight.getRight();
            }
        }
        connectSameLevel(start.getLeft());
        connectSameLevel(start.getRight());
    }
}
