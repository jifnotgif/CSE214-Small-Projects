public class ArrayPair{

    /**
     * Method that searches for and prints two values that equal input sum
     *
     * @param inputArray
     * An array that holds values to be printed
     * @param sum
     * The sum that two values must be equal to
     * @return
     * print two numbers and their sum
     */

    public static void findPair(int[] inputArray, int sum){

        int total = sum;                                       //O(1)
        int[] arr = inputArray;                                //O(1)
        int firstNum =0,secondNum=0;                           //O(1)
        for (int i = 0 ; i < arr.length; i++) {                //O(n)
            for (int j = i + 1; j < arr.length; j++) {         //O(n)
                if (arr[i] + arr[j] == total) {
                    firstNum = arr[i];                         //O(n-1)
                    secondNum = arr[j];                        //O(n-1)
                    System.out.println(firstNum + " + " + secondNum + " = " + total + " , true");
                    return;
                }
            }
        }
        if (firstNum == 0 && secondNum ==0 && total != 0) System.out.println("false");
    }

    public static void main(String[] args) {

        int[] test = {11, 15, 6, 8, 9, 10, 0};
        int x = 16;
        findPair(test, x);

    }
}