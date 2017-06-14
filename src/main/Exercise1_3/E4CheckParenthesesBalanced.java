package main.Exercise1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import src.Stack;

/**
 * Created by leishaw on 07/01/2017.
 * This program is designed to determine whether a text of parentheses are properly balanced.
 */
public class E4CheckParenthesesBalanced {

    public static void main(String[] args){

        Stack<String> pareStack = new Stack<>();//Stack to restore parentheses

        boolean isBalanced = false;

        while(!StdIn.isEmpty()){

            String item = StdIn.readString();

            if(E4CheckParenthesesBalanced.isLeftParentheses(item)){
                pareStack.push(item);
            }else if(E4CheckParenthesesBalanced.isRightParentheses(item)){
                StdOut.println("Stack N"+pareStack.getN());
                boolean a = isThisPareBalanced(item,pareStack);
                StdOut.println("Stack N"+pareStack.getN());
                StdOut.println(a);
                if(!a){
                    isBalanced = false;
                    StdOut.println("This parentheses is not balanced."+item+pareStack.size());
                    break;
                }else isBalanced = true;
            }else if(item.equals("@"))break;
            else if(!isLeftParentheses(item)&&!isRightParentheses(item)) {
                StdOut.println(isLeftParentheses(item)+"This text representation is not a legal one." + item);
                break;
            }
        }
        if(isBalanced)
        StdOut.println("This is properly balanced.");
    }

    public static boolean isLeftParentheses(String item){
        return item.equals("(")||item.equals("[")||item.equals("{");
    }

    public static boolean isRightParentheses(String item){
        return item.equals(")")||item.equals("]")||item.equals("}");
    }

    public static boolean isThisPareBalanced(String item,Stack pareStack){

        if(item.equals(")"))return "(".equals(pareStack.pop());
        else if(item.equals("]"))return "[".equals(pareStack.pop());
        else if(item.equals("}"))return "{".equals(pareStack.pop());
        return false;

    }
}
