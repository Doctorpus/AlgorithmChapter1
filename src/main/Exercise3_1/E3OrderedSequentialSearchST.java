package main.Exercise3_1;

/**
 * Created by leishaw on 08/06/2017.
 */
public class E3OrderedSequentialSearchST<Key extends Comparable<Key>,Value> {

    private Node first;
    private int N; //number of the nodes

    public void put(Key key,Value val){
        Node node = first;
        if(!isEmpty()) {
            int a;
            while (node.next != null) {
                a = node.key.compareTo(key);
                if (a < 0) {
                    Node newNode = new Node(key, val, node.next);
                    node.next = newNode;
                    N++;
                    return;
                } else if(a == 0){
                    node.val = val;
                    return;
                }
            }
        }
        first = new Node(key,val,null);
        N++;
    }

    public Value get(Key key){
        Value val;
        int i = 0;
        Node node = first;
        while(node.next!=null) {
            if (node.key.equals(key))
                return node.val;
            node = node.next;
        }
        return null;
    }

    public boolean contains(){
        return false;
    }

    public boolean isEmpty(){
        return false;
    }


    private class Node{
        Node next;
        Key key;
        Value val;
        public Node(Key key,Value val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
