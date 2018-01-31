package hw.cse214.concert;
import java.io.*;
import java.util.Scanner;

public class ConcertCost {
    public static void main(String[] args) {
        File file = new File("in2.txt");
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                int cases = input.nextInt();
                String numSeats;
                while (cases > 0) {
                    int seatRows = input.nextInt();
                    int numFans = input.nextInt();
                    int total = 0;
                    input.nextLine();
                    numSeats = input.nextLine();
                    String[] seats = numSeats.split("\\s");
                    int[] seatPrices = new int[seatRows];
                    for (int i = 0; i < seatRows; i++){
                        seatPrices[i] = Integer.parseInt(seats[i]);
                    }

                    PriorityQueue ticketSales = new PriorityQueue(seatRows);
                    for(int i =0; i < seatRows; i++){
                        ticketSales.insert(seatPrices[i]);
                    }
                    for (int i = numFans; i > 0; i--) {
                        total += ticketSales.getCost();
                    }
                    System.out.println(total);
                    cases--;
                }
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
