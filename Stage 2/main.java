import java.util.Scanner;


/**
 *  Read two positive integer numbers from the input: 
 *  the number of rows and the number of seats in each row.
 *  
 *  Calculate the profit from the sold tickets depending
 *  on the number of seats and print the result
 *
 * @author (Barry Tang)
 * @version (Aug 2 2022)
 */



public class main
{
    public static void main (String args[]) {
        int price = -1;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows:\n> ");
        int numOfRows = in.nextInt();
        System.out.println("Enter the number of seats in each row:\n> ");
        int numOfSeats = in.nextInt();
        
        int totalNumOfSeats = numOfRows * numOfSeats;
        if (totalNumOfSeats <= 60) {
            price = totalNumOfSeats * 10;
        }
        else {
            price = (numOfRows/2) * numOfSeats * 10 + (numOfRows - numOfRows/2) * numOfSeats * 8;
        }
        
        System.out.println("Total income:\n" + "$" + price);
    }
}
