package com.lstrong.algorithm.datastructure;


import java.util.Stack;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/12/20 12:37<br/>
 *
 * @author asus<br />
 * @since JDK 1.8
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root, e);
    }

    private Node add(Node node, E e){

        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right =add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){

        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void preOrderNR(Node node){
        if(node == null){
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()){
            Node cur = nodeStack.pop();
            System.out.println(cur.e);

            if(cur.right != null){
                nodeStack.push(cur.right);
            }

            if(cur.left != null){
                nodeStack.push(cur.left);
            }
        }

    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }

        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    private void inOrderNR(Node node){
        if(node == null){
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        Node cur = node;

        while (cur != null || !nodeStack.isEmpty()){
            while (cur != null){
                nodeStack.push(cur);
                cur = cur.left;
            }
            cur = nodeStack.pop();
            System.out.println(cur.e);
            cur = cur.right;
        }

    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

}
