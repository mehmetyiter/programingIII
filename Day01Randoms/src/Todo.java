import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Todo {
    // Private fields to store the task details
    private String task;
    private Date dueDate;
    private int hoursOfWork;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");

    // Constructor to initialize the ToDo object using the setters for validation
    public Todo(String task, Date dueDate, int hoursOfWork) {
        setTask(task);
        setDueDate(dueDate);
        setHoursOfWork(hoursOfWork);
    }
    // Getter task
    public String getTask() {
        return task;
    }
    // Setter for task with validation
    public void setTask(String task) {
        // Task must be 2-50 characters long and not contain certain characters
        if (task.length() < 2 || task.length() > 50 || task.matches(".*[;|`].*")){
            throw new IllegalArgumentException("Task must be 2-50 characters long and must not contain ';', '|', or '`'.");
        }
        this.task = task;
    }
    // getter for due date
    public Date getDueDate() {
        return dueDate;
    }
    // Setter for dueDate with validation (between 1900 and 2100)
    public void setDueDate(Date dueDate) {
        if (dueDate.before(new Date(0)) || dueDate.after(new Date(4102444800000L))) { // Between 1900 and 2100
            throw new IllegalArgumentException("Due date must be between 1900 and 2100.");
        }
        this.dueDate = dueDate;
    }
    // Getter for hoursOfWork
    public int getHoursOfWork() {
        return hoursOfWork;
    }
    //Setter for hours of works
    public void setHoursOfWork(int hoursOfWork) {
        if (hoursOfWork <0) {
            throw new IllegalArgumentException("Hours of work must be greater than 0.");
        }
        this.hoursOfWork = hoursOfWork;
    }
    //override toString to display the todo in a readable format
    @Override
    public String toString() {
        return String.format(%s, %s, will take %d hour(s) of work, Pending, task, sdf.format(dueDate), hoursOFWork)
    }
}
