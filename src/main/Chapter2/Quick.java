package main.Chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by leishaw on 15/02/2017.
 */
public class Quick {

    public static void sort(Comparable[] a){

        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);

    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(a, lo, hi);   //Partition
        sort(a, lo, j - 1);               //Sort left part a[lo ... j-1]
        sort(a, j + 1,hi);              //Sort right part a[j+1 ... hi]
    }

    public static int partition(Comparable[] a,int lo, int hi){
        //Partition into a[lo .. i -1], a[i], a[i+1 .. hi].
        int i = lo, j = hi + 1;         //left and right scan indices
        Comparable v = a[lo];           //Partitioning item
        while(true){
            // Scan right, Scan left, check for scan complete, and exchange.
            while(less(a[++i],v)) if(i == hi) break;
            while(less(v,a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);                 // Put v = a[j] into position
        return j;                       // with a[lo .. j -1] <= a[j+1 .. hi]
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        //Print the array on a single line.
        for(int i = 0;i<a.length;i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSort(Comparable[] a){
        for(int i = 0;i<a.length-1;i++){
            if(less(a[i+1],a[i])) return false;
        }
        return true;
    }

    public static void main(String[] args){
        //Read strings from standard input,sort them and print;
        String[] a = In.readStrings("/Users/leishaw/IdeaProjects/JavaWeb/AlgorithmChapter1/out/production/AlgorithmChapter1/main/sort.txt");
        Integer[] b = new Integer[a.length];
        for(int i = 0; i<a.length;i++){
            b[i] = Integer.parseInt(a[i]);
        }
        sort(b);
        assert isSort(a);
        show(b);

    }
}
