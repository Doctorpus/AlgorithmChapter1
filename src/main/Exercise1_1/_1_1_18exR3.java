package main.Exercise1_1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 12/01/2017.
 */
public class _1_1_18exR3 {

    public static void main(String[] args){
        StdOut.println("mystery(2,25) = " + mystery(2,6));
        StdOut.println("mystery(3,11) = " + mystery(3,13));
        StdOut.println("mysteryMice(2,25) = " + mysterymice(2,100));
        StdOut.println("mysteryMice(5,6) = " + mysterymice(5,6));

    }

    public static int mystery(int a, int b){

        if(b == 0) return 0;
        if(b % 2 == 0) return mystery(a + a,b/2);
        return mystery(a + a,b/2) + a;

    }

    public static int mysterymice(int a, int b){

        if(b == 0) return 0;
        if(b % 2 == 0) return mysterymice(a*a,b/2);
        StdOut.println("a = "+a+" b = "+b);

        return mysterymice(a*a,b/2) + a;

    }
}
