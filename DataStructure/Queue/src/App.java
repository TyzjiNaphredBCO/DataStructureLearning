
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

        System.out.println(supportSystem.processNextTicket()); // Should output ticket1 details
        System.out.println(supportSystem.processNextTicket()); // Should output ticket2 details
    }
}

class SupportTicketSystem{
    private Queue<Map<String, Object>> mainQueue; // Main ticket queue
    private Map<String,Object> currentTicket; // Tracking current queue

    public SupportTicketSystem(){
        mainQueue = new LinkedList<>(); // Initialize the queue
        currentTicket = null; // No ticket currenly being process
    }

    // Adds a ticket to the queue, handling high-priority tickets
    public void addTicket(Map<String, Object> ticket){
        Integer priority = (Integer) ticket.get("priority");

        if(priority == 1 && currentTicket != null){
            // If there's a current ticket, process it first
            Queue<Map<String, Object>> tempQueue = new LinkedList<>();
            tempQueue.offer(currentTicket); // Keep the current ticket at the front
            tempQueue.offer(ticket); // Add prioritize ticket behind current ticket

            // Move all tickets from the main queue to the temp queue
            while(!mainQueue.isEmpty()){
                tempQueue.offer(mainQueue.poll());
            }

            // Reassigned the modified queue back to the main queue
            mainQueue = tempQueue; 
            return;
        }

        // Not priority tickets run instructions below
        mainQueue.offer(ticket);
    }

    // Process the next ticket in the queue
    public Map<String, Object> processNextTicket(){
        if(mainQueue.isEmpty()){
            return null;
        }

        currentTicket = mainQueue.poll();
        return currentTicket;
    }

    // Return the next ticket without processing it.
    public Map<String, Object> peekNextTicket(){
        return mainQueue.peek();
    }

    // Checks if there is any tickets left in the queue
    public boolean isQueueEmpty(){
        return mainQueue.isEmpty();
    }
}
