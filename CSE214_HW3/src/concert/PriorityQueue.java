package hw.cse214.concert;
public class PriorityQueue {
    private int[] pqueue;
    private int numItems;
    private int root;
    private int c;
    public PriorityQueue(int capacity){
        pqueue = new int[capacity+1];
        numItems =0;
        c = capacity;

    }

    public int size(){
        return numItems;
    }

    public void heapify(){
        int pos =0, childPos;
        while(pos*2 + 1 < numItems){
            childPos = pos*2 +1;
            if(childPos < numItems -1 && pqueue[childPos+1]> pqueue[childPos]){
                childPos++;
            }
            if(pqueue[pos] >= pqueue[childPos]) return;
            swap(pqueue, pos, childPos);
            pos = childPos;
        }
    }
    public boolean isFull(){
        if(size() == c) return true;
        else return false;
    }
    public int removeMax(){
        if(size() == 0){
            return -1;
        }
        int max = pqueue[0];
        pqueue[0] = pqueue[numItems-1];
        numItems--;
        heapify();
        return max;
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public void insert(int value){
        if (isFull()) throw new IndexOutOfBoundsException();
        pqueue[numItems] = value;
        resort(numItems);
        numItems++;
    }

    public void resort(int i){
        while(i> 0){
            if(pqueue[(i-1)/2] < pqueue[i]) swap(pqueue, (i-1)/2, i);
            i = (i-1)/2;
        }

    }

    public int getCost(){
        int cost = removeMax() ;
        if (cost == 0 ) return cost;
        insert(cost-1);
        return cost;

    }

}
