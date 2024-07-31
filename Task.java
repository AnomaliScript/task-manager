public class Task {
    public String name;
    public String[] people;
    public double duration;
    public int dueDate;

    // Default constructor ¯\_(ツ)_/¯
    public Task() {}

    // Manual constructor
    public Task(String name, String[] people, double duration, int dueDate) {
        // Default constructor calling ¯\_(ツ)_/¯
        this();
        this.name = name;
        this.people = people;
        this.duration = duration;
        this.dueDate = dueDate;
    }
}
