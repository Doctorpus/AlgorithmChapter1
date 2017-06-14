package main.Chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 24/01/2017.
 */
public class Insertion {

    public static void sort(Comparable[] a){

        int N = a.length;
        //Sort a[] into increasing order.
        for(int i = 1;i<N;i++)
            //exchange the current item with the left item which is larger than it.
            for(int j = i;j > 1 && less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
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
        String[] a = In.readStrings("../tobe.txt");
        sort(a);
        assert isSort(a);
        show(a);
    }
}
