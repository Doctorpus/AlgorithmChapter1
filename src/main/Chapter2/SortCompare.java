package main.Chapter2;

import edu.princeton.cs.algs4.*;

/**
 * Created by leishaw on 24/01/2017.
 */
public class SortCompare {

    public static double timeRandomInput(String alg,int N,int T){
        //Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0;t<T;t++){
            //Perform one experiment(generate and sort an array)
            for(int i = 0;i<N;i++){
                a[i] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static double time(String alg,Double[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell"))     Shell.sort(a);

        return timer.elapsedTime();
    }
    public static void main(String[] args){

        String[] argArr = In.readStrings("/Users/leishaw/IdeaProjects/JavaWeb/AlgorithmChapter1/out/production/AlgorithmChapter1/main/sort.txt");
        String alg1 = argArr[0];
        String alg2 = argArr[1];
        int N = Integer.parseInt(argArr[2]);
        int T = Integer.parseInt(argArr[3]);
        StdOut.println("alg1:"+alg1+" alg2:"+alg2+" N:"+N+" T:"+T);
        double t1 = timeRandomInput(alg1,N,T);
        StdOut.println("sort 1");
        double t2 = timeRandomInput(alg2,N,T);
        StdOut.println("sort 2");
        StdOut.printf("For %d random Doubles\n   %s is",N,alg1);
        StdOut.printf(" %.1f times faster than %s\n",t2/t1,alg2);
    }
}
