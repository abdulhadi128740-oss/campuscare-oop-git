import person.Person;
import person.Student;
import person.Staff;
import ticket.Ticket;
import ticket.MaintenanceTicket;
import ticket.CleaningTicket;
import java.util.ArrayList;
import java.util.Scanner;

public class CampusCare1 {
    // Lists to store data
    static ArrayList<Person> people = new ArrayList<>();
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    // Counters for IDs
    static int personIdCounter = 1;
    static int ticketIdCounter = 1;

    public static void main(String[] args) {
        // Add some dummy data for testing Git later
        people.add(new Student(1, "Ali", "ali@student.com", "CS", 3));
        people.add(new Staff(2, "Mr. Khan", "khan@staff.com", "IT"));

        boolean running = true;
        while (running) {
            System.out.println("\n--- CampusCare Menu ---");
            System.out.println("1. Add Person");
            System.out.println("2. Create Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Update Ticket Status");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: addPerson(); break;
                case 2: createTicket(); break;
                case 3: viewTickets(); break;
                case 4: updateStatus(); break;
                case 5: 
    // TODO: Generate report feature - NOT YET IMPLEMENTED
    System.out.println("Report feature coming soon...");
    break;
case 6: running = false; System.out.println("Exiting..."); break;
            }
        }
    }

    private static void addPerson() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Role (1: Student, 2: Staff): ");
        int role = sc.nextInt();
        sc.nextLine();

        if (role == 1) {
            System.out.print("Program: ");
            String prog = sc.nextLine();
            System.out.print("Semester: ");
            int sem = sc.nextInt();
            sc.nextLine();
            people.add(new Student(personIdCounter++, name, email, prog, sem));
        } else {
            System.out.print("Department: ");
            String dept = sc.nextLine();
            people.add(new Staff(personIdCounter++, name, email, dept));
        }
        System.out.println("Person Added!");
    }

    private static void createTicket() {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();
        System.out.print("Location: ");
        String loc = sc.nextLine();
        System.out.print("Type (1: Maintenance, 2: Cleaning): ");
        int type = sc.nextInt();
        sc.nextLine();

        if (type == 1) {
            System.out.print("Item (Chair/Desk/etc): ");
            String item = sc.nextLine();
            tickets.add(new MaintenanceTicket(ticketIdCounter++, title, desc, loc, item));
        } else {
            System.out.print("Issue (Trash/Dirty): ");
            String issue = sc.nextLine();
            tickets.add(new CleaningTicket(ticketIdCounter++, title, desc, loc, issue));
        }
        System.out.println("Ticket Created!");
    }

    private static void viewTickets() {
        System.out.println("\n--- All Tickets ---");
        for (Ticket t : tickets) {
            System.out.println(t.toString()); // Polymorphism called here
        }
    }

    private static void updateStatus() {
        System.out.print("Enter Ticket ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("New Status (New/Assigned/Resolved): ");
        String status = sc.nextLine();

        for (Ticket t : tickets) {
            if (t.getTicketId() == id) {
                t.setStatus(status);
                System.out.println("Status Updated!");
                return;
            }
        }
        System.out.println("Ticket ID not found.");
    }
}