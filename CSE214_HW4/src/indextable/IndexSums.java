package cse214.hw.indextable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
public class IndexSums {
    public static void main(String[] args) {
        File file = new File("in1.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int cases = input.nextInt();
                while (cases > 0) {
                    int numElem = input.nextInt();
                    int target = input.nextInt();
                    int[] arr = new int[numElem];
                    input.nextLine();
                    String integers = input.nextLine();
                    String[] intArray = integers.split("\\s");
                    for(int i =0; i<numElem; i++){
                        arr[i] = Integer.parseInt(intArray[i]);
                    }
                    HashMap<Integer, Integer> table = new HashMap<Integer, Integer>(numElem);
                    for (int i = 0; i < arr.length; i++) {
                        table.put(arr[i], i);
                    }
                    Sums t = new Sums(arr,table,target);
                    int[] newArr = t.twoSum();
                    System.out.print("[" + newArr[0] + ',' + newArr[1] + "]");
                    cases--;
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }




}
