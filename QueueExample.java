import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("A");
        queue.add("B");
        queue.add("C");

        // Displaying queue
        System.out.println("Queue: " + queue);  // [A, B, C]

        // Removing element
        String removed = queue.remove();        // removes "A"
        System.out.println("Removed: " + removed);
        System.out.println("After removal: " + queue);  // [B, C]

        // Peeking at head
        String head = queue.peek();             // returns "B"
        System.out.println("Head: " + head);

        // Polling
        queue.poll(); // removes "B"
        System.out.println("Queue after poll: " + queue); // [C]
    }
}
