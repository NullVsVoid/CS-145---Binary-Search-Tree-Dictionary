/**
 * Name: Caiden Sanders
 * Class: CS 145
 * Lab: Lab 6 - Binary Search Tree Dictionary
 * Date: March 15, 2024
 * Purpose: This class defines the structure of a node used in a binary search
 *          tree for a dictionary application. Each node represents a contact
 *          with fields for personal information and links to children nodes.
 */
public class Node {
    private String firstName;
    private String lastName; // Acts as primary key for the dictionary
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String phone;
    private Node left;
    private Node right;
  
    /**
     * Constructor for a Node object. Initializes a node with contact
     * information.
     *
     * @param firstName The first name of the contact.
     * @param lastName  The last name of the contact, serving as primary key.
     * @param address   The street address of the contact.
     * @param city      The city of the contact.
     * @param state     The state of the contact.
     * @param zip       The zip code of the contact.
     * @param email     The email address of the contact.
     * @param phone     The phone number of the contact.
     */
    public Node(String firstName,
        String lastName,
        String address,
        String city,
        String state,
        String zip,
        String email,
        String phone) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.city = city;
      this.state = state;
      this.zip = zip;
      this.email = email;
      this.phone = phone;
    }
  
    /**
     * Gets the first name of the contact.
     *
     * @return The first name of the contact.
     */
    public String getFirstName() {
      return firstName;
    }
  
    /**
     * Gets the last name of the contact.
     *
     * @return The last name of the contact.
     */
    public String getLastName() {
      return lastName;
    }
  
    /**
     * Gets the address of the contact.
     *
     * @return The address of the contact.
     */
    public String getAddress() {
      return address;
    }
  
    /**
     * Gets the city of the contact.
     *
     * @return The city of the contact.
     */
    public String getCity() {
      return city;
    }
  
    /**
     * Gets the state of the contact.
     *
     * @return The state of the contact.
     */
    public String getState() {
      return state;
    }
  
    /**
     * Gets the zipcode of the contact.
     *
     * @return The zipcode of the contact.
     */
    public String getZip() {
      return zip;
    }
  
    /**
     * Gets the email address of the contact.
     *
     * @return The email address of the contact.
     */
    public String getEmail() {
      return email;
    }
  
    /**
     * Gets the phone number of the contact.
     *
     * @return The phone number of the contact.
     */
    public String getPhone() {
      return phone;
    }
  
    /**
     * Gets the node on the left branch.
     *
     * @return The node on the left branch.
     */
    public Node getLeft() {
      return left;
    }
  
    /**
     * Gets the node on the right branch.
     *
     * @return The node on the right branch.
     */
    public Node getRight() {
      return right;
    }
  
    /**
     * Sets the first name of the contact.
     *
     * @param firstName The first name to set for the contact.
     */
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
  
    /**
     * Sets the last name of the contact.
     *
     * @param lastName The last name to set for the contact.
     */
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
  
    /**
     * Sets the address of the contact.
     *
     * @param address The address to set for the contact.
     */
    public void setAddress(String address) {
      this.address = address;
    }
  
    /**
     * Sets the city of the contact.
     *
     * @param city The city to set for the contact.
     */
    public void setCity(String city) {
      this.city = city;
    }
  
    /**
     * Sets the state of the contact.
     *
     * @param state The state to set for the contact.
     */
    public void setState(String state) {
      this.state = state;
    }
  
    /**
     * Sets the zipcode of the contact.
     *
     * @param zip The zipcode to set for the contact.
     */
    public void setZip(String zip) {
      this.zip = zip;
    }
  
    /**
     * Sets the email address of the contact.
     *
     * @param email The email address to set for the contact.
     */
    public void setEmail(String email) {
      this.email = email;
    }
  
    /**
     * Sets the phone number of the contact.
     *
     * @param phone The phone number to set for the contact.
     */
    public void setPhone(String phone) {
      this.phone = phone;
    }
  
    /**
     * Sets the node on the left branch.
     *
     * @param left The node to place on the left branch.
     */
    public void setLeft(Node left) {
      this.left = left;
    }
  
    /**
     * Sets the node on the right branch.
     *
     * @param right The node to place on the right branch
     */
    public void setRight(Node right) {
      this.right = right;
    }
  
    @Override
    public String toString() {
      return "Contact Information:\n" +
          "---------------------\n" +
          "Name: " + firstName + " " + lastName + "\n" +
          "Address: " + address + ", " + city + ", " + state + " " + zip + "\n" +
          "Email: " + email + "\n" +
          "Phone: " + phone + "\n";
    }
  }