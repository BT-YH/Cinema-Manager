import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Stage 4
 * @author (Barry Tang)
 * @version (Aug 2 2022)
 */
public class Main {
    private static boolean condition = true;
    
    public static void main(String args[]) {
        Cinema newCinema = new Cinema();
        newCinema.getCinemaDimensions();
        newCinema.setCinema();
        while (condition) {
            newCinema.menu();
        }
    }
    
    public static void toFalse() {
        condition = false;
    }
}


class Cinema {
    private String[][] cinema;
    private int numOfRows, numOfSeats;
    private int rowNumber, seatNumber;
    private int numOfPurchasedTickets, currentIncome, totalIncome;
    private double percentage;
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
        boolean correct = false;
        while (!correct) {
            System.out.print("Enter the number of rows:\n> ");
            try {
                numOfRows = in.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("You should enter integer numbers!");
                continue;
            }
            
            if (numOfRows > 9) {
                System.out.println("Number of rows too large!");
                continue;
            }
            correct = true;
        }
        correct = false;
        while (!correct) {
            System.out.print("Enter the number of seats in each row:\n> ");
            try {
                numOfSeats = in.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Wrong input!");
                continue;
            }
            
            if (numOfSeats > 9) {
                System.out.println("Too many seats in one row!");
                continue;
            } 
            correct = true;
        }
    }
    
    public void getSeatCoordinates() {
        Scanner in = new Scanner(System.in);
        boolean correct = false;
        while (!correct) {
            System.out.print("\nEnter a row number:\n> ");
            try {
                rowNumber = in.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Wrong input!\n");
                continue;
            }
            
            if (rowNumber > numOfRows) {
                System.out.println("Wrong input!\n");
                continue;
            } 
            correct = true;
        }
        
        correct = false;
        while (!correct) {
            System.out.print("Enter a seat number in that row:\n> ");
            try {
                seatNumber = in.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Wrong input!\n");
                continue;
            }
            if (seatNumber > numOfSeats) {
                System.out.println("Wrong input!\n");
                continue;
            } else if (cinema[rowNumber - 1][seatNumber - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!\n");
                getSeatCoordinates();
                numOfPurchasedTickets--;
                break;
            }
            correct = true;
            numOfPurchasedTickets++;
        }
    }
    
    private void calculatePercentage() {
        int totalNumOfSeats = numOfRows * numOfSeats;
        percentage = 100.0 * numOfPurchasedTickets / totalNumOfSeats;
        System.out.println(percentage);
    }
    
    private void calculateTotalIncome() {
        int totalNumOfSeats = numOfRows * numOfSeats;
        if (totalNumOfSeats <= 60) {
            totalIncome = totalNumOfSeats * 10;
        }
        else {
            totalIncome = (numOfRows/2) * numOfSeats * 10 + (numOfRows - numOfRows/2) * numOfSeats * 8;
        }
    }
    
    public void printTicketPrice() {
        int totalNumOfSeats = numOfRows * numOfSeats;
        if (totalNumOfSeats <= 60) {
            System.out.println("Ticket price: $10");
            currentIncome += 10;
        }
        else {
            if (rowNumber <= numOfRows/2) {
                System.out.println("Ticket price: $10");
                currentIncome += 10;
            }
            else {
                System.out.println("Ticket price: $8");
                currentIncome += 8;
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
    
    public void printStatistics() {
        calculatePercentage();
        calculateTotalIncome();
        System.out.println("\nNumber of purchased tickets: " + numOfPurchasedTickets);
        System.out.printf("%s %.2f%s", "Percentage:" , percentage, "%\n");
        System.out.println("Current income: " + "$" + currentIncome);
        System.out.println("Total income: " + "$" + totalIncome);
    }
    
    public void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.print("> ");
        int index = in.nextInt();
        
        switch (index) {
            case 1:
                printCinema();
                break;
            case 2:
                getSeatCoordinates();
                setSeat();
                printTicketPrice();
                break;
            case 3:
                printStatistics();
                break;
            case 0:
                Main.toFalse();
        }
    }
}
