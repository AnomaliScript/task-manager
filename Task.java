import java.util.ArrayList;

public class Task {
    public String name;
    public ArrayList<String> people;
    public double duration;
    public String dueDate;
    public String state;

    // Manual constructor
    public Task(String name, ArrayList<String> people, double duration, String taskDueDate, String state) {
        // Default constructor calling ¯\_(ツ)_/¯
        this.name = name;
        this.people = people;
        this.duration = duration;
        this.dueDate = taskDueDate;
        this.state = state;
    }

    // Complete function
    public void Complete() {
        this.name = this.name + " (Completed!)";
        this.state = "Completed";
    }
}
