import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean[] seats = new boolean[10]; // Example with 10 seats
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Show available seats");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookSeat(seats, scanner);
                    break;
                case 2:
                    cancelSeat(seats, scanner);
                    break;
                case 3:
                    showAvailableSeats(seats);
                    break;
                case 4:
                    System.out.println("Thank you for using the bus reservation system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void bookSeat(boolean[] seats, Scanner scanner) {
        System.out.print("Enter seat number to book (0-9): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 0 || seatNumber >= seats.length) {
            System.out.println("Invalid seat number.");
            return;
        }
        if (seats[seatNumber]) {
            System.out.println("Seat already booked.");
            return;
        }
        seats[seatNumber] = true;
        System.out.println("Seat booked successfully.");
    }

    private static void cancelSeat(boolean[] seats, Scanner scanner) {
        System.out.print("Enter seat number to cancel (0-9): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 0 || seatNumber >= seats.length) {
            System.out.println("Invalid seat number.");
            return;
        }
        if (!seats[seatNumber]) {
            System.out.println("Seat is not booked yet.");
            return;
        }
        seats[seatNumber] = false;
        System.out.println("Seat canceled successfully.");
    }

    private static void showAvailableSeats(boolean[] seats) {
        System.out.println("Available seats:");
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

