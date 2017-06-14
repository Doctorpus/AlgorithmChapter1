package main.Chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 24/01/2017.
 */
public class Shell {

    public static void sort(Comparable[] a){
        //Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        while(h >= 1){
            for(int i =h;i<N;i++){
                for(int j = i;j>=h&&less(a[j],a[j-h]);j -= h){
                    exch(a,j,j-h);
                }
            }
            h = h/3;
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
        String[] a = In.readStrings("/Users/leishaw/IdeaProjects/JavaWeb/AlgorithmChapter1/out/production/AlgorithmChapter1/main/sort.txt");
        show(a);
        sort(a);
        assert isSort(a);
        show(a);
    }
}
