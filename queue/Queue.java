package queue; // Declares the package name

public class Queue { // Declares a public class named Queue
    private static final int MAX_SIZE = 100; // Declares a private constant integer variable MAX_SIZE with value 100
    private int[] array; // Declares a private integer array variable array
    private int head; // Declares a private integer variable head
    private int tail; // Declares a private integer variable tail
    private int size; // Declares a private integer variable size

    public Queue() { // Declares a public constructor method Queue without parameters
        array = new int[MAX_SIZE]; // Initializes the array with size MAX_SIZE
        head = 0; // Initializes the head pointer to 0
        tail = 0; // Initializes the tail pointer to 0
        size = 0; // Initializes the size to 0
    }

    public boolean isEmpty() { // Declares a public method isEmpty which returns a boolean value
        return size == 0; // Returns true if the size is equal to 0, indicating the queue is empty
    }

    public boolean isFull() { // Declares a public method isFull which returns a boolean value
        return size == MAX_SIZE; // Returns true if the size is equal to MAX_SIZE, indicating the queue is full
    }

    public int size() { // Declares a public method size which returns an integer value
        return size; // Returns the current size of the queue
    }

    public void enqueue(int data) { // Declares a public method enqueue which takes an integer parameter data
        if (isFull()) { // Checks if the queue is full
            System.out.println("Queue is full. Cannot enqueue"); // Prints a message if the queue is full
            return; // Exits the method
        }

        array[tail] = data; // Inserts the data at the tail of the queue
        tail = (tail + 1) % MAX_SIZE; // Updates the tail pointer to the next position (circular array)
        size++; // Increases the size of the queue
    }

    public int dequeue() { // Declares a public method dequeue which returns an integer value
        if (isEmpty()) { // Checks if the queue is empty
            System.out.println("Queue is empty. Cannot dequeue"); // Prints a message if the queue is empty
            return -1; // Returns -1 to indicate an error
        }

        int data = array[head]; // Retrieves the data at the head of the queue
        head = (head + 1) % MAX_SIZE; // Updates the head pointer to the next position (circular array)
        size--; // Decreases the size of the queue
        return data; // Returns the dequeued data
    }

    public int peek() { // Declares a public method peek which returns an integer value
        if (isEmpty()) { // Checks if the queue is empty
            System.out.println("Queue is empty. Cannot peek"); // Prints a message if the queue is empty
            return -1; // Returns -1 to indicate an error
        }
        return array[head]; // Returns the data at the head of the queue without removing it
    }

    public void display() { // Declares a public method display which does not return a value
        if (isEmpty()) { // Checks if the queue is empty
            System.out.println("Queue is empty. Cannot display"); // Prints a message if the queue is empty
            return; // Exits the method
        }

        System.out.println("Queue element : "); // Prints a message indicating the start of the queue elements
        int index = head; // Initializes an index variable to the head of the queue
        for (int i = 0; i < size; i++) { // Iterates through the queue elements
            System.out.println(array[index]); // Prints the data at the current index
            index = (index + 1) % MAX_SIZE; // Updates the index to the next position (circular array)
        }
        System.err.println(); // Prints a newline character after displaying all elements
    }
}
