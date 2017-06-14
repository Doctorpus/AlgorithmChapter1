package src;

/**
 * Created by leishaw on 07/01/2017.
 */
public class Stack<Item> {

    private Node first;//top of stack(most recently added node)
    private int n;//number of items

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){return first == null;}
    public int size(){return n;}

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        n++;
    }

    public Item pop(){
        //Remove item from the beginning of the list
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public int getN(){
        return n;
    }
}
