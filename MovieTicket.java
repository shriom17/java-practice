class MovieTicket{
    String movieName;
    String customerName;
    int ticketsBooked;
    double ticketPrice;
   
    MovieTicket(String movieName, String customerName, int ticketsBooked, double ticketPrice)
    {
        this.movieName = movieName;
        this.customerName = customerName;
        this.ticketsBooked = ticketsBooked;
        this.ticketPrice = ticketPrice;
    }
    
    
    public double calculateTotalCost()
    {
        return ticketsBooked * ticketPrice;
    }
    public void addTickets(int extraTickets)
    {
        this.ticketsBooked += extraTickets;
    }

    public void display()
    {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Tickets Booked: " + ticketsBooked);
        System.out.println("Ticket Price: " + ticketPrice);
        System.out.println("Total Cost: " + calculateTotalCost());
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args)
{
    MovieTicket customer1 = new MovieTicket("NaraSimha", "Shriom",3, 500.00);
    MovieTicket customer2 = new MovieTicket("Narasimha", "Paulami", 3, 500.00);
   
    customer1.display();
    customer2.display();
    
    customer2.addTickets(1);
    System.out.println("Update Booking for: " + customer2.customerName);
    customer2.display();

}
}

