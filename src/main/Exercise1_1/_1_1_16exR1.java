package main.Exercise1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 11/01/2017.
 */
public class _1_1_16exR1 {

    public static void main(String[] args){

        StdOut.println(exR1(6));
    }

    public static String exR1(int n){
        if(n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }
}
