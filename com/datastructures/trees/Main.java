package com.datastructures.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by kumars217 on 12/28/2016.
 */
public class Main {
    static BinaryTree binaryTree=new BinaryTree();

    public static void main(String[] args){
        binaryTree.setRoot(new Node(1));
        binaryTree.root.setLeft(new Node(22));
        binaryTree.root.setRight(new Node(2));
        binaryTree.root.getLeft().setLeft(new Node(23));
        binaryTree.root.getRight().setLeft(new Node(29));
        binaryTree.root.getRight().getLeft().setRight(new Node(129));
        binaryTree.root.getRight().getLeft().setLeft(new Node(229));
        binaryTree.root.getRight().setRight(new Node(329));

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        /*System.out.println("Inorder Traversal Recursive:");
        binaryTree.inorderRecursive(binaryTree.root);
        System.out.println("Preorder Traversal Recursive:");
        binaryTree.preorderRecursive(binaryTree.root);
        System.out.println("Postorder Traversal Recursive:");
        binaryTree.postorderRecursive(binaryTree.root);
        System.out.println("Inorder traversal Iterative:");
        binaryTree.inorderIterative(binaryTree.root);
        System.out.println("Preorder traversal Iterative:");
        binaryTree.preorderIterative(binaryTree.root);
        System.out.println("Levelorder traversal:");
        binaryTree.levelorder(binaryTree.root);
        System.out.println("Reverse Levelorder traversal:");
        binaryTree.reverseLevelorder(binaryTree.root);
        System.out.println("LCA of 23,29:"+binaryTree.lca(23,29,binaryTree.root).getData());
        System.out.println("Diameter of tree:"+binaryTree.diameter(binaryTree.root));
        binaryTree.mirror(binaryTree.root);

        binaryTree.verticalSum(binaryTree.root, 0, hashMap);
        if(hashMap != null)
            System.out.println(hashMap.entrySet());
        binaryTree.ancestors(binaryTree.root, 129, stack);*/

        binaryTree.leafToRoot(binaryTree.root, arrayList);
        binaryTree.printK(binaryTree.root, 2);
        binaryTree.width(binaryTree.root, 0, hm);
        System.out.println("Max width is:"+binaryTree.maxWidth(hm));
        binaryTree.connectSameLevel(binaryTree.root);
        System.out.println(binaryTree.root.getLeft().getLeft().nextRight.getData());
    }
}
