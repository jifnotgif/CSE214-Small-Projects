package cse214.hw.indextable;
import java.util.HashMap;

public class Sums {
    private int[] array;
    private HashMap<Integer,Integer> table;
    private int sum;

    public Sums(int[] a, HashMap<Integer, Integer> t, int givenSum){
        array = a;
        table = t;
        sum = givenSum;
    }
    public int[] twoSum(){
        int[] indexArray = new int[2];
        int firstIndex = -1;
        int secondIndex = -1;
        for(int i =0 ; i < array.length; i++) {
            int secondTerm = sum - array[i];
            firstIndex = i;
            if(table.containsKey(secondTerm) && (int)table.get(secondTerm) != firstIndex){
                secondIndex = (int) table.get(secondTerm);
                break;
            }
            else{
                firstIndex = -1;
            }
        }
        indexArray[0] = firstIndex;
        indexArray[1] = secondIndex;
        return indexArray;

    }
}
