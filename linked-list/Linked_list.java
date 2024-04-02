/**
 * Linked_list
 * Implementation for Linked list data structure
 */

/**
 * Node
 * Node represents a element in a list
 */
class Node {
    int data; // payload or data
    Node next; // pointer to next node

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head; // head of the node element
    Node tail; // head of the node element

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            newNode.next = this.head;
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        this.head = newNode;
        if (this.tail == null) {
            this.tail = newNode;
        }
    }

    public void traverse() {
        Node current = head;
        System.out.println("Linked list: ");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        return;
    }

    public void traverseInReverse() {
        System.out.println("Linked list in reverse: ");
        if (this.tail != null) {
            Node current = tail;
            while (current != head) {
                Node prev = head;
                while (prev.next != current) {
                    prev = prev.next;
                }
                System.out.println(current.data);
                current = prev;
            }
            System.out.println(current.data);
        }
    }
}

public class Linked_list {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtTail(30);
        list.insertAtHead(90);

        list.traverseInReverse();
        list.traverse();
    }

}