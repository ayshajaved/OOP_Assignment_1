import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        SmsApp app = new SmsApp();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("""
                **********************************
                Welcome to the Smart Messaging app
                **********************************
            
            Enter your choice:
            (1) To Send Messages
            (2) Display Messages
            (3) Delete Messages
            (4) Filter Messages
            (5) Add Contact
            (6) Sort Messages
            (0) Exit
                """);
                int choice = sc.nextInt();
            sc.nextLine();
                switch(choice){
                    case 1: 
                        app.sendMessage(sc);
                        break;
                    case 2:
                        app.displayMessages(sc);
                        break; 
                    case 3:
                        app.deleteMessage(sc);
                        break;
                    case 4:
                        app.filterMessages(sc);
                        break;
                    case 5:
                        app.addContact(sc);
                        break;
                    case 6:
                        app.sortAndDisplayMessages();
                        break;
                    case 0:
                        sc.close();
                        System.exit(0);
                    default:
                        break;
                }
            }
        }
}
