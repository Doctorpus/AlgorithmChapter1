package main.Chapter3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import main.Test;
import main.VisualAccumulator;

/**
 * Created by leishaw on 05/06/2017.
 */
public class SequentialSearchST<Key extends Comparable<Key>,Value> {

    private Node first;
    private int N;

    /**
     * Search for key, update value if founded,grow new table if new
     * @param key
     * @param val
     */
    public int put(Key key,Value val){
        int count = 0;
        for(Node a = first; a != null; a = a.next){
            count++;
            if(a.key.equals(key)) {
                a.val = val;
                return count;
            }
        }
        first = new Node(key,val,first);
        N++;
        return count;
    }

    /**
     * Search for key, return associated value(return null if table is empty)
     * @param key
     * @return
     */
    public Value get(Key key){
        if(first == null) return null;
        Node a = first;
        while(a.next != null) {
            if (a.key.equals(key))
                return a.val;
            a = a.next;
        }
        return null;
    }

    public int size(){
        return N;
    }

    public boolean contains(Key key, Test t){
        if(first == null) return false;
        Node node = first;
        while(node.next != null) {
            t.tempCount++;
            if (node.key.equals(key)) return true;
            node = node.next;
        }
        return false;
    }

    /**
     *  delete node if the value of node equals the given key
     * @param key
     */
    public void delete(Key key){
        if(first == null) return;
        Node node = first;
        Node preNode = node;
        while(node != null){
            if(node.key.equals(key))
                preNode.next = node.next;
            preNode = node;
            node = node.next;
        }
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> q = new Queue();
        Node node = first;
        boolean inZoom = false;
        while(node.next!=null){
            if(node.equals(lo)){
                inZoom = true;
            }
            if(inZoom){
                q.enqueue(node.key);
                if(node.key.equals(hi))
                    inZoom = false;
            }
        }
        return q;
    }

    public static void main(String[] args){
/**        int T = 0;//number of words in leipzig1M.txt
        int C = 0;//max number of compares used in each put operation
        SequentialSearchST<String,String> st = new SequentialSearchST<>();
        In in = new In(args[0]);
        //count total number of words in the file
        while(!in.isEmpty()){
            in.readString();
            T++;
        }

        StdOut.print(T);
        //calculate the max compare operation in search
        In in2 = new In(args[0]);
        while(!in2.isEmpty()){
            String word = in2.readString();
            int curCom = st.put(word,word);
            C = Math.max(C,curCom);
        }

        //plot frequency of SequentialSearchST
        VisualAccumulator a = new VisualAccumulator(T, C);
        In in3 = new In(args[0]);
        while(!in3.isEmpty()){
            String word = in3.readString();
            int curCom = st.put(word,word);
            a.addDataValue(curCom);
        }
*/
        SequentialSearchST<String,Integer> st1 = new SequentialSearchST<>();
        In in4 = new In("/Users/leishaw/IdeaProjects/JavaWeb/AlgorithmChapter1/out/production/AlgorithmChapter1/main/sort.txt");
        Test t = new Test();
        while(!in4.isEmpty()){
            String str = in4.readString();
            if(!st1.contains(str,t)){
                t.tempCount += st1.put(str,1);
            }else{
                t.tempCount += st1.put(str,st1.get(str)+1);
            }
            StdOut.println(str+in4.isEmpty());
        }
        StdOut.println("The number of compares: "+t.tempCount);
    }

    private class Node{//linked-list node
        Key key;
        Value val;
        Node next;
        public Node(Key key,Value val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
