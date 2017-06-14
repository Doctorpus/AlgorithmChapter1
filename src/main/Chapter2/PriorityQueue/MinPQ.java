package main.Chapter2.PriorityQueue;

/**
 * Created by leishaw on 29/05/2017.
 */
public class MinPQ<Key extends Comparable<Key>>{

    //the array for heap tree priority queue
    private Key pq[];

    //the size of the priority queue
    private int N;

    //array whose entries are arrays each of which has two elements restoring a,b
    private int[] multipliers[];

    //create a priority queue of initial capacity max
    MinPQ(Integer max){
        pq = (Key[]) new Comparable[Integer.MAX_VALUE/100];
        multipliers = new int[Integer.MAX_VALUE/100][2];
        N = 0;
    }

    //create a priority queue from the keys in a[]
    MinPQ(Key[] keys){
        int len = keys.length;
        pq = (Key[]) new Comparable[len*2];
        int i = 0;
        for(Key key : keys)
            pq[i+1] = key;
        for(int j = len/2; j > 1; j--)
            sink(j,len);
    }

    /**
     *
     * @param item  add a key to the priority queue
     */
    public void insert(Key item){
        pq[++N] = item;
        swim(N);
    }

    public void insert(int a, int b, Key item){
        pq[++N] = item;
        swim(N);
        multipliers[N] = new int[2];
        multipliers[N][0] = a;
        multipliers[N][1] = b;
    }

    public MinAndMultipliersBean delMin(){
//        if(N == 1) return pq[N--];
//        else if(N <= 0) return null;
        Key min = pq[1];    //Retrieve minimum key from top
        int[] multiplier = this.multipliers[1];
        MinAndMultipliersBean bean = new MinAndMultipliersBean();
        bean.setKey(min);
        bean.setMultipliers(multiplier);
        pq[1] = pq[N--];    //Exchange with last item
        pq[N + 1] = null;   //Avoid loitering
        multipliers[1] = multipliers[N];
        multipliers[N + 1] = null;
        sink(1);            //Restore heap priority
        return bean;
    }

    public int[][] delMultipliers(){
        multipliers[1] = multipliers[N];
        multipliers[N + 1] = null;
        return multipliers;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return pq.length;
    }

    /**
     * Helper functions
     */
    private boolean less(int a, int b){return pq[a].compareTo(pq[b]) < 0;}

    private void exch(int a, int b){
        Key item = pq[a];
        pq[a] = pq[b];
        pq[b] = item;
        int[] swap = multipliers[a];
        multipliers[a] = multipliers[b];
        multipliers[b] = swap;
    }

    private void swim(int i){
        int j;
        while(i > 1){
            j = i/2;
            if(less(i,j)) exch(j,i);
            i = i/2;
        }
    }
    private void sink(int i){
        int j;
        while(2*i <= N) {
            j = 2 * i;
            if (j < N && less(j + 1 , j)) j++;
            if(less(i,j)) break;
            exch(i,j);
            i = j;
        }
    }

    private void sink(int i, int n){
        int j;
        while(2*i <= n){
            j = 2*i;
            if(j < n && less(j + 1, j)) j++;
            if(less(i, j)) break;
            exch(i,j);
            i = j;
        }

//        while(2*i < n){
//            j = 2*i;
//            if(less(j, j + 1)) j++;
//            if(!less(i, j)) break;
//            exch(i,j);
//            i = j;
//        }
//        if(2*i == n)
//            if(less(i,n)) exch(i,n);
    }

    public void resize() {
        Key[] substitute;
        if (pq.length >= N) {
            substitute = (Key[]) new Comparable[pq.length*2];
            resizeHelper(substitute);
        }else if(pq.length/4 <= N){
            substitute = (Key[]) new Comparable[pq.length/4];
            resizeHelper(substitute);
        }
    }

    public void resizeHelper(Key[] substitute){
        for(int i = 1;i < pq.length;i++){
            substitute[i] = pq[i];
        }
        pq = substitute;
    }

    /**
     * Test mode
     * @param args
     */
    public static void main(String[] args){
        /**
        In stream = new In("/Users/leishaw/IdeaProjects/JavaWeb/AlgorithmChapter1/out/production/AlgorithmChapter1/main/sort.txt");
        MinPQ<String> mPQ = new MinPQ(13);
        String a;
        while(!stream.isEmpty()){
            a = stream.readString();
            mPQ.insert(a);
        }

        while(!mPQ.isEmpty()){
            StdOut.print(mPQ.delMax() + " ");
        }
        */
    }
}
