package main.Chapter2.PriorityQueue;

/**
 * Created by leishaw on 29/05/2017.
 */
public class MinAndMultipliersBean<Key extends Comparable<Key>>{
    /** Multiplication */
    private Key key;

    /** Multipliers */
    private int[] multipliers;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public int[] getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(int[] multipliers) {
        this.multipliers = multipliers;
    }
}
