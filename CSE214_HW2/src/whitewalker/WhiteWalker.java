package hw.cse214.whitewalker;
import java.io.*;
import java.util.Scanner;

public class WhiteWalker {

    private static int numQueue = 6;
    private static int numSelect = 5;
    private static int[] powerWalker;
    private static int[] indexQueue;

    public static FixedCapacityArrayQueue initializeNumQueue(int capacity){
        FixedCapacityArrayQueue queue = new FixedCapacityArrayQueue(capacity);
        for (int i = 0; i < capacity; i++) {
            queue.enqueue(powerWalker[i]);
        }
        return queue;

    }
    public static FixedCapacityArrayQueue initializeIndexQueue(int capacity){

        FixedCapacityArrayQueue queue = new FixedCapacityArrayQueue(capacity);

        for (int i =0 ; i< capacity; i++){
            queue.enqueue(i);

        }
        return queue;
    }

    public static void main(String[] args) {

        File file = new File("in4.txt");

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int cases = input.nextInt();
                input.nextLine();
                while (cases > 0) {
                    int highestPower = 0;
                    int count = 0;
                    int capacity = input.nextInt();
                    powerWalker = new int[capacity];
                    int iterateTimes = input.nextInt();
                    if(capacity < iterateTimes) iterateTimes = capacity;
                    int m = iterateTimes;
                    input.nextLine();
                    for(int i =0; i < capacity; i++){
                        powerWalker[i] = input.nextInt();
                    }
                    FixedCapacityArrayQueue initQueue = initializeNumQueue(capacity);
                    FixedCapacityArrayQueue indexQueue = initializeIndexQueue(capacity);


                    while (m > 0) {
                        FixedCapacityArrayQueue temp = new FixedCapacityArrayQueue(powerWalker.length);
                        FixedCapacityArrayQueue indexTemp = new FixedCapacityArrayQueue(powerWalker.length);

                        for (int tempCount = 0; tempCount < iterateTimes; tempCount++) {

                            int save = initQueue.dequeue();
                            if (save > highestPower) {
                                highestPower = save;
                            }
                            temp.enqueue(save);
                            indexTemp.enqueue(indexQueue.dequeue());

                        }

                        for (int i = 0; i < iterateTimes; i++) {

                            int element = temp.dequeue();
                            int index = indexTemp.dequeue();
                            if (element == highestPower && count == 0) {
                                System.out.print(index + " ");
                                count++;
                            } else {
                                if (element >= 1) element--;
                                initQueue.enqueue(element);
                                indexQueue.enqueue(index);
                            }

                        }

                        highestPower = 0;
                        count = 0;
                        if(iterateTimes < initQueue.size()){
                            iterateTimes--;
                        }
                        else{
                            iterateTimes = initQueue.size();
                        }
                        m--;
                    }
                    System.out.println();
                    cases--;
                }

            }
            input.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}



