package cse214.hw.triplets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
public class Triplets {
    public static void main(String[] args) {
        File file = new File("in2.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int cases = input.nextInt();
                while (cases > 0) {
                    int numElem = input.nextInt();
                    int constant = input.nextInt();
                    int[] arr = new int[numElem];
                    input.nextLine();
                    String integers = input.nextLine();
                    String[] intArray = integers.split("\\s");
                    for (int i = 0; i < numElem; i++) {
                        arr[i] = Integer.parseInt(intArray[i]);
                    }
                    HashMap<Integer, Integer> table = new HashMap<Integer, Integer>(numElem);
                    for(int i=0; i<numElem; i++){
                        table.put(i, arr[i]);
                    }
                    Trios tripletObj = new Trios(table, arr, constant);
                    System.out.println(tripletObj.countTriplets());
                    cases--;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }



}
