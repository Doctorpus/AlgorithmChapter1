package main.Chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by leishaw on 18/02/2017.
 */
public class QuickThreeWayPartitioning {

    public static void sort(Comparable[] a){

        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);

    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        partition(a, lo, hi);   //Partition

    }

    public static void partition(Comparable[] a,int lo, int hi){
        int lt = lo,gt = hi,i = lo + 1;
        if(lo>=hi) return;
        Comparable v = a[lo];
        while (i <= gt) {
            int comp = v.compareTo(a[i]);
            if(comp > 0) exch(a, lt++, i++);
            else if (comp < 0) exch(a, gt-- ,i);
            else i++;
        }
        //exch(a,lo,gt)
        //After the operation a[lo..lt-1]<a[j],a[lt..gt]=a[j],a[gt+1..hi]>a[j]
        partition(a,lo,lt -1);
        partition(a, gt + 1, hi);
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
