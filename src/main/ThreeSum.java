package main;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.Contract;

/**
 * Created by leishaw on 13/01/2017.
 */
public class ThreeSum {
    public static int count(int[] a)
    {  // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt; }
    public static void main(String[] args)
    {
        int[] a = In.readInts("/Users/leishaw/Downloads/algs4-data/8Kints.txt");
        StdOut.println(count(a));
    }
}