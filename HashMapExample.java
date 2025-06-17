import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        Map<String, Integer> ages = new HashMap<>();

        // Adding key-value pairs
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);

        // Accessing values using keys
        System.out.println("Alice's age: " + ages.get("Alice")); // Output: Alice's age: 30
        System.out.println("Bob's age: " + ages.get("Bob"));   // Output: Bob's age: 25

        // Checking if a key exists
        if (ages.containsKey("Alice")) {
            System.out.println("Alice is in the map"); // Output: Alice is in the map
        }

        // Iterating through the HashMap
        System.out.println("All entries:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Output:
        // All entries:
        // Alice: 30
        // Bob: 25
        // Charlie: 35

        // Removing an entry
        ages.remove("Bob");

        // Checking the size of the HashMap
        System.out.println("Size of the HashMap: " + ages.size()); // Output: Size of the HashMap: 2

        // Clearing the HashMap
        ages.clear();
        System.out.println("Is the HashMap empty? " + ages.isEmpty()); // Output: Is the HashMap empty? true
    }
}