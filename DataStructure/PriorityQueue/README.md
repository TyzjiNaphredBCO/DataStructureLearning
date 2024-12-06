## Question:

Same question with [queue](../Queue/README.md) but different usage.

**Example Usage:**

```java
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
```

**Requirements:**
- Use `PriorityQueue<Map<String, Object>>` for managing the tickets.
- Handle the priority insertion for high-priority tickets.
