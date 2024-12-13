### Problem: Implement and Enhance a Java Dynamic Array

**Question:**
You are tasked with creating a custom `DynamicArray` class in Java. This class should emulate the behavior of an array but allow dynamic resizing when elements are added or removed. Additionally, you must implement two new methods: `reverse` and `contains`.

1. **`reverse()`**: Reverses the order of elements in the `DynamicArray`.
2. **`contains(Object data)`**: Returns `true` if the array contains the specified element, otherwise `false`.

You will also need to test your implementation using the main method, demonstrating all core functionalities of the dynamic array.

---

**Example Usage:**

```java
public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(5);

        // Add elements
        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        System.out.println("Array: " + dynamicArray);

        // Reverse the array
        dynamicArray.reverse();
        System.out.println("Reversed Array: " + dynamicArray);

        // Check if an element exists
        System.out.println("Contains 'B': " + dynamicArray.contains("B"));
        System.out.println("Contains 'Z': " + dynamicArray.contains("Z"));

        // Add more elements to exceed initial capacity
        dynamicArray.add("D");
        dynamicArray.add("E");
        dynamicArray.add("F");
        System.out.println("Array after adding more elements: " + dynamicArray);

        // Demonstrate other functionalities
        System.out.println("Size: " + dynamicArray.size);
        System.out.println("Capacity: " + dynamicArray.capacity);
        System.out.println("Is Empty: " + dynamicArray.isEmpty());
    }
}
```

---

**Requirements:**

1. **Dynamic Resizing**:
   - When the `size` exceeds the `capacity`, double the array's capacity.
   - When the `size` is less than one-third of the capacity, shrink the array to half its size.

2. **Methods to Implement**:
   - `add(Object data)`: Adds an element to the end of the array.
   - `reverse()`: Reverses the elements in the array.
   - `contains(Object data)`: Checks if the array contains a specific element.
   - `toString()`: Returns a string representation of the array.
   - Existing methods like `delete`, `search`, `insert`, etc., can remain as they are.

3. **Edge Cases**:
   - Handle operations on an empty array.
   - Ensure the array resizes correctly when adding/removing elements.
   - Handle `null` values in `contains`.

---

**Hints:**

1. **Reversing the Array**:
   - Use a loop to swap the first and last elements, moving toward the center.

   ```java
   for (int i = 0; i < size / 2; i++) {
       Object temp = array[i];
       array[i] = array[size - 1 - i];
       array[size - 1 - i] = temp;
   }
   ```

2. **Checking for an Element**:
   - Use a simple loop to compare each element in the array with the given data.

   ```java
   for (int i = 0; i < size; i++) {
       if (array[i] != null && array[i].equals(data)) {
           return true;
       }
   }
   return false;
   ```

3. **String Representation (`toString`)**:
   - Iterate up to the `size` of the array to avoid including `null` values from unused slots.

   ```java
   for (int i = 0; i < size; i++) {
       string += array[i] + ", ";
   }
   ```

4. **Testing**:
   - Test with small and large numbers of elements.
   - Test with edge cases like reversing an empty array or searching for a `null` value.

---

**Challenge Yourself**:
Extend the `DynamicArray` further by adding methods like:
- `clear()`: Removes all elements.
- `clone()`: Returns a shallow copy of the array.