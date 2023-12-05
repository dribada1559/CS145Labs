// Name: Darcy Ribada
// Class: CS 145
// Date: 9/26/23
// Assignment: Lab 1
// Reference Materials: W3Schools, Example Code from textbook
// Purpose: Guessing game where user attempts to guess a random number that is generated.
   
   import java.util.Scanner; // program imports Scanner class from the library
   
   import java.util.Random ; //program imporst Random class
   

public class Lab1 {
   
   //executes the program

   public static void playGame() { 
      // method that calls other sub methods to make the full game

      int Continue = 1;

      Scanner input = new Scanner(System.in); // initializes scanner input

      while(Continue == 1){
         // method will continue running if Continue value is 1

         singleRound();

         System.out.print("Do you want to play again? ");

         char ContinueInput = input.next().charAt(0);

         if (ContinueInput == 'y' | ContinueInput == 'Y') {

            Continue = 1;

            System.out.println();

            System.out.println();

         } else { // ends the game

            Continue = 0;

         }


      }

   }


   public static void singleRound() { // method for a single round 

      Scanner input = new Scanner(System.in); // initialize scanner input

      Random random = new Random(); // creates a random object\

      int upperLimit = 200;

      int randNum = random.nextInt(upperLimit); //calls a random integer with a parameter(aka the upper limit)

      long guessCount = 1 ; // long is a datatype that stores whole numbers
      // initializes the guess increments

      int ContinueSingle = 1 ;

      System.out.println(" I'm thinking of a number between 1 and " + upperLimit + "...");

      while(ContinueSingle == 1) {

         System.out.print("Your guess? "); // prompt and store return in date

         double guess = input.nextDouble(); // input is assigned to the double, guess

         System.out.println();

         if (guess == randNum){ // if the guess is correct

            System.out.println("You got it right in " + guessCount + " guesses! ");

            ContinueSingle = 0 ;

         } else { // else guess is higher or lower 

            if (guess > randNum) { // if guess is higher than correct

               System.out.println("It's lower. ");

               System.out.println();

            }

            if (guess < randNum) { // if guess is higher than correct
               
               System.out.println("It's higher. ");

               System.out.println();

            }

         }

         guessCount ++; // adds one to the guess counter

      }


   }

   public static void main(String[] args){ // creates the main method

      playGame();

   }




}