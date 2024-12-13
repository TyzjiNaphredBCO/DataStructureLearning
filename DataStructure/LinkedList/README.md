### Problem: Implement a Custom LinkedList in Java

**Question:**
Create a custom `MyLinkedList` class in Java that implements a singly linked list. The class should support the following operations:

1. **Add** a new element at the end of the list.
2. **Add at Index**: Add a new element at a specific index.
3. **Remove** an element by its value.
4. **Print** all elements in the list.

Write a program to demonstrate these functionalities.

---

**Example Usage:**

```java
public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.print(); // Output: 10 -> 20 -> 30

        // Add element at index
        list.addAtIndex(1, 15);
        list.print(); // Output: 10 -> 15 -> 20 -> 30

        // Remove an element
        list.remove(20);
        list.print(); // Output: 10 -> 15 -> 30
    }
}
```

---

**Requirements:**

1. **Add Method:**  
   - Input: `add(int data)`
   - Adds a new node with the given data to the end of the list.

2. **Add at Index Method:**  
   - Input: `addAtIndex(int index, int data)`  
   - Adds a new node with the given data at the specified index.  
   - If the index is out of bounds, throw an `IndexOutOfBoundsException`.

3. **Remove Method:**  
   - Input: `remove(int data)`  
   - Removes the first occurrence of the node with the specified data.  
   - If the data is not found, print a message: "Element not found."

4. **Print Method:**  
   - Input: `print()`  
   - Outputs the linked list elements in the format: `data1 -> data2 -> ...`

5. No built-in Java Collections classes (like `LinkedList`) should be used.

---

**Hints:**

1. Define a private inner class `Node` with two attributes: `data` (int) and `next` (Node).
2. Use a `head` pointer to track the start of the list.
3. For `add(int data)`, traverse the list until you find the last node and attach the new node there.
4. For `addAtIndex(int index, int data)`, keep track of the current index while traversing.
5. For `remove(int data)`, keep track of the previous node to re-link nodes during deletion.
6. For `print()`, start at the `head` and iterate through all nodes, printing their values.

---
