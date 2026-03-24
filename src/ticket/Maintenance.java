package ticket;

public class MaintenanceTicket extends Ticket {
    private String type; // Chair, Desk, Window, Board

    public MaintenanceTicket(int ticketId, String title, String desc, String loc, String type) {
        super(ticketId, title, desc, loc);
        this.type = type;
    }

    @Override
    public double priorityScore() {
        // Rule: Priority high if location contains 'lab'
        if (this.location.toLowerCase().contains("lab")) {
            return 9.5;
        }
        return 5.0;
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Type: Maintenance (" + type + ")";
    }
}