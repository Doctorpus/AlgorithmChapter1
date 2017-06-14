package main.Exercise3_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

/**
 * Created by leishaw on 07/06/2017.
 */
public class E2ArrayST<Key  extends Comparable<Key>,Value> {

    private Key[]   keys;
    private Value[] vals;
    private int N;          //number of key-value pairs

    public E2ArrayST(int capacity){
        keys = (Key[])new Comparable[capacity];
        vals = (Value[])new Object[capacity];
    }

    public Value get(Key key){
        Value val = null;
        int i = 0;
        while(i<N){
            if(keys[i].equals(key))
                val = vals[i];
        }
        return val;
    }
    public void put(Key key,Value val){
        if(key == null) throw new RuntimeException("key can not be null.");
        int i = 0;
        for(;i<N;i++){
            if(key.equals(keys[i])) {
                if(val != null){
                    vals[i] = val;
                }else{
                    while(i < N-1){
                        keys[i] = keys[i+1];
                        vals[i] = vals[i++];
                    }
                    N--;
                }
                return;
            }
        }
        keys[N] = key;
        vals[N++] = val;
    }

    public int size(){
        return N;
    }

    public String toString(){
        String s = "";
        for(int i=0;i<N;i++)
            s += keys[i]+" "+vals[i]+"\n";
        return s;
    }

    public boolean contains(Key key){
        if(key != null)
        for(int i = 0;i<N;i++){
            if(key.equals(keys[i]))
                return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public static void main(String[] args){
        E2ArrayST<String,String> arrayST = new E2ArrayST(20);
        StdOut.println("size: "+arrayST.size());
        arrayST.put("bear","Strong");
        arrayST.put("dolphin","cute");
        arrayST.put("dog","funny");
        arrayST.put("monkey","cunning");
        StdOut.println(arrayST);
    }
}
