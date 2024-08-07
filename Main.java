import java.util.*;

public class Main {
    // Python
    public static void print(String string) {
        System.out.print(string);
    }

    private static final Scanner scanStr = new Scanner(System.in);
    private static final Scanner scanInt = new Scanner(System.in);
    private static final Scanner scanDouble = new Scanner(System.in);
    
    // String Input
    public static String input_str(String prompter) {
        print(prompter);
        String string = scanStr.nextLine();
        return string;
    }

    // Integer Input
    public static int input_int(String prompter) {
        print(prompter);
        return scanInt.nextInt();
    }

    // Double Input
    public static double input_double(String prompter) {
        print(prompter);
        return scanDouble.nextDouble();
    }

    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Task> completedTasks = new ArrayList<>();

        print("+================================+\n|          Task Manager          |\n|          Version 2.0           |\n|    All rights (not) reserved   |\n+================================+\n\n");

        boolean quit = false;
        boolean spacer = false;
        while(!quit) {
            // Cosmetic stuff
            if (spacer) {
                print("\n\n\n\n\n");
            }
            spacer = true;

            print("Tasks:\n");
            if (tasks.size() == 0) {
                print("No tasks rn, hooray!\n");
            }
            for(int i = 0; i < tasks.size(); i++) {
                print("Task #" + (i + 1) + ": " + tasks.get(i).name + "\n");
            }
            print("--------------------------------------\n");
            // Random number (doesn't matter because it will be replaced
            int action = 42;
            try {
                action = input_int("What would you like to do?\n1) Add a Task\n2) Complete a Task\n3) Delete a Task\n4) Inspect a Task\n5) See Completed Tasks\n6) Quit\n");
            } catch(Exception e) {
                print("That's not a valid actionID!");
            }

            // Used for completing and deleting tasks
            String taskStr;
            int taskNum;

            switch (action) {
                // Adding a task (doesn't use taskNum)
                case 1 -> {
                    // name
                    String taskName = input_str("What is the name of the task you want to add? (type \"back\" to go back)\n");
                    // back option
                    if (taskName.equals("back")) {
                        break;
                    }
                    // people
                    String taskPeopleRaw = input_str("Who are the people responsible? (type only their first names, with only a space separating the names)\n");
                    ArrayList<String> taskPeople = new ArrayList<>(Arrays.asList(taskPeopleRaw.split(" ")));
                    // duration
                    double taskDuration = 0.0;
                    try {
                        taskDuration = input_double("About how long would the task take? (in hours and in a decimal)\n");
                    } catch (Exception e) {
                        print("That's not a valid time duration!");
                    }
                    // dueDate
                    String taskDueDate = input_str("What should the due date of the task be?\n");
                    Task task = new Task(taskName, taskPeople, taskDuration, taskDueDate, "Not Completed");
                    tasks.add(task);
                }
                // Completing a task (uses taskNum)
                case 2 -> {
                    taskStr = input_str("What task you want to mark as completed? (type \"back\" to go back)\n");
                    if (taskStr.equals("back")) {
                        break;
                    }
                    try {
                        taskNum = Integer.parseInt(taskStr);
                        // normal number to index number
                        taskNum--;
                        completedTasks.add(tasks.get(taskNum));
                        tasks.get(taskNum).Complete();
                    } catch (Exception e) {
                        print("That's not a valid taskID!");
                    }
                }
                // Deleting a Task (uses taskNum)
                case 3 -> {
                    taskStr = input_str("What task you want to delete? (type \"back\" to go back)\n");
                    if (taskStr.equals("back")) {
                        break;
                    }
                    try {
                        taskNum = Integer.parseInt(taskStr);
                        // normal number to index number
                        taskNum--;
                        tasks.remove(tasks.get(taskNum));
                    } catch (Exception e) {
                        print("That's not a valid taskID!\n");
                    }
                }
                // Inspecting tasks
                case 4 -> {
                    taskStr = input_str("What task you want to inspect? (type \"back\" to go back)\n");
                    if (taskStr.equals("back")) {
                        break;
                    }
                    try {
                        taskNum = Integer.parseInt(taskStr);
                        // normal number to index number
                        taskNum--;
                        Task task = tasks.get(taskNum);

                        StringBuilder peopleList = new StringBuilder();
                        for(int i = 0; i < task.people.size(); i++) {
                            peopleList.append(task.people.get(i));
                            if (i < task.people.size() - 1){
                                peopleList.append(", ");
                            }
                        }
                        print(  "Task name: " + task.name + "\n" +
                                "People responsible: " + peopleList + "\n" +
                                "Estimated hours until completion: " + task.duration + "\n" +
                                "Deadline for task: " + task.dueDate + "\n" +
                                "Status: " + task.state + "\n"
                        );
                    } catch (Exception e) {
                        print("That's not a valid taskID!\n");
                    }
                }
                // Viewing Completed Tasks (doesn't use taskNum)
                case 5 -> {
                    print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    print("Completed Tasks: \n");
                    if (completedTasks.size() == 0) {
                        print("Nothing here yet\n*zzzZZzZzZzzzZzZZZzzzzz.....*");
                    } else {
                        for (int i = 0; i < completedTasks.size(); i++) {
                            print("#" + (i + 1) + ": " + completedTasks.get(i).name + "\n");
                        }
                    }
                    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    spacer = false;
                }
                // Quitting
                case 6 -> {
                    String answer = input_str("Are you sure? All of your tasks will be lost! (y/n)");
                    if (answer.equals("y") || answer.equals("ye") || answer.equals("yes")) {
                        quit = true;
                    }
                }
                default -> {
                }
            }
            print("\n");
        }
        scanStr.close();
        scanInt.close();
        scanDouble.close();
    }
}
