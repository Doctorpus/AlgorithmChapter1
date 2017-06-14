package main.Chapter2.PriorityQueue;


import edu.princeton.cs.algs4.StdOut;

/******************************************************************************
 *  Compilation:  javac CubeSum.java
 *  Execution:    java CubeSum n
 *  Dependencies: MinPQ.java
 *
 *  Print out integers of the form a^3 + b^3 in sorted order, where
 *  0 <= a <= b <= n.
 *
 *  % java CubeSum 10
 *  0 = 0^3 + 0^3
 *  1 = 0^3 + 1^3
 *  2 = 1^3 + 1^3
 *  8 = 0^3 + 2^3
 *  9 = 1^3 + 2^3
 *  ...
 *  1729 = 9^3 + 10^3
 *  1729 = 1^3 + 12^3
 *  ...
 *  3456 = 12^3 + 12^3
 *
 *  Remarks
 *  -------
 *   - Easily extends to handle sums of the form f(a) + g(b)
 *   - Prints out a sum more than once if it can be obtained
 *     in more than one way, e.g., 1729 = 9^3 + 10^3 = 1^3 + 12^3
 *
 ******************************************************************************/

public class CubeSum1 implements Comparable<CubeSum1> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum1(int i, int j) {
        this.sum = i*i*i + j*j*j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum1 that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }

    public int sum(){
        return sum;
    }
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }


    public static void main(String[] args) {

        int maxSize = 1000;
        int a = 1;
        int b = 1;
        int sum = -1;
        int continued = 0;

        // initialize priority queue
        MyMinPQ<CubeSum1> pq = new MyMinPQ(maxSize);
        for (int i = 0; i <= maxSize; i++) {
            CubeSum1 cs = new CubeSum1(i,i);
            pq.insert(cs);
        }

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum1 s = pq.delMin();
            if(s.sum == sum) continued++;
            else if(s.sum != sum) continued = 0;
            if (s.j < maxSize)
                pq.insert(new CubeSum1(s.i, s.j + 1));
            if(continued == 1){
                StdOut.println(sum + " = " + a + "^3 +" + b + "^3");
                StdOut.println(s);
            }
            if(continued > 1){
                StdOut.println(s);
            }
            sum = s.sum();
            a = s.i;
            b = s.j;
        }
        StdOut.println(Integer.MAX_VALUE);
    }

}
