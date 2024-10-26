import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class App {
    private static final Stack<List<String>> stack = new Stack<>();
    private static final String[]
    commands = {
        "ADD_LIST apple, banana",
        "ADD_LIST cherry, date",
        "DISPLAY",
        "ADD_ELEMENT elderberry",
        "DISPLAY",
        "REMOVE_LIST",
        "DISPLAY"
    };

    public static void main(String[] args) throws Exception {
        runAllCommand(commands);
    }

    private static void runAllCommand(String[] commands)
    {
        for(String command: commands){
            processCommand(command);
        }
    }

    private static void processCommand(String command)
    {
        String[] parts = command.split(" ", 2);
        String action = parts[0];

        switch(action){
            case "ADD_LIST":
                addList(parts.length > 1 ? parts[1] : "");
                break;
            case "ADD_ELEMENT":
                addElement(parts.length > 1 ? parts[1] : "");
                break;
            case "REMOVE_LIST":
                removeList();
                break;
            case "DISPLAY":
                display();
                break;
            default:
                System.out.println("ERROR: Unknown command.");
        }
    }

    private static void addList(String elements){
        if(elements.isEmpty()){
            System.out.println("ERROR: No element found.");
            return;
        }

        List<String> list = new ArrayList<>(Arrays.asList(elements.split(", ")));
        stack.push(list);
        System.out.println("Added list: "+ list);
    }

    private static void addElement(String element){
        if(element.isEmpty()){
            System.out.println("ERROR: No element found.");
            return;
        }
        if(stack.isEmpty()){
            System.out.println("ERROR: No List found.");
            return;
        }

        List<String> list = stack.peek();
        list.add(element);
        System.out.println("Added element \""+element+"\" to list "+stack.peek());
    }

    private static void removeList(){
        if(stack.isEmpty()){
            System.out.println("ERROR: No List found.");
            return;
        }

        List<String> removedList = stack.pop();
        System.out.println("Removed list: "+removedList);
    }

    private static void display(){
        if(stack.isEmpty()){
            System.out.println("ERROR: No List found.");
            return;
        }

        System.out.println("Top list of the stack is: "+stack.peek());
    }
}

