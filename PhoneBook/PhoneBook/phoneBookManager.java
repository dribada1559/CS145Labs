import java.util.LinkedList;



public class phoneBookManager {
    private LinkedList<PhoneBook> phoneBook;

    public phoneBookManager(){
        this.phoneBook = new LinkedList<PhoneBook>(); // initializes list
    }
    

    public void add(PhoneBook contactNode) { // adds to the phonebook list
        phoneBook.add(contactNode);

    }


    public void delete(String to_delete) { //iterates through phonebook and deletes entry
        for(PhoneBook contact : phoneBook){
            if(contact.getLastName().equals(to_delete)){
                phoneBook.remove(contact);
                System.out.println(contact.getFirstName() + " has been deleted");
                return;
            }
        }
        System.out.println("Contact not found with last name:" + to_delete);

    }


    public void searchName(String to_search) { //takes in last name and searches through the list

        for(PhoneBook contact : phoneBook){
            if(contact.getLastName().equals(to_search)){
                System.out.println("Contact found: " + contact.toString());
                return;
            }
        }
    }


    public void print() { //prints all entries
        System.out.println("Phone Book Entries");
        for(PhoneBook contact : phoneBook){
            System.out.println(contact.toString());
        }
    }

}
