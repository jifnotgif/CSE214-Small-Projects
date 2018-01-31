package hw.cse214.leakystack;
import java.io.*;
import java.util.Scanner;


public class LeakyStack {
    public static void main(String[] args) {
        File file = new File("in3.txt");

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int cases = input.nextInt();
                input.nextLine();
                while (cases > 0) {
                    int capacity = input.nextInt();
                    input.nextLine();
                    String stackInput = input.nextLine();
                    String[] arr = stackInput.split(" +");
                    LinkedStackOfStrings stack = new LinkedStackOfStrings(capacity);
                    for (int i = 0; i < arr.length; i++) {
                        stack.push(arr[i]);
                    }
                    for (int i = 0; i < capacity; i++) {
                        System.out.print(stack.pop() + " ");
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
