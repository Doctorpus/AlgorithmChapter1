package main.Chapter3;

import main.Chapter3.interfaces.SymbolTableAPI;


/**
 * Created by leishaw on 01/06/2017.
 */
public class SymbolTable<Key extends Comparable<Key>, value> implements SymbolTableAPI{

    @Override
    public void put(Object o, Object o2) {

    }

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object min() {
        return null;
    }

    @Override
    public Object max() {
        return null;
    }

    @Override
    public Object floor(Object o) {
        return null;
    }

    @Override
    public Object ceiling(Object o) {
        return null;
    }

    @Override
    public int rank(Object o) {
        return 0;
    }

    @Override
    public Object select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public Iterable keys(int lo, int hi) {
        return null;
    }

    @Override
    public Iterable keys() {
        return null;
    }


}
