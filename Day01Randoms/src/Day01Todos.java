import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Day01Todos{

    // A list to store all the To do items
    static ArrayList<Todo> todoList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    public static void main(String[] args){
        while (true){
            // display the menu options
            System.out.println("Please make a choice [0-4]:");
            System.out.println("1. Add a todo");
            System.out.println("2. List all todos (numbered)");
            System.out.println("3. Delete a todo");
            System.out.println("4. Modify a todo");
            System.out.println("0. Exit");

            // get the user's choice
            int choice = inputInt(); // calls helper method to get valid integer
            switch(choice) {
                case 1:
                    addTodo(); // call the method to add a new To do
                    break;
                case 2:
                    listTodos(); //list all todos
                    break;
                case 3:
                    deleteTodo(); // delete a to do by its number
                    break;
                case 4:
                    modifyTodo(); // modify existing to do
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return; // exit the program
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
    // Method to add a new To do item
    static void addTodo() {
        try {
            System.out.println("Adding a todo.");
            System.out.print("Enter task description: ");
            String task = input.nextLine(); // Get the task description
            System.out.print("Enter due Date (yyyy/MM/dd): ");
            Date dueDate = sdf.parse(input.nextLine()); // Parse the date
            System.out.print("Enter hours of work (integer): ");
            int hoursOfWork = inputInt(); // Get the number of hours
            Todo todo = new Todo(task, dueDate, hoursOfWork); // Create new To do object
            todoList.add(todo); // Add the to do to the list
            System.out.println("You've created the following todo:");
            System.out.println(todo); // Display the created to do
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Handle invalid task description or hours
        }
    }
    // method to list all to do items in the list
    static void listTodos() {
        if (todoList.isEmpty()) {
            System.out.println("there are no todos.");
        } else {
            System.out.println("listing all todos.");
            int i = 1;
            for (Todo todo : todoList) {
                System.outprintln("#" + ": " + todo); // print each to do with a number
                i++;
            }
        }
    }
    // method to delete a to do by its number
    static void deleteTodo() {
        System.out.print("Which todo # would you like to delete? ");
        int index = inputInt(); // get the to do number
        if (index<1 || index > todoList.size()){
            System.out.println("Invalid todo number");
        }else {
            todoList.remove(index - 1);
            System.out.println(" deleted todo #" + index + "successfully. ");
        }
    }
    // method to modify an existing to do
    static void modifyTodo(){
        System.out.print("Which todo # would you like to modify? ");

    }
}