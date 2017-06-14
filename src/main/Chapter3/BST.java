package main.Chapter3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import main.Test;
import main.VisualAccumulator;

/**
 * Created by leishaw on 09/06/2017.
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left,right;    //links to subtree
        private int N;              //# nodes in subtree rooted here

        public Node(Key key,Value val,int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public boolean contains(Key key){
        if(root == null) return false;
        boolean judge = false;
        Value val = get(root,key);
        if(val != null) judge = true;
        return judge;
    }

    public boolean contains(Key key,Test t){
        if(root == null) return false;
        boolean judge = false;
        Value val = get(root,key);
        if(val != null) judge = true;
        return judge;
    }

    public int size(){
        return size(root);
    }

    public int size(Node x){
        if(x == null) return 0;
        else          return x.N;
    }

    public void put(Key key,Value val){
        root = put(root,key,val);
    }

    public Node put(Node x,Key key,Value val){
        //Change key's value to val if key in subtree rooted at x.
        //Otherwise,add new node to subtree associating key with val.
        if(x == null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if (cmp<0)    x.left  = put(x.left, key,val);
        else if(cmp>0)x.right = put(x.right,key,val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Node x,Key key){
        //Return value associated with key in the subtree rooted at x;
        //return null if key not present in subtree rooted at x.
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0) return get(x.left,key);
        else if(cmp > 0) return get(x.right,key);
        else return x.val;
    }

    public Key select(Node x,int rank){
        int t = size(x);
        if(t == rank) return x.key;
        if(t > rank)  return select(x.left,rank);
        else          return select(x.right,rank-t-1);
    }

    public int rank(Key key, Node x){
        if(x == null)   return 0;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return size(x.left);
        else if(cmp > 0) return 1+size(x.left)+rank(key,x.right);
        else             return rank(key,x.left);
    }

    private Node delete(Key key,Node x){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)      return x.right = delete(key,x.right);
        else if(cmp < 0) return x.left  = delete(key,x.left);
        else {
            if(x.left == null)  return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = deleteMin(t.right);
            x.left  = t.left;
            x.right = t.right;
        }
        x.N = x.left.N + x.right.N;
        return x;
    }

    public Node deleteMin(){
        return deleteMin(root);
    }

    private Node deleteMin(Node x){
        if(x == null)      return null;
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }


    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root,key);
        if(x == null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0)  return floor(x.left,key);
        Node t = floor(x.right,key);
        if(t != null) return t;
        else          return x;
    }

    private Node ceiling(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp > 0)  return ceiling(x.right,key);
        Node t = floor(x.left,key);
        if(t != null)return t;
        else         return x;
    }

    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new Queue();
        keys(root,queue,lo,hi);
        return queue;
    }

    public void keys(Node x,Queue<Key> queue,Key lo,Key hi){
        if(x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0) keys(x.left,queue,lo,hi);
        if(cmplo>=0 && cmphi<=0) queue.enqueue(x.key);
        if(cmphi > 0) keys(x.right,queue,lo,hi);
    }

    public void print(Node x){
        if(x == null) return;
        print(x.left);
        StdOut.println(x.key);
        print(x.right);
    }

    public static void main(String[] args){

    }
}
