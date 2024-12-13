public class App {
    public static void main(String[] args) throws Exception {
        myDynamicArray dynamicArray = new myDynamicArray(5);

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


class myDynamicArray{
    int size;
    int capacity;
    Object[] array;

    public myDynamicArray() {
        this.capacity = 10;
        this.array = new Object[capacity];
    }

    public myDynamicArray(int capacitiy) {
        this.capacity = capacitiy;
        this.array = new Object[capacitiy];
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            Object dataHolder = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = dataHolder;
        }
    }

    private void expand() {
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        this.capacity = newCapacity;
        this.array = newArray;
    }

    private void shrink() {
        int newCapacity = capacity / 2;
        Object[] newArray = new Object[newCapacity];
        
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        this.capacity = newCapacity;
        this.array = newArray;
    }

    public Object get(int index) {
        return array[index];
    }

    public void add(Object data) {
        if (size >= capacity) expand();
        array[size] = data;
        size++;
    }

    public void remove(Object data) {
        for (int i = 0; i < size; i++) {
            if (array[i] != data) continue;
            // if found a match pass thru
            for (int j = i; j > size; j++) {
                array[j] = array[j + 1];
            }
            array[size-1] = null;
            size--;
            if (size <= capacity/2) shrink();
            break;
        }
    }

    public boolean contains(Object data) {
        for (Object arrayData : array) {
            if (arrayData != null && arrayData.equals(data)) return true;
        }
        return false;
    }
    
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i< size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
} 