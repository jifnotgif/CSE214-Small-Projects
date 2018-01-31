package hw.cse214.whitewalker;
import java.util.NoSuchElementException;


public class FixedCapacityArrayQueue {
        private int[] q;
        private int n;
        private int first;
        private int last;

        public FixedCapacityArrayQueue(int capacity){
                q = new int[capacity];
                n = 0;
                first =0;
                last =0;
        }

        public boolean isEmpty(){ return n ==0; }

        public int size(){ return n; }

        public void enqueue(int item){
                if(n == q.length)  { throw new IndexOutOfBoundsException();}
                q[last++] = item;
                if (last == q.length) last =0;
                n++;

        }

        public int dequeue(){
                if(isEmpty()){ throw new NoSuchElementException("Queue underflow"); }
                int item = q[first];
                q[first] = 0;
                n--;
                first++;
                if (first == q.length) first =0;
                return item;
        }

        public int peek(){
                if (isEmpty()){ throw new NoSuchElementException("Queue underflow");}
                return q[first];
        }

        public int getLast(){
                return last;
        }
        public void decElements(){
                for( int i =0; i< q.length; i++){
                        if (q[i] >0) q[i]--;
                }
        }
        public int getLargestIndex(){
                int num =0, index =0;
                for(int i =0 ; i < q.length ; i++){
                        if (q[i] > num) index = i;
                }
                return index;
        }

}
