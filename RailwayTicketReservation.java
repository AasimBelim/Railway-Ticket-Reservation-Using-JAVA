import java.util.ArrayList;
import java.util.Scanner;

class Passenger {
    String name;
    int age;
    String gender;

    Passenger(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

  
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}

class Ticket {
    int ticketNumber;
    ArrayList<Passenger> passengers;

    Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
        this.passengers = new ArrayList<>();
    }

    void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket Number: ").append(ticketNumber).append("\n");
        for (Passenger p : passengers) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}

class RailwayReservationSystem {
    private static final int MAX_TICKETS = 5;
    private ArrayList<Ticket> tickets;
    private int ticketCounter;

    RailwayReservationSystem() {
        tickets = new ArrayList<>();
        ticketCounter = 1;
    }

    boolean bookTicket() {
        if (tickets.size() >= MAX_TICKETS) {
            System.out.println("All tickets are booked. No availability.");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        Ticket ticket = new Ticket(ticketCounter++);

        System.out.print("Enter number of passengers: ");
        int numOfPassengers = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numOfPassengers; i++) {
            System.out.println("Enter details for passenger " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            Passenger passenger = new Passenger(name, age, gender);
            ticket.addPassenger(passenger);
        }

        tickets.add(ticket);
        System.out.println("Ticket booked successfully! Ticket Number: " + ticket.ticketNumber);
        return true;
    }

    void checkAvailability() {
        int availableTickets = MAX_TICKETS - tickets.size();
        System.out.println("Available tickets: " + availableTickets);
    }

    void displayTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked yet.");
        } else {
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }
}

public class RailwayTicketReservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RailwayReservationSystem system = new RailwayReservationSystem();
        boolean running = true;

        while (running) {
            System.out.println("\nRailway Ticket Reservation System");
            System.out.println("1. Book Ticket");
            System.out.println("2. Check Availability");
            System.out.println("3. Display Booked Tickets");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.bookTicket();
                    break;
                case 2:
                    system.checkAvailability();
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
