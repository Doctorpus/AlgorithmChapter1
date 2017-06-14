package main.Chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 23/01/2017.
 */
public class Selection {

    public static void sort(Comparable[] a){

        //Sort a[] into increasing order.
        for(int i = 0;i<a.length;i++){
            int min = i;//The index of the minimum entry of the unsorted elements.
            for(int j = i + 1;j<a.length;j++){
                if(less(a[j],a[i])) min = j;
            }
            exch(a,i,min);
        }
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
        String[] a = In.readStrings();
        sort(a);
        assert isSort(a);
        show(a);
    }
}
