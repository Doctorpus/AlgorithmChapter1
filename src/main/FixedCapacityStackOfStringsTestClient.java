package main;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import src.FixedCapacityStackOfStrings;

import java.util.Scanner;

/**
 * Created by leishaw on 07/01/2017.
 */
public class FixedCapacityStackOfStringsTestClient {

    public static void main(String[] args){


        FixedCapacityStackOfStrings f = new FixedCapacityStackOfStrings(100);
        while(!StdIn.isEmpty()){

            String item = StdIn.readString();
            if(item.equals("@")){break;}
            if(!item.equals("-")){
                f.push(item);
            }else if(!f.isEmpty()) StdOut.print(f.pop()+" ");

        }
        StdOut.println("("+f.size() + " left on stack)");
    }
}
