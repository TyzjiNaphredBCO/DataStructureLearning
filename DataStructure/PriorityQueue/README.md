## Question:

Same question with [queue](../Queue/README.md) but different usage.

**Example Usage:**

```java
System.out.println("Selected queue is empty? "+ supportSystem.isQueueEmpty()); // Output true if queue is empty
System.out.println("Current Ticket: "+ supportSystem.processNextTicket()); // Output ticket2 details
System.out.println("Next ticket: "+ supportSystem.peekNextTicket()); // Output next ticket in priority
System.out.println("Size of ticket queue: "+ supportSystem.getQueueSize()); // Output queue size
System.out.println("Current Ticket: "+ supportSystem.processNextTicket()); // Output ticket1 details
```

**Requirements:**
- Use `PriorityQueue<Map<String, Object>>` for managing the tickets.
- Handle the priority insertion for high-priority tickets.
