package linkedList;

/**
 * Node
 * Represents a single element in a linked list.
 */
class Node {
    int data; // Payload or data
    Node next; // Pointer to the next node

    /**
     * Constructor to initialize a new node with data.
     * 
     * @param data The data value to be stored in the node.
     */
    public Node(int data) {
        this.data = data;
        this.next = null; // Initially, the next pointer is null
    }
}

/**
 * LinkedList
 * Represents a linked list data structure.
 */
public class LinkedList {
    Node head; // Reference to the head of the list
    Node tail; // Reference to the tail of the list

    /**
     * Constructor to initialize an empty linked list.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts a new node with the specified data at the tail of the linked list.
     * 
     * @param data The data value to be inserted.
     */
    public void insertAtTail(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (this.head == null) { // If the list is empty
            // Set the head and tail to the new node
            this.head = newNode;
            this.tail = newNode;
        } else {
            // Append the new node to the end of the list
            this.tail.next = newNode;
            this.tail = newNode; // Update the tail reference
        }
    }

    /**
     * Inserts a new node with the specified data at the head of the linked list.
     * 
     * @param data The data value to be inserted.
     */
    public void insertAtHead(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        newNode.next = head; // Set the next pointer of the new node to the current head
        this.head = newNode; // Update the head to point to the new node
        if (this.tail == null) { // If the list was empty
            this.tail = newNode; // Update the tail to point to the new node
        }
    }

    /**
     * Traverses the linked list and prints the data values of each node.
     */
    public void traverse() {
        Node current = head; // Start from the head of the list
        System.out.println("Linked list:");
        while (current != null) { // Traverse until the end of the list
            System.out.println(current.data); // Print the data of the current node
            current = current.next; // Move to the next node
        }
    }

    /**
     * Traverses the linked list in reverse order and prints the data values of each
     * node.
     */
    public void traverseInReverse() {
        System.out.println("Linked list in reverse: ");
        if (this.tail != null) { // Check if the list is not empty
            Node current = tail; // Start from the tail of the list
            while (current != head) { // Traverse until the head of the list is reached
                Node prev = head; // Initialize a pointer to the head of the list
                while (prev.next != current) { // Traverse until the previous node of the current node is found
                    prev = prev.next;
                }
                System.out.println(current.data); // Print the data of the current node
                current = prev; // Move to the previous node
            }
            System.out.println(current.data); // Print the data of the head node (last node in reverse)
        }
    }

    /**
     * Searches for a node with the specified data value in the linked list.
     * 
     * @param data The data value to search for.
     * @return true if the node with the data value is found, false otherwise.
     */
    public boolean searchNode(int data) {
        Node node = head; // Start from the head of the list

        while (node != null && node.data != data) { // Traverse until the end of the list or target data is found
            node = node.next; // Move to the next node
        }

        if (node == null) { // If the end of the list is reached
            return false; // Node with the data value not found
        }

        return true; // Node with the data value found
    }

    /**
     * Deletes the first occurrence of a node with the specified data value from the
     * linked list.
     * 
     * @param data The data value to be deleted.
     * @return true if the node was found and deleted, false otherwise.
     */
    public boolean delete(int data) {
        if (this.head == null) { // If the list is empty
            return false;
        }

        Node node = head;
        if (node.data == data) { // If the node to be deleted is the head
            if (node == tail) { // If there's only one node in the list
                this.head = null; // Set both head and tail to null
                this.tail = null;
            } else {
                head = head.next; // Move the head pointer to the next node
            }
            return true;
        } else {
            while (node.next != null && node.next.data != data) { // Traverse until the node with the target data is
                                                                  // found
                node = node.next;
            }
            if (node.next != null) { // If the node with the target data is found
                if (node.next == tail) { // If the node to be deleted is the tail
                    tail = node; // Update the tail reference
                    tail.next = null;
                } else {
                    node.next = node.next.next; // Skip the node to be deleted
                }
                return true;
            }
            return false; // Node with the target data not found
        }
    }
}
