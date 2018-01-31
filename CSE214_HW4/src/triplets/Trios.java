package cse214.hw.triplets;

import java.util.HashMap;

public class Trios {
    private HashMap<Integer, Integer> table;
    private int[] array;
    private int c;

    public Trios(HashMap<Integer, Integer> t, int[] a, int constant){
        table = t;
        array = a;
        c = constant;
    }

    public int countTriplets() {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            int[] remainder = new int[c];
            for (int k = i+1; k < array.length; k++) {
                int modComp = (c - ((int)table.get(i) + (int)table.get(k)) % c) % c;
                int num = (int)table.get(k)% c;
                counter += remainder[num];
                remainder[modComp]++;
            }
        }
        return counter;
    }

}
