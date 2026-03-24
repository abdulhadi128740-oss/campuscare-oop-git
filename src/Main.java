System.out.println("1. Add Person (Student/Staff)"); // thoda change karein
System.out.println("1.Add Person/Staff/Student");
System.out.println("5. Generate Report");  // NAYA: Adhoora feature
System.out.println("6. Exit");

private static void generateReport() {
    System.out.println("\n--- Ticket Report ---");
    int newCount = 0, assignedCount = 0, resolvedCount = 0;
    
    for (Ticket t : tickets) {
        switch (t.getStatus()) {
            case "New": newCount++; break;
            case "Assigned": assignedCount++; break;
            case "Resolved": resolvedCount++; break;
        }
    }
    
    System.out.println("Total Tickets: " + tickets.size());
    System.out.println("New: " + newCount);
    System.out.println("Assigned: " + assignedCount);
    System.out.println("Resolved: " + resolvedCount);
}
