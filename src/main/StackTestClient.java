package main;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import src.Stack;

/**
 * Created by leishaw on 07/01/2017.
 */
public class StackTestClient {

    public static void main(String[] args){

        Stack<String> s = new Stack<>();

        while(!StdIn.isEmpty()){

            String item = StdIn.readString();
            if(item.equals("@")){break;}
            if(!item.equals("-")){
                s.push(item);
            }else if(!s.isEmpty()) StdOut.print(s.pop()+" ");

        }
        StdOut.println("("+s.size() + " left on stack)");
    }
}
