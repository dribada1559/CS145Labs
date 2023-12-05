import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class phoneBookMain {

    private static List phoneBookNode;
    private static Scanner book;
    
    public static void main(String[] args) throws IOException{

        book = new Scanner(System.in);

        phoneBookManager Bellingham = new phoneBookManager();


        Integer menu = 0;
        boolean finished = false;

        while(menu != 5){ //menu options

            System.out.println();
            System.out.println("1. Add new contact");
            System.out.println("2. Delete contact");
            System.out.println("3. Search contact");
            System.out.println("4. Print contact list");
            System.out.println("5. Exit");
            System.out.println("Please select your choice: ");

            String userInput = book.nextLine(); //figure this out
            menu = Integer.parseInt(userInput);
            switch (menu) {
                        case 1: //add contact
                            System.out.println("Please enter first name: ");
                            String firstName = book.nextLine();
                            
                            System.out.println("Please enter last name: ");
                            String lastName = book.nextLine();

                            System.out.println("Please enter address: ");
                            String address = book.nextLine();

                            System.out.println("Please enter phone number: ");
                            String phoneNumber = book.nextLine();

                            System.out.println("Please enter city: ");
                            String city = book.nextLine();

                            PhoneBook contactNode = new PhoneBook(lastName, firstName, 
                                                        address, phoneNumber, city);
                            Bellingham.add(contactNode);

                            break;

                        case 2://delete contact
                            System.out.println("Please enter first name:");
                            String to_delete = book.nextLine();
                            Bellingham.delete(to_delete);

                            break;

                        case 3://search contact
                            System.out.println("Please enter the name to search for: ");
                            String to_search = book.nextLine();
                            Bellingham.searchName(to_search);

                            break;

                        case 4: //prints lists
                            System.out.println("Printing Phonebook. ");
                            Bellingham.print();

                            break;

                        case 5: //exit
                            System.out.println("Thank you for using Yellow Pages");
                            System.exit(0);

                    
                        default:
                            System.out.println("Invalid choice, please select a valid option");;
                    }


        }
        book.close();
        
    }
}
