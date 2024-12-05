
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        SupportTicketSystem supportSystem = new SupportTicketSystem();

        Map<String, Object> ticket1 = new HashMap<>();
        ticket1.put("ticketId", "001");
        ticket1.put("priority", 2);
        ticket1.put("message", "Issue with logging in.");

        Map<String, Object> ticket2 = new HashMap<>();
        ticket2.put("ticketId", "002");
        ticket2.put("priority", 1);
        ticket2.put("message", "System down!");

        supportSystem.addTicket(ticket1);
        supportSystem.addTicket(ticket2);

        System.out.println("Selected queue is empty? "+ supportSystem.isQueueEmpty()); // Output true if queue is empty
        System.out.println("Current Ticket: "+ supportSystem.processNextTicket()); // Output ticket2 details
        System.out.println("Next ticket: "+ supportSystem.peekNextTicket()); // Output next ticket in priority
        System.out.println("Size of ticket queue: "+ supportSystem.getQueueSize()); // Output queue size
        System.out.println("Current Ticket: "+ supportSystem.processNextTicket()); // Output ticket1 details
    }
}

class SupportTicketSystem {
    private PriorityQueue<Map<String, Object>> ticketQueue; // Priority queue for tickets
    private Map<String, Object> currentTicket; // Currently processing ticket

    public SupportTicketSystem(){
        ticketQueue = new PriorityQueue<>((t1, t2) ->{
            Integer p1 = (Integer) t1.get("priority");
            Integer p2 = (Integer) t2.get("priority"); 
            return Integer.compare(p2, p2); // lower number less priority, vice-versa
        });
        currentTicket = null;
    }

    // Add ticket directly to priorityQueue
    public void addTicket(Map<String, Object> ticket){
        ticketQueue.offer(ticket);
    }

    // Start processing next ticket
    public Map<String, Object> processNextTicket(){
        currentTicket = ticketQueue.poll();
        return currentTicket;
    }

    // Show next ticket without removing
    public Map<String, Object> peekNextTicket(){
        return ticketQueue.peek();
    }

    // Determine if no more tickets
    public boolean isQueueEmpty(){
        return ticketQueue.isEmpty();
    }

    // Determine the size of queue
    public int getQueueSize(){
        return ticketQueue.size();
    }
}
