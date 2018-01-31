package cse214.hw.escape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class PrisonEscape {
    public static void main(String[] args){
        File file = new File("in1.txt");
        try{
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                int cases = input.nextInt();
                while(cases >0){
                    int n = input.nextInt();
                    int[][] field = new int[n][];
                    input.nextLine();
                    for (int i =0; i<field.length; i++){
                        String[] rows = input.nextLine().split("\\s");
                        field[i] = new int[rows.length];
                        for(int j =0; j< rows.length; j++){
                            field[i][j] = Integer.parseInt(rows[j]);
                        }
                    }
                    Graph maze = new Graph(n, field);
                    maze.traverseMaze(field, 0, 0);
                    System.out.println(maze.getCount());
                    cases--;

                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
