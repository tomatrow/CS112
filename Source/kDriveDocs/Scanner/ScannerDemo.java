// This program demonstrates some of the Scanner class methods.

import java.util.Scanner;

public class ScannerDemo
{
   public static void main(String[] args)
   {
      String name;         // To hold a name
      int hours;           // Hours worked
      double payRate,      // Hourly pay rate
             grossPay;     // Gross pay
      
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get the user's name.
      System.out.print("What is your name? ");
      name = keyboard.nextLine();
      
      // Get the number of hours worked this week.
      System.out.print("How many hours did you work this week? ");
      hours = keyboard.nextInt();
      
      // Get the user's hourly pay rate.
      System.out.print("What is your hourly pay rate? ");
      payRate = keyboard.nextDouble();
      
      // Calculate the gross pay.
      grossPay = hours * payRate;
      
      // Display the resulting information.
      System.out.println("");
      System.out.println("Hello " + name);
      System.out.println("Your gross pay is $" + grossPay);
   }
}
