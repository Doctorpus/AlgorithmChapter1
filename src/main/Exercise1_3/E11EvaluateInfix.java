package main.Exercise1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by leishaw on 08/01/2017.
 *
 * ( sqrt ( 9 ) 1 + ( ( 2 3 + ) ( 4 5 * ) * ) + ) )@
 */
public class E11EvaluateInfix {

    public static void main(String[] args){



        Stack<String> ops = new Stack<>();
        Stack<Double> valStack = new Stack<>();
        String postfixes = "";
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.equals("(")) ;
            else if(s.equals("*"))      ops.push("*");
            else if(s.equals("+"))      ops.push("+");
            else if(s.equals("-"))      ops.push("-");
            else if(s.equals("/"))      ops.push("/");
            else if(s.equals("sqrt"))   ops.push("sqrt");
            else if(s.equals("@")) break;
            else if (s.equals(")")) {
                double v = valStack.pop();
                String op = ops.pop();
                if (op.equals("*"))           valStack.push(valStack.pop() * v);
                else if (op.equals("+"))      valStack.push(valStack.pop() + v);
                else if (op.equals("-"))      valStack.push(valStack.pop() - v);
                else if (op.equals("/"))      valStack.push(valStack.pop() / v);
                else if (op.equals("sqrt"))   valStack.push(Math.sqrt(v));

//                StdOut.print("   peekval"+valStack.peek());

            }
            else valStack.push(Double.parseDouble(s));
        }

        StdOut.println(valStack.pop());

    }
}
