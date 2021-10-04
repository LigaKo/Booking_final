# Booking_final
​
A very simple, beginner level bus ticket booking system. 
​
​
​
​
​
**Language:** Java
​
**Database:** MySQL
​
**IDE:** IntelliJ IDEA
​
  ## Usage
​
1.  The user should start the ticket booking process by entering the username and password. There are three possible inputs (demo users) in order to continue with the booking:
​ -Username: 1 && Password: 1​
 -Username: 2 && Password: 2​
 -Username: 3 && Password: 3
​ 
2. Next, a list of destinations will be printed out. User makes his/her choice by entering bus ID;
3. After that, the user chooses date and time for available routes to the chosen destination. Information about destinations, date and time, as well as ticket price is taken from mySQL database.
4. After the route is selectes the user selects the seat. Full seating plan is printed and a list of available seats is printed out. User can select only available seats (seats that are not booked by already confirmed bookings included in the database).
5. Next step - user is asked to enter his/her data: name, surname, email and phone number;
6. Last step - user has to choose ticket type by entering Ticket Code. Discounts are available for students, children, disabled persons and 3+ family card holders. If the user is not eligible for any discounts, Ticket Code **1** should be inputted in order to book a regular ticket.
7. When all steps are done, full billing information will be printed out. User can confirm (by entering **"1"**) or cancel (by entering **"2"**) the reservation. Then the program will confirm whether the booking has been confirmed/cancelled successfully. 
8. After booking is confirmed, information about the passenger is included in the database.

## Support
​
For further support, please contact Līga Koloda, Kristīne Damskalne or Una Tarziere via Slack.
