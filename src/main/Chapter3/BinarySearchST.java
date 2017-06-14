package main.Chapter3;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import main.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by leishaw on 06/06/2017.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity){
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size(){ return N; }

    public boolean isEmpty(){
        if(N == 0) return true;
        return false;
    }

    public Value get(Key key){
        if(!isEmpty()){
            int r = rank(key,0,N-1);
            if(r<N && keys[r].compareTo(key) == 0) return vals[r];
        }
        return null;
    }

    /**
     * search for key. Update value if found; grow table if new
     * @param key
     * @param val
     */
    public void put(Key key, Value val){
        int i = rank(key,0,N-1);
        if(i < N && keys[i].compareTo(key) == 0) { vals[i] = val; return;}
        for(int j = N;j>i;j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; vals[i]= val;
        N++;
    }

    public void put(Key key, Value val,Test t){
        int i = rank(key,t);
        t.tempCount++;
        if(i < N && keys[i].compareTo(key) == 0) { vals[i] = val; return;}
        for(int j = N;j>i;j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; vals[i]= val;
        N++;
    }

    public int rank(Key key, int lo, int hi)
    {
        if (hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0)
            return rank(key, lo, mid-1);
        else if (cmp > 0)
            return rank(key, mid+1, hi);
        else return mid;
    }

    public int rank(Key key, int lo, int hi,Test t)
    {
        if (hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        t.tempCount++;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0)
            return rank(key, lo, mid-1);
        else if (cmp > 0)
            return rank(key, mid+1, hi);
        else return mid;
    }

    public int rank(Key key){
        return rank(key,0,N-1);
    }

    public int rank(Key key,Test t){
        return rank(key,0,N-1,t);
    }

    public void delete(Key key){
        int i = rank(key,0,N-1);
        if(i < N && key.compareTo(keys[i]) == 0){
            for(int j = i;j<N;j++){
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
            }
        }
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }

    public Key floor(Key key){
        int i = rank(key,0,N-1);
        if(keys[i].compareTo(key) == 0) return key;
        else if(i>0) return keys[i-1];
        else return null;
    }

    public Key ceiling(Key key){
        int i = rank(key,0,N-1);
        return keys[i];
    }

    public boolean contains(Key key){
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) == 0) return true;
        return false;
    }

    public boolean contains(Key key,Test t){
        int i = rank(key,t);
        t.tempCount++;
        if(i<N && keys[i].compareTo(key) == 0) return true;
        return false;
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> q = new Queue<>();
        for(int i=rank(lo);i<rank(hi);i++)
            q.enqueue(keys[i]);
        if(contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

    public Iterable<Key> keys(){
        return keys(keys[0],keys[N-1]);
    }

    public static void main(String[] args){
        BinarySearchST<String,Integer> bs = new BinarySearchST<>(67);
        In in4 = new In("/Users/leishaw/IdeaProjects/JavaWeb/AlgorithmChapter1/out/production/AlgorithmChapter1/main/sort.txt");
        Test t = new Test();
        while(!in4.isEmpty()){
            String str  = in4.readString();
            if(!bs.contains(str)){
                bs.put(str,1,t);
            }else{
                bs.put(str,bs.get(str)+1,t);
            }
        }


        StdOut.println("The number of compares: "+t.tempCount);
    }
}
