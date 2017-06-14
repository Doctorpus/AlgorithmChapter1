package main.Chapter3.interfaces;

/**
 * API for a generic basic symbol table
 * Created by leishaw on 01/06/2017.
 */
public interface SymbolTableAPI<Key, Value> {

    void put(Key key, Value value);             //put key-value pair into the table(remove key from table if value is null)

    Value get(Key key);                         //value paired with key(null if key is absent)

    void delete(Key key);                       //delete key(and its value) from the table

    boolean contains(Key key);                  //is there a value paired with key?]]

    Key min();                                  //smallest key

    Key max();                                  //largest key

    Key floor(Key key);                         //largest key less than or equal to key

    Key ceiling(Key key);                       //smallest key greater than or equal to key

    int rank(Key key);                          //number of keys less than key

    Key select(int k);                          //key of rank k

    void deleteMin();                           //delete smallest key

    void deleteMax();                           //delete largest key

    boolean isEmpty();                          //is there any pairs in the table?

    int size();                                 //number of key-value pairs int the table

    Iterable<Key> keys();                       //all keys in the table, in sorted order

    Iterable<Key> keys(int lo, int hi);         //keys in [lo ... hi], in sorted order
}
