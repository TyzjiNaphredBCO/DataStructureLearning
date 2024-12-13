

public class App {
    public static void main (String[] args){
        MyLinkedList list = new MyLinkedList();

        list.add(10);
        list.add(20);
        list.add(30); 
        list.print();

        list.addAtIndex(1, 15);
        list.print();

        list.remove(20);
        list.print();

        list.remove(100);
    }
}

class MyLinkedList{
    private static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void addAtIndex(int index, int data){
        if (index < 0) throw new IndexOutOfBoundsException("Invalid index");

        Node newNode = new Node(data);
        if (index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        int currentIndex = 0;

        while (temp != null && currentIndex < index - 1) {
            temp  = temp.next;
            currentIndex++;
        }

        if (temp == null) throw new IndexOutOfBoundsException("Index out of bounds");

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void remove(int data){
        if(head == null){
            System.out.println("List is empty. Nothing to remove.");
            return;
        }

        if(head.data == data){
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next == null && temp.next.data != data){
            temp = temp.next;
        }

        if (temp.next == null){
            System.out.println("Element not found.");
        } else {
            temp.next = temp.next.next;
        }
    }
    
    public void print() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

}
