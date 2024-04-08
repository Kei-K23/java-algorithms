package hashMap;

import java.util.LinkedList;

public class HashMap<K, V> { // Declares a generic class named HashMap with type parameters K and V
    private static final int DEFAULT_CAPACITY = 10; // Declares a private constant integer variable DEFAULT_CAPACITY
                                                    // with value 10
    private LinkedList<Entry<K, V>>[] buckets; // Declares a private array of linked lists of type Entry with type
                                               // parameters K and V
    private int size; // Declares a private integer variable size to keep track of the number of
                      // elements in the hash map

    public HashMap() { // Declares a public constructor method HashMap without parameters
        this(DEFAULT_CAPACITY); // Invokes the other constructor with the default capacity
    }

    public HashMap(int cap) { // Declares a public constructor method HashMap with an integer parameter cap
        this.buckets = new LinkedList[cap]; // Initializes the buckets array with the specified capacity
        this.size = 0; // Initializes the size to 0
    }

    public void put(K key, V value) { // Declares a public method put which takes key-value pairs as parameters
        if (key == null) { // Checks if the key is null
            throw new IllegalArgumentException("Key cannot be null"); // Throws an IllegalArgumentException if the key
                                                                      // is null
        }

        int index = hash(key); // Calculates the index for the key using the hash function
        if (buckets[index] == null) { // Checks if the bucket at the calculated index is null
            buckets[index] = new LinkedList<>(); // Initializes a new linked list at the calculated index if it's null
        }

        for (Entry<K, V> entry : buckets[index]) { // Iterates through the entries in the linked list at the calculated
                                                   // index
            if (entry.key.equals(key)) { // Checks if the current entry's key equals the specified key
                entry.value = value; // Updates the value of the entry if the key exists
                return; // Exits the method
            }
        }

        buckets[index].add(new Entry<>(key, value)); // Adds a new entry to the linked list if the key doesn't exist
        size++; // Increments the size of the hash map
    }

    public V get(K key) { // Declares a public method get which retrieves the value associated with the
                          // specified key
        int index = hash(key); // Calculates the index for the key using the hash function
        LinkedList<Entry<K, V>> bucket = buckets[index]; // Retrieves the linked list (bucket) at the calculated index

        if (bucket != null) { // Checks if the bucket is not null
            for (Entry<K, V> entry : bucket) { // Iterates through the entries in the bucket
                if (entry.key.equals(key)) { // Checks if the current entry's key equals the specified key
                    return entry.value; // Returns the value of the entry if the key is found
                }
            }
        }
        return null; // Returns null if the key is not found
    }

    public void remove(K key) { // Declares a public method remove which removes the entry associated with the
                                // specified key
        int index = hash(key); // Calculates the index for the key using the hash function
        LinkedList<Entry<K, V>> bucket = buckets[index]; // Retrieves the linked list (bucket) at the calculated index

        if (bucket != null) { // Checks if the bucket is not null
            for (Entry<K, V> entry : bucket) { // Iterates through the entries in the bucket
                if (entry.key.equals(key)) { // Checks if the current entry's key equals the specified key
                    bucket.remove(entry); // Removes the entry from the bucket
                    size--; // Decrements the size of the hash map
                    return; // Exits the method
                }
            }
        }
    }

    public boolean containsKey(K key) { // Declares a public method containsKey which checks if the hash map contains
                                        // the specified key
        return get(key) != null; // Returns true if the get method returns a non-null value for the specified
                                 // key, otherwise returns false
    }

    public int size() { // Declares a public method size which returns the number of key-value pairs in
                        // the hash map
        return size; // Returns the size of the hash map
    }

    public int hash(K key) { // Declares a public method hash which calculates the hash code for the
                             // specified key and maps it to an index
        return Math.abs(key.hashCode() % buckets.length); // Returns the absolute value of the hash code modulo the
                                                          // length of the buckets array
    }

    private static class Entry<K, V> { // Declares a private static nested class named Entry with type parameters K and
                                       // V
        K key; // Declares a variable to store the key
        V value; // Declares a variable to store the value

        public Entry(K key, V value) { // Declares a public constructor for the Entry class with key and value
                                       // parameters
            this.key = key; // Initializes the key
            this.value = value; // Initializes the value
        }

    }
}
