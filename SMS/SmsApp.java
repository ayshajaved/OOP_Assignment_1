import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class SmsApp {
    Sms chats[][];
    int chatIndex[];
    Person contacts[];
    int c;
   
SmsApp(){
    chatIndex = new int[20];
    chats = new Sms[20][];
    contacts = new Person[20];
    c = 10;
    for(int i = 0; i < 10; i++){
        chats[i] = new Sms[100]; // Assuming a maximum of 100 messages per contact
    }
    addReceiver();
    addMessages();
}
public void addContact(Scanner sc){
    if(chats == null){ 
        chats = new Sms[20][];  // Reinitialize the array if null
        for(int i = 0; i < 10; i++){
            chats[i] = new Sms[100]; // Assuming a maximum of 100 messages per contact
        }
        chatIndex = new int[20];  // Also reset chatIndex array
    }
    System.out.print("\nEnter name of the Contact: ");
    String contact_name = sc.nextLine();
    System.out.print("Enter Contact Number: ");
    String contact_ = sc.nextLine();
    System.out.print("Enter Contact Email: ");
    String contact_email = sc.nextLine();
    contacts[c] = new Person(contact_name, contact_, contact_email);
    chats[c] = new Sms[100];
    c++;
    System.out.println("Contact Added successfully...");
    
}
public int getContactIndex(Person sender){
    for(int o =0; o<contacts.length; o++){
        if(contacts[o]!=null){
        if(contacts[o].equals(sender)){
            return o;
        }
    }
}
    return -1;
}
public void send(Person receiver,String content){
    if(chats == null){ 
        chats = new Sms[20][];  // Reinitialize the array if null
        for(int i = 0; i < 10; i++){
            chats[i] = new Sms[100];  // Assuming a maximum of 100 messages per contact
        }
        chatIndex = new int[20];  // Also reset chatIndex array
    }
    int contactIndex = getContactIndex(receiver);
    Sms sms = new Sms(receiver,content, false);
    chats[contactIndex][chatIndex[contactIndex]] = sms;
    chatIndex[contactIndex]++;
}
//overloading
public void send(Person sender,String content, boolean c){
    if(chats == null){ 
        chats = new Sms[20][];  // Reinitialize the array if null
        for(int i = 0; i < 10; i++){
            chats[i] = new Sms[100];  // Assuming a maximum of 100 messages per contact
        }
        chatIndex = new int[20];  // Also reset chatIndex array
    }
    int contactIndex = getContactIndex(sender);
    Sms sms = new Sms(sender,content,c);
    sms.setReceiveTime();
    if(chats!=null){
    chats[contactIndex][chatIndex[contactIndex]] = sms;
    chatIndex[contactIndex]++;
    }
}
public void sendMessage(Scanner sc){
    Person receiver_selection = selectReceiver(sc);
    System.out.println("Enter your messge Ayesha Javed for "+ receiver_selection.getName()+": ");
    String message =sc.nextLine();
    System.out.println("Dear "+receiver_selection.getName() +"!Have you received message from Ayesha Javed!..\n(1) for YES\n(0) for NO!");
    int seen = sc.nextInt();
    sc.nextLine();
    if(seen==1){
        send(receiver_selection, message, true);
    }
    else if(seen ==0){
        send(receiver_selection, message);
    }
    else{
        System.out.println("Plz enter valid choice..");
    }
    System.out.println("Message added...");

}
public void displayMessages(Scanner sc){
    if(chats != null){
        while(true){
            System.out.println("""
            Enter your choice:
            (1) Display Message of a particular contact..
            (2) To Display All Messages..
            (0) Exit
                """);
                int choice = sc.nextInt();
            sc.nextLine();
                switch(choice){
                    case 1: 
                        boolean hasMessages = false;
                        Person send = selectReceiver(sc);
                        int cindex = getContactIndex(send);
                        if(cindex != -1 && chats[cindex] != null){
                        for(int i=0; i< chats[cindex].length;i++){
                            if(chats[cindex][i]!=null){
                            System.out.println(chats[cindex][i]);
                            System.out.println("********************");
                            hasMessages = true;
                        }
                    }
                }
                if (!hasMessages) {
                    System.out.println("\nThis contact has not sent any messages.\n");
                }
                        break;
                    case 2:
                        System.out.println("Displaying all the Messages..");
                        for(int i = 0;i<contacts.length; i++){
                            if(chats[i]!=null){
                            for(int j=0; j<chatIndex[i];j++){
                                if(chats[i][j]!=null){
                                System.out.println(chats[i][j]);
                                System.out.println();
                            }
                        }
                    }
                        }
                        break;
                    case 0:
                        return;
                    default:
                        break;
                }
        }
    }
    else{
        System.out.println("All messages are Deleted!There are no chats...");
    }
}
public void addMessages(){
    //adding default messages to the array
    send(contacts[0],"Hello how are you!", false);
    send(contacts[0],"Wanna catch up!!");
    send(contacts[1],"Let's catch up!");
    send(contacts[1],"I am going to call you!");
    send(contacts[2],"Aren't you going to attend the wedding?", false);
    send(contacts[2],"I am ready! pick me up..", false);
    send(contacts[3],"I do! it was amazing");
    send(contacts[3],"Have you Attended the party?");
    send(contacts[4],"Come to my house!We will have a dinner together!", false);
    send(contacts[4],"I have baked a special cake for you", false);
}
public void deleteMessage(Scanner sc){
    if(chats !=null){
        while(true){
            System.out.println("""
            Enter your choice:
            (1) Delete Message of a particular contact..
            (2) To Delete All Messages..
            (0) Exit
                """);
                int choice = sc.nextInt();
            sc.nextLine();
                switch(choice){
                    case 1: 
                        Person send = selectReceiver(sc);
                        int cindex = getContactIndex(send);
                        if(cindex != -1 && chats[cindex] != null){
                        for(int i = 0; i<chats[cindex].length;i++){
                            if(chats[cindex][i]!=null){
                            System.out.println(chats[cindex][i]);
                            System.out.println("********************");
                        }
                    }
                }
                    System.out.println("Enter ID to delete: ");
                    String id = sc.nextLine();
                    for(int i = 0; i<chats[cindex].length;i++){
                        if(chats[cindex][i].getMessageId().equals(id)){
                        System.out.println("ID matched..");
                        chats[cindex][i]= null;
                        System.out.println("Message Deleted successfully...");
                        break;
                    }
                }
                        break;
                    case 2:
                        System.out.println("Deleted all the Messages Successfully..");
                        chats = null;
                        break;
                    case 0:
                        return;
                    default:
                        break;
                }
        }
    }
    else{
        System.out.println("All Messages have been already Deleted!");
    }
}
public void filterMessages(Scanner sc){
    if(chats !=null){
    while(true){
        System.out.println("""
        Enter your choice:
        (1) Filter Messages by Contact: 
        (2) Filter Messages by Status:
        (0) Exit
            """);
        int choice = sc.nextInt();
        sc.nextLine();
        
        switch(choice){
            case 1: 
                Person send = selectReceiver(sc);
                int cindex = getContactIndex(send);
                if (cindex != -1 && chats[cindex] != null) {
                    System.out.println("Enter your choice: \n1) Delivered Messages..\n2) Seen Messages..");
                    int statusChoice = sc.nextInt();
                    sc.nextLine();
                    boolean found = false; // Flag to track if any messages match the filter
                    for (int i = 0; i < chatIndex[cindex]; i++) {  // Loop through actual messages
                        if (chats[cindex][i] != null) {
                            if (statusChoice == 1 && !chats[cindex][i].isStatus()) {
                                // Delivered but not seen (status == false)
                                System.out.println("\n" + chats[cindex][i]);
                                found = true;
                            } else if (statusChoice == 2 && chats[cindex][i].isStatus()) {
                                // Seen messages (status == true)
                                System.out.println(chats[cindex][i]+"\n");
                                found = true;
                            }
                        }
                    }
                    
                    // If no messages match the criteria, print a message
                    if (!found) {
                        System.out.println("\nNo matching messages found..\n");
                    }
                } else {
                    System.out.println("Contact not found or no messages available.");
                }
                break;
                
            case 2:
                System.out.println("Enter your choice: \n1) Delivered Messages..\n2) Seen Messages..");
                int statusChoice1 = sc.nextInt();
                sc.nextLine();
                
                boolean foundInAll = false; // Track if any messages match the filter
                
                for (int i = 0; i < contacts.length; i++) {
                    if (chats[i] != null) {
                        for (int j = 0; j < chatIndex[i]; j++) {
                            if (chats[i][j] != null) {
                                if (statusChoice1 == 1 && !chats[i][j].isStatus()) {
                                    // Delivered but not seen
                                    System.out.println("\n" + chats[i][j]);
                                    foundInAll = true;
                                } else if (statusChoice1 == 2 && chats[i][j].isStatus()) {
                                    // Seen messages
                                    System.out.println(chats[i][j]+"\n");
                                    foundInAll = true;
                                }
                            }
                        }
                    }
                }
                
                if (!foundInAll) {
                    System.out.println("\nNo matching messages found..\n");
                }
                break;
                
            case 0:
                return;
                
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
else{
    System.out.println("There are no messages...");
}
}

public Person selectReceiver(Scanner sc){
    System.out.println("Select Receiver from your contact list: ");
    for(int k = 0; k<contacts.length; k++){
        if(contacts[k]!=null)
        System.out.println((k+1)+" "+contacts[k].getName());
    }
    int sender = sc.nextInt();
    sc.nextLine();
    return contacts[sender-1];
}
public void sortAndDisplayMessages() {
    for (int i = 0; i < contacts.length; i++) {
        if (chats[i] != null && chatIndex[i] > 0) {
            // Sort messages for this contact based on sentTime in descending order
            Arrays.sort(chats[i], 0, chatIndex[i], new Comparator<Sms>() {
                @Override
                public int compare(Sms sms1, Sms sms2) {
                    // Assuming getSentTime() returns the LocalDateTime of the message
                    return sms2.getSentTime().compareTo(sms1.getSentTime());
                }
            });

            // Display sorted messages
            System.out.println("Messages for " + contacts[i].getName() + ":");
            for (int j = 0; j < chatIndex[i]; j++) {
                if (chats[i][j] != null) {
                    System.out.println(chats[i][j]);
                    System.out.println("********************");
                }
            }
        }
    }
}

//addig default receivers
public void addReceiver(){
    contacts[0]= new Person("Maheen Fatima", "03248760982", "maheen@gmail.com");
    contacts[1]= new Person("Fatima", "03248765409", "fatima@gmail.com");
    contacts[2]= new Person("Amna", "03476129873", "amna@gmail.com");
    contacts[3]= new Person("Tehreem", "03256656554", "tehreem@gmail.com");
    contacts[4]= new Person("Addullah", "03156454554", "abdullah@gmail.com");
    contacts[5]= new Person("Ali", "03198208372", "ali@gmail.com");
    contacts[6]= new Person("Muhammad Hassan", "03912983542", "hassan@gmail.com");
    contacts[7]= new Person("Bilal", "03287691098", "bilal@gmail.com");
    contacts[8]= new Person("Yahya", "03198576390", "yahya@gmail.com");
    contacts[9]= new Person("Muhammad", "03120982234", "muhammad@gmail.com");
}

}
