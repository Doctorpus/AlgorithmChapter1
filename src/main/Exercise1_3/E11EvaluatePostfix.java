package main.Exercise1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by leishaw on 08/01/2017.
 *
 *
 */
public class E11EvaluatePostfix {

    public static void main(String[] args){

        Stack<Integer> stack = new Stack<>();

        while(!StdIn.isEmpty()){

            String item = StdIn.readString();

            if(item.equals("+"))         stack.push(stack.pop()+stack.pop());
            else if(item.equals("*"))    stack.push(stack.pop()*stack.pop());
            else                         stack.push(Integer.parseInt(item));

        }

        StdOut.print(stack.pop());

    }

}
