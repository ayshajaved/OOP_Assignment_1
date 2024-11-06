public class Person{
    private String name;
    private String contactNumber;
    private String email;
    Person(String name, String contact, String email){
        if (name == null || contact == null || email == null || name.isEmpty() || contact.isEmpty() || email.isEmpty()){        //Exception handling
            throw new IllegalArgumentException("Name, Contact and Email cannot be null or empty");
        }
        this.name = name;
        this.contactNumber = contact;
        this.email = email;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return String.format("%s\nContact: %s %s",getName(),getContactNumber(),getEmail());
    }
    
}