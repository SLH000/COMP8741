import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class WombatVetClinic {
    public static void main(String[] args) {
        Queue<Wombat> wombatQueue = new PriorityQueue<>();
        try {
            wombatQueue.add(new Wombat("Fluffy", 5, 10.5));
            wombatQueue.add(new Wombat("Socks", 10, 11.3));
            wombatQueue.add(new Wombat("Barry", 10, 10.8));
            wombatQueue.add(new Wombat("Jobe", 3, 12.0));
            wombatQueue.add(new Wombat("Ginger", 15, 3.2));
        } catch (SeverityOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        System.out.println(wombatQueue);
        while (!wombatQueue.isEmpty()) {
            System.out.println(wombatQueue.poll());
        }
    }
}