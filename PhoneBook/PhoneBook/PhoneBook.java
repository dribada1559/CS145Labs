public class PhoneBook{

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String city;

    //constructor
    public PhoneBook(String firstName, String lastName, String address, 
                                                    String phoneNumber, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;

    }

    public PhoneBook() {
        
    }

    public String toString(){ 
        return "Name: " + firstName + " "+ lastName + "\nAddress: " + address + 
            "\nPhone number: " + phoneNumber + "\nCity: " + city;
    }


    public String getFirstName(){
        return firstName;

    }

    public String getLastName(){
        return lastName;

    }

    public String getAddress(){
        return address;

    }

    public String getPhoneNumber(){
        return phoneNumber;

    }

    public String getCity(){
        return city;

    }

    public void setFirstName(String firstName){
        this.firstName = firstName;

    }

    public void setLastName(String lastName){
        this.lastName = lastName;

    }

    public void setAddress(String address){
        this.address = address;

    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        
    }




}