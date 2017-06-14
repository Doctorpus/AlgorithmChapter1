package main.Exercise3_1;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdOut;
import main.Chapter3.BinarySearchST;

import java.util.Scanner;

/**
 * Created by leishaw on 07/06/2017.
 */
public class E1ComputeGPA {

    public static void main(String[] args){
        BinarySearchST<String,Double> bs = new BinarySearchST(20);
        bs.put("A+",4.33);
        bs.put("A",4.00);
        bs.put("A-",3.67);
        bs.put("B+",3.33);
        bs.put("B",3.00);
        bs.put("B-",2.67);
        bs.put("C+",2.33);
        bs.put("C",2.00);
        bs.put("C-",1.67);
        bs.put("D",1.00);
        bs.put("F",0.00);
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        StdOut.println(key);
        String[] keys = key.split(" ");
        double sum = 0;        //sum of the GP
        int count = 0;      //number of the GP
        for(int i=0;i<keys.length;i++){
            count++;
            sum += bs.get(keys[i]);
        }
        StdOut.println("GPA of the input grads: "+sum/count);
    }
}
