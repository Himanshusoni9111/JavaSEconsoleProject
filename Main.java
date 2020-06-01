package Practice;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("8770906917");

    public static void main(String[] args) {
        // write your code here
        boolean quit = false;
        startPhone();
        printAction();
        while (!quit) {
            System.out.println("\n Enter action form below");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    quit = true;
                    System.out.println("System shut down");
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;

            }

        }

    }

    public static void startPhone() {
        System.out.println("mobile Phone started.");
    }

    public static void printAction() {
        System.out.println("\n Available Actions: \npress");
        System.out.println("0:- to shutDown\n" +
                "1:- to print Contact\n" +
                "2:- to add new contacts\n" +
                "3:- to update existing contacts\n" +
                "4:- to remove contacts\n" +
                "5:- to query existing contacts\n" +
                "6:- to print a list of available Actions\n");
        System.out.println("Choose your action");
    }

    private static void addContact() {
        System.out.println("Enter new contact name:- ");
        String name = scanner.nextLine();
        System.out.println("Enter new number :- ");
        String number = scanner.nextLine();
        Contact newcontact = Contact.createContact(name, number);
        if (mobilePhone.addNewcontact(newcontact)) {
            System.out.println("New contact added, name:= " + name + ",phone = " + number);
        }
        else
            {
            System.out.println("cannot add " + name + " already on phone");
        }
    }

    static private void updateContact() {
        System.out.println("Enter the name you want to update: \r");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.query(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("enter the Contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact Phone Number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.modifycontact(existingContactRecord, newContact)) {
            System.out.println("Successfully Updated ");
        } else {
            System.out.println("Error in updating records");
        }

    }

    private static void removeContact() {
        System.out.println("Enter the name you want to remove: \r");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.query(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removecontact(existingContactRecord)) {
            System.out.println("Successfull deleted");
        } else {
            System.out.println("Error in deleting Contact");
        }

    }

    private static void queryContact() {
        System.out.println("Enter the name you want to query: \r");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.query(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Name :" + existingContactRecord.getName() + "Contact: " + existingContactRecord.getNumber());
    }
}