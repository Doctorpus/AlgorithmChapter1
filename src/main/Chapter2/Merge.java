package main.Chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 09/02/2017.
 */
public class Merge {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){

        //Sort a[] into ascending order.
        aux = new Comparable[a.length];         //Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a ,int lo,int hi){
        // Sort a[lo..hi].
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);         //Sort left half.
        sort(a, mid + 1, hi);       //Sort right half.
        merge(a, lo, mid, hi);     //Merge results.

    }

    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo,j = mid + 1;



        for(int k = lo;k<=hi;k++)
            aux[k] = a[k];

        for(int k = lo;k<=hi;k++)
            if(i > mid)                     a[k] = aux[j++];
            else if(j > hi)                 a[k] = aux[i++];
            else if(less(aux[i],aux[j]))    a[k] = aux[i++];
            else                            a[k] = aux[j++];

        TraceSort.draw((String[])a,i,i,j);

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
        sort(a);
        assert isSort(a);
        show(a);
    }
}
