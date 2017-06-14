package main.Exercise1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 08/01/2017.
 *
 *
 */
public class E10InfixToPostfix {

    public static void main(String[] args){

        Stack<String> stack = new Stack<>();

        while(!StdIn.isEmpty()){

            String s = StdIn.readString();
            if(s.equals("(")) ;
            else if(s.equals("*")) stack.push("*");
            else if(s.equals("+")) stack.push("+");
            else if(s.equals(")")) StdOut.print(stack.pop() + " ");
            else
                StdOut.print(s + " ");


        }

    }
}
