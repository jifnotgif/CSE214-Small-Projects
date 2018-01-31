package hw.cse214.teamselection;

import java.io.*;
import java.util.Scanner;

public class TeamSelection {
    public static void main(String[] args){
        File file = new File("in2.txt");

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int cases = input.nextInt();
                String jerseyNums;
                String heights;

                while (cases > 0) {

                    input.nextLine();
                    jerseyNums = input.nextLine();
                    heights = input.nextLine();
                    String[] jerseyParts = jerseyNums.split("\\s");
                    String[] heightParts = heights.split("\\s");
                    int len = jerseyParts.length;
                    int[] jNums = new int[len];
                    int[] hNums = new int[len];
                    LinkedListofInt list = new LinkedListofInt();

                    for(int i =len -1; i >= 0 ; i--){
                        jNums[i] = Integer.parseInt(jerseyParts[i]);
                        hNums[i] = Integer.parseInt(heightParts[i]);
                        list.addToStart(jNums[i],hNums[i]);
                    }

                    list.printShortest();

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
