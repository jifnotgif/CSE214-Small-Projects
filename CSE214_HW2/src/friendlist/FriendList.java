package hw.cse214.friendlist;
import java.io.*;
import java.util.Scanner;
public class FriendList {
    public static void main(String[] args) {
        File file = new File("in1.txt");

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int cases = input.nextInt();
                input.nextLine();

                while (cases > 0) {

                    int n = input.nextInt();
                    int k = input.nextInt();
                    input.nextLine();
                    String[] friendNames = input.nextLine().split("\\s");
                    String[] numMutual = input.nextLine().split("\\s");
                    int[] numFriends = new int[numMutual.length];


                    for (int i = 0; i < numMutual.length; i++) {
                        numFriends[i] = Integer.parseInt(numMutual[i]);
                    }
                    LinkedListofFriends output = new LinkedListofFriends();
                    initializeBuckets(n, k, numFriends, friendNames, output);
                    output.sortOutputList();
                    output.printOutput();
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
    
    public static int findMaxSize(int[] arr){
        int max = arr[0];       
        for(int i = 0; i< arr.length; i++){
            if(arr[i] > max ) max = arr[i];
        }
        return max;
    }
    public static int findMinSize(int[] arr){
        int min = arr[0];
        for(int i = 0; i< arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static void initializeBuckets(int totalFriends, int buckets, int[] mutuals, String[] friendNames, LinkedListofFriends list){
        int maxSize = findMaxSize(mutuals);
        int minSize = findMinSize(mutuals);
       
        if(Math.round(maxSize - minSize +1)% buckets ==0){
            int range = (maxSize - minSize +1)/buckets;
            for(int i =0; i< buckets; i++){

                Bucket test = new Bucket(minSize,minSize+range - 1);
                for (int j =0; j< totalFriends ; j++){
                    if(mutuals[j] >= minSize && mutuals[j] <= minSize +range -1){

                        Friend friend = new Friend(mutuals[j], friendNames[j], j);
                        test.queueFriend(friend);
                    }
                }
                test.sortFriends();
                if(!test.isEmpty()) {
                    test.deleteFriends(buckets);
                    list.enqueue(test.getFriend());
                }
                minSize += range;
            }

        }

        else{
            int range = Math.round((maxSize - minSize +1)/buckets);
            for(int i =0; i< buckets-1; i++){

                Bucket test = new Bucket(minSize,minSize+range - 1);
                for (int j =0; j< totalFriends ; j++){
                    if(mutuals[j] >= minSize && mutuals[j] <= minSize +range -1){
                        Friend friend = new Friend(mutuals[j], friendNames[j],j);
                        test.queueFriend(friend);
                    }
                }

                test.sortFriends();
                if(!test.isEmpty()) {
                    test.deleteFriends(buckets);
                    list.enqueue(test.getFriend());
                }
                minSize += range;
            }


            Bucket last = new Bucket(minSize,maxSize);
            for (int j =0; j< totalFriends ; j++){
                if(mutuals[j] >= minSize && mutuals[j] <= minSize +range -1){

                    Friend friend = new Friend(mutuals[j], friendNames[j],j);
                    last.queueFriend(friend);
                }
            }
            last.sortFriends();
            if(!last.isEmpty()) {
                last.deleteFriends(buckets);
                list.enqueue(last.getFriend());
            }
        }

    }
}
