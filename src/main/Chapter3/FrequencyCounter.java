package main.Chapter3;

import edu.princeton.cs.algs4.*;

import java.security.Key;

/**
 * Created by leishaw on 08/06/2017.
 */
public class FrequencyCounter {

    public static void main(String[] args) {


    }


    public static int[] countRandomInteger(){
        int[] N = {10,100,1000,10000,100000,1000000};
        int[] Ds=new int[6];
        int randomNumber = 0;
        for(int i=0;i<N.length;i++) {
            int D = 0;
            BinarySearchST<Integer,Integer> st = new BinarySearchST(1000010);
            for (int j = 0; j < N[i];j++){
                randomNumber = (int)(Math.random()*1000);
                if(!st.contains(randomNumber)) {
                    st.put(randomNumber,1);
                    D++;
                }else{
                    st.put(randomNumber,st.get(randomNumber)+1);
                }
            }
            Ds[i] = D;
        }
        return Ds;
    }
}
