
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

        System.out.println("Selected queue is empty? "+ supportSystem.isQueueEmpty(false, 1)); // Output true if queue is empty
        System.out.println("Current Ticket: "+ supportSystem.processNextTicket()); // Output ticket2 details
        System.out.println("Next ticket: "+ supportSystem.peekNextTicket()); // Output next ticket in priority
        System.out.println(supportSystem.isQueueEmpty(true)); // Output false if queue is empty
        System.out.println("Current Ticket: "+ supportSystem.processNextTicket()); // Output ticket1 details
    }
}

class SupportTicketSystem{
    private Queue<Map<String, Object>> firstQueue; // First priority queue
    private Queue<Map<String, Object>> secondQueue; // Second priority queue
    private Queue<Map<String, Object>> thirdQueue; // Thrid priority queue
    private Map<String,Object> currentTicket; // Tracking current queue

    public SupportTicketSystem(){
        // Initialize the queues
        firstQueue = new LinkedList<>(); 
        secondQueue = new LinkedList<>(); 
        thirdQueue = new LinkedList<>(); 
        currentTicket = null; // No ticket currenly being process
    }

    // Sort the ticket into which queue it should be added
    public void sortPriority(Map<String, Object> ticket){
        Integer ticketPriority = (Integer) ticket.get("priority");
        switch(ticketPriority){
            case 1 -> firstQueue.offer(ticket);           
            case 2 -> secondQueue.offer(ticket);  
            case 3 -> thirdQueue.offer(ticket);  
            default -> System.out.println("Priority number is not within the system.");
        }
    }

    // Adds a ticket to the queue
    public void addTicket(Map<String, Object> ticket){
        sortPriority(ticket);
    }

    // Process the next ticket in the queue
    public Map<String, Object> processNextTicket(){
        // Checks if queue is not empty, then stores to currentTicket
        if(!firstQueue.isEmpty()){
            currentTicket = firstQueue.poll();
             return currentTicket;
        }else if(!secondQueue.isEmpty()){
            currentTicket = secondQueue.poll();
             return currentTicket;
        }else if(!thirdQueue.isEmpty()){
            currentTicket = thirdQueue.poll();
             return currentTicket;
        }else{
            return null;
        }
    }

    // Return the next ticket without processing it.
    public Map<String, Object> peekNextTicket(){
        if(!firstQueue.isEmpty()) return firstQueue.peek();
        else if(!secondQueue.isEmpty()) return secondQueue.peek();
        else if(!thirdQueue.isEmpty()) return thirdQueue.peek();
        else return null;
    }

    // If checkAll false, checks if there is any tickets left in specific queue
    public boolean isQueueEmpty(Boolean checkAll, int queueNum){
        return switch (queueNum) {
            case 1 -> firstQueue.isEmpty();
            case 2 -> secondQueue.isEmpty();
            case 3 -> thirdQueue.isEmpty();
            default -> false;
        };
    }

    public String isQueueEmpty(Boolean checkAll){
        return "First Queue: "+!firstQueue.isEmpty()+
        "\nSecond Queue: "+!secondQueue.isEmpty()+
        "\nThird Queue: "+!thirdQueue.isEmpty();
    }
}
