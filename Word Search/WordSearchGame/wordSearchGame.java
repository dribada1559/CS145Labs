// Name: Darcy Ribada
// Class: CS 145
// Date: 10/16/2023
// Assignment: Word Search Generator
// Reference Materials: w3schools, chatGPT, tutoring center, and colleagues from WWU
// Purpose: This program creates a basic word generator. 




import java.util.ArrayList;
import java.util.Scanner;

public class wordSearchGame{
    
    boolean generated = false;
    Scanner scanner = new Scanner(System.in);
    String userInput;
    wordSearch search = new wordSearch();

    public void runProgram(){
        intro();
        userInput = scanner.next();

    }



    private void intro() { //prints intro and initializes otions

        System.out.println("Welcome to my Word Search Genorator!/n");
        System.out.println("This program will generate your own word search puzzle");
        inputOptions();
        inputOptionsChoice();

    }


    

    private void inputOptions() { //input options

        System.out.println("Please select an opion:");
        System.out.println("Generate a new word search (g)");
        System.out.println("Print out your own word search (p)");
        System.out.println("Show the solution to your word search (s)");
        System.out.println("Quit the program (q)");


        
    }

    private void inputOptionsChoice(){ //accepts users input and initializes code to create the word search


        do{
            userInput = scanner.next();
            if(userInput.toLowerCase().equals("q")){ 
                break; //exits loop

            }else if(userInput.toLowerCase().equals("g")){ //generates the user's words

                System.out.println("Please enter word(s), then type 0 when done.");
                String userWord = scanner.next();
                ArrayList<String> wordsArray = new ArrayList<String>();

                do{ // keep adding words until 0 entered.

                    wordsArray.add(userWord); // add words to array
                    userWord = scanner.next();
            
                } while (!userWord.equals("0")); // when done

                String[] words = new String[wordsArray.size()];
                wordsArray.toArray(words);
                search.generate(words);
                generated = true;
                inputOptionsChoice(); //reiterates the choices 


            } else if(userInput.toLowerCase().equals("p")){ //generates word search without solution 

                if (generated) {
                    print(search);  
                }

            } else if (userInput.toLowerCase().equals("s")){ // generates solutions

                if(generated){
                    showSolution(search);
                }

            } else {
                System.out.println("Your input is invalid, please enter the following options. ");


            }
        } while (true);


    }

    public static void showSolution(wordSearch search2) { // shows solution through word search class
        System.out.println(search2.toSolution());
    }

    public static void print(wordSearch search2) { // prints word search without solution
        System.out.println(search2.puzzleToString());

    }




}