/**
 * Name: Caiden Sanders
 * Class: CS 145
 * Lab: Lab 6 - Binary Search Tree Dictionary
 * Date: March 15, 2024
 * Purpose: Dictionary class for managing a dictionary using a binary search
 * 			tree. This class facilitates operations such as insert, delete,
 * 			modify, and search within a directory of contacts. Implemented as
 * 			a binary search tree to maintain alphabetical order of contacts by
 * 			last name.
 */
public class Dictionary {
	Node head;
  
	/**
	 * Inserts a new contact into the dictionary. Contacts are stored in a
	 * binary search tree, ordered alphabetically by last name.
	 *
	 * @param firstName The first name of the contact.
	 * @param lastName  The last name of the contact, used as primary key.
	 * @param address   The contact's street address.
	 * @param city      The contact's city.
	 * @param state     The contact's state.
	 * @param zip       The contact's zip code.
	 * @param email     The contact's email address.
	 * @param phone     The contact's phone number.
	 */
	public void insert(String firstName,
		String lastName,
		String address,
		String city,
		String state,
		String zip,
		String email,
		String phone) {
	  Node newNode = new Node(firstName,
		  lastName,
		  address,
		  city,
		  state,
		  zip,
		  email,
		  phone);
	  if (head == null) {
		head = newNode;
	  } else {
		Node current = head;
		Node parent;
		while (true) {
		  parent = current;
		  if (lastName.compareTo(current.getLastName()) < 0) {
			current = current.getLeft();
			if (current == null) {
			  parent.setLeft(newNode);
			  return;
			}
		  } else {
			current = current.getRight();
			if (current == null) {
			  parent.setRight(newNode);
			  return;
			}
		  }
		}
	  }
	}
  
	/**
	 * Removes a contact from the dictionary based on the last name.
	 *
	 * @param lastName The last name of the contact to remove.
	 */
	public void remove(String lastName) {
	  Node current = head;
	  Node parent = head;
	  boolean isLeftChild = true;
	  while (current.getLastName().compareTo(lastName) != 0) {
		parent = current;
		if (lastName.compareTo(current.getLastName()) < 0) {
		  isLeftChild = true;
		  current = current.getLeft();
		} else {
		  isLeftChild = false;
		  current = current.getRight();
		}
		if (current == null) {
		  return;
		}
	  }
	  if (current.getLeft() == null && current.getRight() == null) {
		if (current == head) {
		  head = null;
		} else if (isLeftChild) {
		  parent.setLeft(null);
		} else {
		  parent.setRight(null);
		}
	  } else if (current.getRight() == null) {
		if (current == head) {
		  head = current.getLeft();
		} else if (isLeftChild) {
		  parent.setLeft(current.getLeft());
		} else {
		  parent.setRight(current.getLeft());
		}
	  } else if (current.getLeft() == null) {
		if (current == head) {
		  head = current.getRight();
		} else if (isLeftChild) {
		  parent.setLeft(current.getRight());
		} else {
		  parent.setRight(current.getRight());
		}
	  } else {
		Node successor = getSuccessor(current);
		if (current == head) {
		  head = successor;
		} else if (isLeftChild) {
		  parent.setLeft(successor);
		} else {
		  parent.setRight(successor);
		}
		successor.setLeft(current.getLeft());
	  }
	}
  
	/**
	 * Modifies the details of an existing contact found by last name.
	 *
	 * @param lastName  The last name of the contact to find and modify.
	 * @param firstName The new first name.
	 * @param address   The new address.
	 * @param city      The new city.
	 * @param state     The new state.
	 * @param zip       The new zip code.
	 * @param email     The new email address.
	 * @param phone     The new phone number.
	 * @return The modified Node, or null if not found.
	 */
	public Node modify(String lastName,
		String firstName,
		String address,
		String city,
		String state,
		String zip,
		String email,
		String phone) {
	  Node found = find(lastName);
	  if (found != null) {
		found.setFirstName(firstName);
		found.setAddress(address);
		found.setCity(city);
		found.setState(state);
		found.setZip(zip);
		found.setEmail(email);
		found.setPhone(phone);
	  }
	  return found;
	}
  
	/**
	 * Searches for a contact by last name.
	 *
	 * @param lastName The last name of the contact to find.
	 * @return The found Node, or null if the contact does not exist.
	 */
	public Node find(String lastName) {
	  Node current = head;
	  int diff = lastName.compareTo(current.getLastName());
	  while (current != null) {
		if (diff == 0) {
		  return current;
		} else if (diff < 0) {
		  current = current.getLeft();
		} else {
		  current = current.getRight();
		}
	  }
	  return null;
	}
  
	/**
	 * Searches for the successor of a specified node in the dictionary. The
	 * successor is the smallest node in the right subtree of the given node,
	 * used during the deletion of a node with two children.
	 *
	 * @param delNode The node to find the successor for.
	 * @return The successor node.
	 */
	public Node getSuccessor(Node delNode) {
	  Node successorParent = delNode;
	  Node successor = delNode;
	  Node current = delNode.getRight();
	  while (current != null) {
		successorParent = successor;
		successor = current;
		current = current.getLeft();
	  }
	  if (successor != delNode.getRight()) {
		successorParent.setLeft(successor.getRight());
		successor.setRight(delNode.getRight());
	  }
	  return successor;
	}
  
	/**
	 * Performs an in-order traversal of the binary search tree. This method
	 * prints the contacts in alphabetical order based on last name, visiting
	 * the left subtree, then the current node, and finally the right subtree.
	 *
	 * @param localNode The current node to process during the traversal.
	 */
	public void inOrder(Node localNode) {
	  if (localNode != null) {
		inOrder(localNode.getLeft());
		System.out.println(localNode);
		inOrder(localNode.getRight());
	  }
	}
  
	/**
	 * Performs a pre-order traversal of the binary search tree. This method
	 * prints the contacts starting from the root, then traverses the left
	 * subtree followed by the right subtree.
	 *
	 * @param localNode The current node to process during the traversal.
	 */
	public void preOrder(Node localNode) {
	  if (localNode != null) {
		System.out.println(localNode);
		preOrder(localNode.getLeft());
		preOrder(localNode.getRight());
	  }
	}
  
	/**
	 * Performs a post-order traversal of the binary search tree. This method
	 * visits the left and right subtrees before printing the contacts at the
	 * current node.
	 *
	 * @param localNode The current node to process during the traversal.
	 */
	public void postOrder(Node localNode) {
	  if (localNode != null) {
		postOrder(localNode.getLeft());
		postOrder(localNode.getRight());
		System.out.println(localNode);
	  }
	}
  }