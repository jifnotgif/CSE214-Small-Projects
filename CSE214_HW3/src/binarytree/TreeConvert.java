package hw.cse214.binarytree;

import java.io.*;
import java.util.Scanner;

public class TreeConvert {

    public static void main(String[] args) {
        File file = new File("in1.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int cases = input.nextInt();
                String nodeValues;
                while (cases > 0) {
                    int numNodes = input.nextInt();
                    int swapCount = 0;
                    input.nextLine();
                    nodeValues = input.nextLine();
                    String[] stringOfValues = nodeValues.split("\\s");
                    int[] nodeData = new int[stringOfValues.length];
                    for (int i = 0; i < nodeData.length; i++) {
                        nodeData[i] = Integer.parseInt(stringOfValues[i]);
                    }

                    BT tree = new BT();
                    tree.root = tree.insert(nodeData, tree.root, 0);
                    int[] sortedArr = tree.traverseInorder(tree, nodeData);
                    swapCount = tree.sortArray(sortedArr, swapCount);
                    System.out.println(swapCount);
                    cases--;
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}


