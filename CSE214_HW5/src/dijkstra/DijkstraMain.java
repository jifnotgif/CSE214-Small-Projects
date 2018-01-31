package cse214.hw.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DijkstraMain {
    public static void main(String[] args){
        File file = new File("in1.txt");
        try{
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                int cases = input.nextInt();
                while(cases >0){
                    int vertices = input.nextInt();
                    int source = input.nextInt();
                    int destination = input.nextInt();
                    int[][] matrix = new int[vertices][];
                    input.nextLine();
                    for (int i =0; i< matrix.length; i++){
                        String[] rows = input.nextLine().split("\\s");
                        matrix[i] = new int[rows.length];
                        for(int j =0; j< rows.length; j++){
                            matrix[i][j] = Integer.parseInt(rows[j]);
                        }
                    }
                    DijkstraGraph g = new DijkstraGraph(vertices, source, destination, matrix);
                    g.dijkstra();
                    cases--;
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
