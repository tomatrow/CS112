// This program correctly reads numeric and string input correctly
// using the Scanner class methods.

 
import java.util.Scanner;
 
public class CorrectScannerInput
{
   public static void main(String[] args)
   {
      String name;   // To hold the user's name
      int age;       // To hold the user's age
      double income; // To hold the user's income
      
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get the user's age.
      System.out.print("What is your age? ");
      age = keyboard.nextInt();
      
      // Get the user's income
      System.out.print("What is your annual income? ");
      income = keyboard.nextDouble();
      
      // Consume the remaining newline character.
      keyboard.nextLine();
      
      // Get the user's name.
      System.out.print("What is your name? ");
      name = keyboard.nextLine();
      
      // Display the information back to the user.
      System.out.println("");
      System.out.println("Hello " + name + ". Your age is "
                         + age + " and your income is $"
                         + income);
   }
}
