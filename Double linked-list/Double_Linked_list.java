/**
 * Node
 * Represents a single element in a double linked list.
 */
class Node {
    int data; // Payload or data
    Node prev; // Pointer to the previous node
    Node next; // Pointer to the next node

    /**
     * Constructor to initialize a new node with data.
     * 
     * @param data The data value to be stored in the node.
     */
    public Node(int data) {
        this.data = data;
        this.prev = null; // Initially, the previous pointer is null
        this.next = null; // Initially, the next pointer is null
    }
}

/**
 * DoubleLinkedList
 * Represents a double linked list data structure.
 */
class DoubleLinkedList {
    Node head; // Reference to the head of the list
    Node tail; // Reference to the tail of the list

    /**
     * Constructor to initialize an empty double linked list.
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts a new node with the specified data at the head of the double linked
     * list.
     * 
     * @param data The data value to be inserted.
     */
    public void insertAtHead(int data) {
        Node newNode = new Node(data); // Create a new node with the given data

        if (head == null) { // If the list is empty
            // Set the head and tail to the new node
            this.head = newNode;
            this.tail = newNode;
        } else {
            // Append the new node to the head of the list
            newNode.next = head;
            this.head.prev = newNode;
            this.head = newNode; // Update the head reference
        }
    }

    /**
     * Inserts a new node with the specified data at the tail of the double linked
     * list.
     * 
     * @param data The data value to be inserted.
     */
    public void insertAtTail(int data) {
        Node newNode = new Node(data); // Create a new node with the given data

        if (tail == null) { // If the list is empty
            // Set the head and tail to the new node
            this.head = newNode;
            this.tail = newNode;
        } else {
            // Append the new node to the tail of the list
            newNode.prev = tail;
            this.tail.next = newNode;
            this.tail = newNode; // Update the tail reference
        }
    }

    /**
     * Traverses the double linked list and prints the data values of each node.
     */
    public void traverse() {
        Node current = this.head; // Start from the head of the list

        System.out.println("Double linked list:");
        while (current.next != null) { // Traverse until the end of the list
            System.out.println(current.data); // Print the data of the current node
            current = current.next; // Move to the next node
        }
        System.out.println(current.data); // Print the data of the last node
    }

    /**
     * Traverses the double linked list in reverse order and prints the data values
     * of each node.
     */
    public void traverseInReverse() {
        Node current = this.tail; // Start from the tail of the list

        System.out.println("Double linked list in reverse:");
        while (current.prev != null) { // Traverse until the head of the list
            System.out.println(current.data); // Print the data of the current node
            current = current.prev; // Move to the previous node
        }
        System.out.println(current.data); // Print the data of the head node
    }

    /**
     * Searches for a node with the specified data value in the double linked list.
     * 
     * @param data The data value to search for.
     * @return true if the node with the data value is found, false otherwise.
     */
    public boolean searchNode(int data) {
        Node node = this.head; // Start from the head of the list

        while (node != null && node.data != data) { // Traverse until the end of the list or target data is found
            node = node.next; // Move to the next node
        }

        return node != null; // Return true if the node is found, false otherwise
    }

    /**
     * Deletes the first occurrence of a node with the specified data value from the
     * double linked list.
     * 
     * @param data The data value of the node to be deleted.
     * @return true if the node was found and deleted, false otherwise.
     */
    public boolean delete(int data) {
        Node current = this.head; // Start from the head of the list

        while (current != null) { // Traverse the list
            if (current.data == data) { // If the node with the target data is found
                if (current == this.head) { // If the node to be deleted is the head
                    this.head = this.head.next; // Move the head pointer to the next node
                    if (this.head != null) { // If there are more nodes in the list
                        this.head.prev = null; // Set the previous pointer of the new head to null
                    } else { // If the list becomes empty
                        this.tail = null; // Set both head and tail to null
                    }
                } else if (current == this.tail) { // If the node to be deleted is the tail
                    this.tail = this.tail.prev; // Move the tail pointer to the previous node
                    this.tail.next = null; // Set the next pointer of the new tail to null
                } else { // If the node to be deleted is in the middle of the list
                    current.prev.next = current.next; // Adjust the next pointer of the previous node
                    current.next.prev = current.prev; // Adjust the previous pointer of the next node
                }
                return true; // Node found and deleted
            }
            current = current.next; // Move to the next node
        }
        return false; // Node with the target data not found
    }
}

/**
 * Double_Linked_list
 * Main class to test the DoubleLinkedList implementation.
 */
public class Double_Linked_list {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList(); // Create a new double linked list

        // Insert nodes at the head and tail
        list.insertAtHead(10);
        list.insertAtHead(50);
        list.insertAtHead(70);
        list.insertAtHead(20);
        list.insertAtTail(30);

        list.traverse(); // Print the elements of the double linked list
        list.delete(50); // Delete a node
        list.traverse(); // Print the updated double linked list
    }
}
