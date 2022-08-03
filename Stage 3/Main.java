import java.util.Scanner;

/**
 * Stage 3
 *
 * @author (Barry Tang)
 * @version (Aug 2 2022)
 */
public class Main {
    public static void main(String args[]) {
        Cinema newCinema = new Cinema();
        newCinema.getCinemaDimensions();
        newCinema.setCinema();
        newCinema.printCinema();
        
        newCinema.getSeatCoordinates();
        newCinema.printTicketPrice();
        newCinema.setSeat();
        newCinema.printCinema();
    }
}

class Cinema {
    private String[][] cinema;
    private int numOfRows, numOfSeats;
    private int rowNumber, seatNumber;
    
    public Cinema() {
        
    }
    
    public void setCinema() {
        cinema = new String[numOfRows][numOfSeats];
        for (int row = 0; row < cinema.length; row++) {
            for (int col = 0; col < cinema[0].length; col++) {
                cinema[row][col] = "S";
            }
        }
    }
    
    public void setSeat() {
        cinema[rowNumber-1][seatNumber-1] = "B";
    }
    
    public void getCinemaDimensions() { 
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n> ");
        numOfRows = in.nextInt();
        System.out.print("Enter the number of seats in each row:\n> ");
        numOfSeats = in.nextInt();
    }
    
    public void getSeatCoordinates() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a row number:\n> ");
        rowNumber = in.nextInt();
        System.out.print("Enter a seat number in that row:\n> ");
        seatNumber = in.nextInt();
    }
    
    public void printTicketPrice() {
        int totalNumOfSeats = numOfRows * numOfSeats;
        if (totalNumOfSeats <= 60) {
            System.out.println("Ticket price: $10");
        }
        else {
            if (rowNumber <= numOfRows/2) {
                System.out.println("Ticket price: $10");
            }
            else {
                System.out.println("Ticket price: $8");
            }
        }
    }
    
    public void printCinema() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i <= numOfSeats; i++) {
            if (i == numOfSeats) {
                System.out.println(i);
            }
            else {
                System.out.print(i + " ");
            }
        }
        
        for (int row = 0; row < cinema.length; row++) {
            System.out.print(row + 1);
            for (int col = 0; col < cinema[0].length; col++) {
                System.out.print(" " + cinema[row][col]);
            }
            System.out.print("\n");
        }
    }
}
