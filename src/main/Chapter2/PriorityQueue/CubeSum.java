package main.Chapter2.PriorityQueue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.security.Key;

import static java.io.FileDescriptor.out;

/**
 * find all a^3 + b^3 = c^3 + d^3 where a,b,c,d<10^6 and a,b,c,d are distinct
 * Created by leishaw on 29/05/2017.
 */
public class CubeSum {


    public static void main(String[] args){
        double maxSize = 10000;
        MinPQ<Double> mPQ = new MinPQ(new Integer((int)maxSize));
        Double key = new Double(1);
        int a = 0;
        int b = 0;
        int continued = 0;
        int count = 0;
        for(int i = 0;i < maxSize;i++){
            for(int j = 0;j <= i;j++){
                mPQ.insert(i,j,new Double(Math.pow(i,3)+Math.pow(j,3)));
            }
        }

        while(!mPQ.isEmpty()){
            MinAndMultipliersBean bean = mPQ.delMin();
            if(bean.getKey().compareTo(key) == 0) {
                count++;
                continued++;
            }
            if(bean.getKey().compareTo(key) !=0) continued = 0;
            if(continued == 1){
                StdOut.println(a+" "+b+" "+key);
                StdOut.println(bean.getMultipliers()[0]+" "+bean.getMultipliers()[1]+" "+bean.getKey());
            }else if(continued == 2){
                StdOut.println(bean.getMultipliers()[0]+" "+bean.getMultipliers()[1]+" "+bean.getKey());

            }
            StdOut.println(count);
            key = (Double) bean.getKey();
            a = bean.getMultipliers()[0];
            b= bean.getMultipliers()[1];

        }


    }

}
