package main.Chapter2.PriorityQueue;

import edu.princeton.cs.algs4.StdOut;

import java.security.Key;

/**
 * Created by leishaw on 19/05/2017.
 */
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;               //elements
    private int n;                  //number of elements

    public UnorderedArrayMaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    public boolean isEmpty(){return n == 0;}
    public int size(){ return n;}
    public void insert(Key item){pq[n++] = item;}
    public Key  delMax(){
        int max = 0;
        for(int i = 1;i<n;i++)
            if(less(max,i)) max = i;
        exch(max,n-1);
        return pq[--n];
    }

    /**
     * Helper functions
     */
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i,int j){
        if(i>=n) {
            throw new RuntimeException("index exceeded size of pq");
        }
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**
     * Test routine
     */
    public static void main(String[] args){
//        UnorderedArrayMaxPQ<Integer> uamPQ = new UnorderedArrayMaxPQ<Integer>(10);
//        uamPQ.insert(111);
//        uamPQ.insert(738);
//        uamPQ.insert(293);
//        uamPQ.insert(234);
//        while(!uamPQ.isEmpty()){
//            StdOut.println(uamPQ.delMax());
//        }
        StdOut.println();
    }
}
