## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

Here’s a Java question that involves using a `Queue` and a `Map<String, Object>`. The problem tests understanding of queue operations and map manipulations.

---

**Question:** 

You are tasked with implementing a `SupportTicketSystem` for a customer support center. This system will process incoming support tickets in a `Queue`. Each ticket is represented as a `Map<String, Object>`, which contains the following information:

- `"ticketId"`: (String) a unique identifier for each ticket.
- `"priority"`: (Integer) the priority level of the ticket (1 = high, 2 = medium, 3 = low).
- `"message"`: (String) the description of the issue.
  
The tickets need to be processed in the order they arrive unless a high-priority ticket (priority level 1) enters the queue. When a high-priority ticket is added, it should be processed immediately after the current ticket.

Implement the `SupportTicketSystem` class with the following methods:

1. **void addTicket(Map<String, Object> ticket)**: Adds a new ticket to the queue. If it is a high-priority ticket (priority 1), add it immediately after the current ticket.
  
2. **Map<String, Object> processNextTicket()**: Processes the next ticket in the queue and removes it. Returns the ticket details as a `Map<String, Object>`. If there are no tickets, return `null`.

3. **Map<String, Object> peekNextTicket()**: Returns the next ticket to be processed without removing it. If the queue is empty, return `null`.

4. **boolean isEmpty()**: Checks if there are any tickets left in the queue.

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

System.out.println(supportSystem.processNextTicket()); // Should output ticket1 details
System.out.println(supportSystem.processNextTicket()); // Should output ticket2 details
```

**Requirements:**
- Use `Queue<Map<String, Object>>` for managing the tickets.
- Handle the priority insertion for high-priority tickets.
  
**Hints:**
- You might need a helper structure for priority tickets to insert them immediately after the current ticket.
- Consider the appropriate type of `Queue` that allows efficient insertion.
