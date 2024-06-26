/**
* Name: Caiden Sanders
* Class: CS 145
* Lab: Lab 6 - Binary Search Tree Dictionary
* Date: March 15, 2024
* Purpose: Entry point for the Binary Ssearch Tree Dictionary application.
*          This class handles user interaction, allowing the user to add,
*          delete, modify, and look up records in a dictionary implemented
*          as a binary search tree.
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);
  private static Dictionary dictionary = new Dictionary();

  /**
   * Main method to run the application. Displays a menu and processes user
   * input.
   *
   * @param args Command-line arguments (not used).
   */
  public static void main(String[] args) {
    boolean running = true;
    while (running) {
      System.out.println("\nMenu:");
      System.out.println("1. Add a record");
      System.out.println("2. Delete a record");
      System.out.println("3. Modify a record");
      System.out.println("4. Lookup a record");
      System.out.println("5. Display all records");
      System.out.println("6. Exit");
      System.out.print("Enter your choice: ");
      try {
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
          case 1:
            addRecord();
            break;
          case 2:
            deleteRecord();
            break;
          case 3:
            modifyRecord();
            break;
          case 4:
            lookupRecord();
            break;
          case 5:
            displayRecords();
            break;
          case 6:
            running = false;
            break;
          default:
            System.out.println("Invalid choice. Please enter a number " +
                "between 1 and 6.");
        }
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.next();
      }
    }
  }

  /**
   * Adds a new record to the dictionary. Prompts the user to enter the
   * details fo the record (first name, last name, address, city, state, zip,
   * email, and phone number) and then inserts the record into the dictionary.
   */
  private static void addRecord() {
    System.out.println("\nEnter the following details:");
    System.out.print("First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Last Name: ");
    String lastName = scanner.nextLine();
    System.out.print("Address: ");
    String address = scanner.nextLine();
    System.out.print("City: ");
    String city = scanner.nextLine();
    System.out.print("State: ");
    String state = scanner.nextLine();
    System.out.print("Zip: ");
    String zip = scanner.nextLine();
    System.out.print("Email: ");
    String email = scanner.nextLine();
    System.out.print("Phone: ");
    String phone = scanner.nextLine();
    dictionary.insert(firstName,
        lastName,
        address,
        city,
        state,
        zip,
        email,
        phone);
    System.out.println("Record added successfully.");
  }

  /**
   * Deletes a record from the dictionary. Prompts the user to enter the last
   * name of the record to be deleted. If the record is found, it displays the
   * record details and asks for confirmation to delete. If confirmed, the
   * record is removed from the dictionary.
   */
  private static void deleteRecord() {
    System.out.print("\nEnter the last name of the record you want to delete: ");
    String lastName = scanner.nextLine();
    Node found = dictionary.find(lastName);
    if (found != null) {
      System.out.println("Found record: " + found.toString());
      System.out.print("Are you sure you want to delete this record? (y/n): ");
      String confirm = scanner.nextLine();
      if (confirm.equalsIgnoreCase("y"))
        dictionary.remove(lastName);
      else
        System.out.println("Deletion canceled.");
    } else {
      System.out.println("Record not found.");
    }
  }

  /**
   * Modifies an existing record in the dictionary. Prompts the user to enter
   * the last name of the record to be modified, and then the new details for
   * the record. If the record is found, it is updated with the new details.
   * If not found, a message is displayed.
   */
  private static void modifyRecord() {
    System.out.print("\nEnter the last name of the record you want to modify: ");
    String lastName = scanner.nextLine();
    System.out.println("Enter the new details:");
    System.out.print("First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Address: ");
    String address = scanner.nextLine();
    System.out.print("City: ");
    String city = scanner.nextLine();
    System.out.print("State: ");
    String state = scanner.nextLine();
    System.out.print("Zip: ");
    String zip = scanner.nextLine();
    System.out.print("Email: ");
    String email = scanner.nextLine();
    System.out.print("Phone: ");
    String phone = scanner.nextLine();
    Node modified = dictionary.modify(lastName,
        firstName,
        address,
        city,
        state,
        zip,
        email,
        phone);
    if (modified != null) {
      System.out.println("Record modified successfully.");
    } else {
      System.out.println("Record not found.");
    }
  }

  /**
   * Looks up a record in the dictionary. Prompts the user to choose a lookup
   * option (pre-order, in-order, or post-order) and then displays the records
   * in the chosen order.
   */
  private static void lookupRecord() {
    System.out.println("\nLookup options:");
    System.out.println("1. Pre-order");
    System.out.println("2. In-order");
    System.out.println("3. Post-order");
    System.out.print("Choose your option: ");
    int choice = scanner.nextInt();
    switch (choice) {
      case 1:
        dictionary.preOrder(dictionary.head);
        break;
      case 2:
        dictionary.inOrder(dictionary.head);
        break;
      case 3:
        dictionary.postOrder(dictionary.head);
        break;
      default:
        System.out.println("Invalid choice.");
    }
  }

  /**
   * Displays all records in the dictionary in in-order.
   */
  private static void displayRecords() {
    System.out.println("\nDisplaying all records in in-order:\n");
    dictionary.inOrder(dictionary.head);
  }
}