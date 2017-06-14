package main.Chapter2.PriorityQueue;


import com.sun.tools.javac.util.Context;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import src.Stack;

/**
 * Created by leishaw on 19/02/2017.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    //the array for heap tree priority queue
    private Key pq[];

    //the size of the priority queue
    private int N;

    //create a priority queue of initial capacity max
    MaxPQ(int max){
        pq = (Key[]) new Comparable[max + 3];
        N = 0;
    }

    //create a priority queue from the keys in a[]
    MaxPQ(Key[] keys){
        int len = keys.length;
        pq = (Key[]) new Comparable[len*2];
        int i = 0;
        for(Key key : keys)
            pq[i+1] = key;
        for(int j = len/2; j > 1; j--)
            sink(j,len);
    }

    public void insert(Key item){
        pq[++N] = item;
        if(N >= pq.length) resize();
        swim(N);
    }

    public Key delMax(){
//        if(N == 1) return pq[N--];
//        else if(N <= 0) return null;
        Key max = pq[1];    //Retrieve max key from top
        pq[1] = pq[N--];    //Exchange with last item
//        resize();
        pq[N + 1] = null;   //Avoid loitering
        sink(1);            //Restore heap priority
        return max;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    /**
     * Helper functions
     */
    private boolean less(int a, int b){return pq[a].compareTo(pq[b]) < 0;}
    private void exch(int a, int b){
        Key item = pq[a];
        pq[a] = pq[b];
        pq[b] = item;
    }
    private void swim(int i){
        int j;
        while(i > 1){
            j = i/2;
            if(less(j,i)) exch(j,i);
            i = i/2;
        }
    }
    private void sink(int i){
        int j;
        while(2*i <= N) {
            j = 2 * i;
            if (j < N && less(j, j + 1)) j++;
            if(!less(i,j)) break;
            exch(i,j);
            i = j;
        }
    }

    private void sink(int i, int n){
        int j;
        while(2*i <= n){
            j = 2*i;
            if(j < n && less(j, j + 1)) j++;
            if(!less(i, j)) break;
            exch(i,j);
            i = j;
        }


//        while(2*i < n){
//            j = 2*i;
//            if(less(j, j + 1)) j++;
//            if(!less(i, j)) break;
//            exch(i,j);
//            i = j;
//        }
//        if(2*i == n)
//            if(less(i,n)) exch(i,n);
    }

    public void resize() {
        Key[] substitute;
        boolean needResize = false;
        if (pq.length >= N) {
            substitute = (Key[]) new Comparable[pq.length * 2];
            resizeHelper(substitute);
        }else if(pq.length/4 <= N){

        }
    }

    public void resizeHelper(Key[] substitute){
            for(int i = 1;i <= pq.length;i++){
                substitute[i] = pq[i];
            }
            pq = substitute;
    }

    /**
     * Test mode
     * @param args
     */
    public static void main(String[] args){
        In stream = new In("/Users/leishaw/IdeaProjects/JavaWeb/AlgorithmChapter1/out/production/AlgorithmChapter1/main/sort.txt");
        MaxPQ<String> mPQ = new MaxPQ(13);
        String a;
        while(!stream.isEmpty()){
            StdOut.println("N:"+mPQ.size());
            a = stream.readString();
            mPQ.insert(a);
        }
            StdOut.println("N:"+mPQ.size());

        while(!mPQ.isEmpty()){
            StdOut.print(mPQ.delMax() + " ");
            StdOut.println("N:"+mPQ.size());
        }


    }
}
