package main.Chapter2.PriorityQueue;

import edu.princeton.cs.algs4.StdOut;

import java.security.Key;

/**
 * Created by leishaw on 19/05/2017.
 */
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;           //elements
    private int n;              //number of elements

    public OrderedArrayMaxPQ(int capacity){
        pq = (Key[])new Comparable[capacity];
    }

    public void insert(Key item) {
        int i = n - 1;
        while (i>=0 && less(item, pq[i])){
            pq[i+1] = pq[i--];
        }
        pq[i+1] = item;
        n++;
    }

    public Key delMax(){
        return pq[--n];
    }

    public boolean isEmpty() {return n == 0;}

    /**
     *
     * Helper functions
     */
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private boolean less(Key a,Key b){
        return a.compareTo(b) < 0;
    }
    private void exch(int i,int j){
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**
     * Test routine
     */
    public static void main(String[] args){
        OrderedArrayMaxPQ<Integer> pq = new OrderedArrayMaxPQ<>(10);
        pq.insert(12);
        pq.insert(1);
        pq.insert(56);
        pq.insert(790);
        pq.insert(34);
        while(!pq.isEmpty()){
            StdOut.println(pq.delMax());
        }
    }
}
