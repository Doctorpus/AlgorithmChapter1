package main.Chapter2.PriorityQueue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 27/05/2017.
 * Create a priority queue of capacity maxN with possible indices between 0 and maxN-1
 */
public class MyIndexMinPQ<Item extends Comparable<Item>> {
    //number of the items
    private int N;
    //binary heap to restore all the items
    private Item[] pq;

    //insert item; associate it with k
    public void insert(int k, Item item){}

    //change the item associated with k to item
    public void change(int k, Item item){}

    //is k associated with some item?
    boolean contains(int k){return true;}

    //return a minimal item
    Item min(){return null;}

    //return a minimal item's index
    int minIndex() {return 0;}

    //remove a minimal item and return its index
    int delMin(){return 0;}

    //is the priority queue empty
    boolean isEmpty(){return true;}

    //number of items in the priority queue
    int size(){return 0;}

    public static void main(String[] args){
        In stream = new In("/Users/leishaw/Downloads/algs4-data/m1.txt");
        while(!stream.isEmpty()){
            StdOut.println(stream.readString());
        }
    }
}
