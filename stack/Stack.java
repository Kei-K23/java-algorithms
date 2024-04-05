package stack; // Declares the package name

public class Stack { // Declares a public class named Stack
    private static final int MAX_SIZE = 100; // Declares a private constant integer variable MAX_SIZE with value 100
    private int[] array; // Declares a private integer array variable array
    private int top; // Declares a private integer variable top

    public Stack() { // Declares a public constructor method Stack without parameters
        this.array = new int[MAX_SIZE]; // Initializes the array with size MAX_SIZE
        this.top = -1; // Initializes top to -1 indicating an empty stack
    }

    public boolean isEmpty() { // Declares a public method isEmpty which returns a boolean value
        return top == -1; // Returns true if top is equal to -1, indicating the stack is empty
    }

    public boolean isFull() { // Declares a public method isFull which returns a boolean value
        return top == MAX_SIZE; // Returns true if top is equal to MAX_SIZE, indicating the stack is full
    }

    public void push(int data) { // Declares a public method push which takes an integer parameter data
        if (isFull()) { // Checks if the stack is full
            System.err.println("Stack is full. Cannot push"); // Prints a message if the stack is full
            return; // Exits the method
        }
        array[++top] = data; // Increments top and adds the element to the stack
    }

    public int pop() { // Declares a public method pop which returns an integer value
        if (isEmpty()) { // Checks if the stack is empty
            System.err.println("Stack is empty. Cannot pop"); // Prints a message if the stack is empty
            return -1; // Returns -1 to indicate an error
        }
        return array[top--]; // Decrements top and returns the popped element
    }

    public int peek() { // Declares a public method peek which returns an integer value
        if (isEmpty()) { // Checks if the stack is empty
            System.err.println("Stack is empty. Cannot peek"); // Prints a message if the stack is empty
            return -1; // Returns -1 to indicate an error
        }
        return array[top]; // Returns the element at the top of the stack without removing it
    }

    public void display() { // Declares a public method display which does not return a value
        if (isEmpty()) { // Checks if the stack is empty
            System.out.println("Stack is empty. Cannot display"); // Prints a message if the stack is empty
            return; // Exits the method
        }

        System.out.println("Stack element : "); // Prints a message indicating the start of the stack elements

        for (int i = top; i >= 0; i--) { // Iterates through the stack elements
            System.out.println(array[i]); // Prints the element at index i
        }
        System.err.println(); // Prints a newline character after displaying all elements
    }
}
