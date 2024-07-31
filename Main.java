import java.util.*;

public class Main {
    // Python
    public static void print(String string) {
        System.out.print(string);
    }

    // String Input
    public static String input_str(String prompter, Scanner scanParam) {
        print(prompter);
        return scanParam.nextLine();
    }

    // Integer Input
    public static int input_int(String prompter, Scanner scanParam) {
        print(prompter);
        return scanParam.nextInt();
    }

    // Double Input
    public static double input_double(String prompter, Scanner scanParam) {
        print(prompter);
        return scanParam.nextDouble();
    }

    public static void main(String[] args) {
        Scanner scanStr, scanInt;
        scanStr = new Scanner(System.in);
        scanInt = new Scanner(System.in);

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<String> completedTasks = new ArrayList<>();

        print("==================================\n" +
                "           Task Manager           \n" +
                "           Version 1.0            \n" +
                " All rights reserved (not really) \n" +
                "==================================\n\n");

        boolean quit = false;
        boolean start = true;
        while(!quit) {
            // Cosmetic stuff
            if (!start) {
                print("\n\n\n\n\n");
            }
            start = false;

            print("Tasks:\n");
            if (tasks.size() == 0) {
                print("No tasks rn, hooray!\n");
            }
            for(int i = 0; i < tasks.size(); i++) {
                print("Task #" + Integer.toString(i + 1) + ": " + tasks.get(i) + "\n");
            }
            print("--------------------------------------\n");
            int action = input_int("What would you like to do?\n" +
                    "1) Add a Task\n" +
                    "2) Complete a Task\n" +
                    "3) Delete a Task\n" +
                    "4) See Completed Tasks\n" +
                    "5) Quit\n", scanInt);

            // Used for completing and deleting tasks
            int taskNum = 0;

            switch(action) {
                // Adding a task (doesn't use taskNum)
                case 1:
                    String task = input_str("What is the name of the task you want to add?\n", scanStr);
                    tasks.add(task);
                    break;
                // Completing a task (uses taskNum)
                case 2:
                    try {
                        taskNum = input_int("What is the task you want to complete? ", scanInt);
                        // normal number to index number
                        taskNum--;
                        completedTasks.add(tasks.get(taskNum));
                        //       index | a "copy" of the task | added string fragment
                        tasks.set(taskNum, tasks.get(taskNum) + " (Completed!)");
                    } catch(Exception e) {
                        print("That's not a valid taskID!");
                    }
                    break;
                // Deleting a Task (uses taskNum)
                case 3:
                    taskNum = input_int("What is the task you want to delete? ", scanInt);
                    try {
                        tasks.remove(tasks.get(taskNum));
                    } catch(Exception e) {
                        print("That's not a valid taskID!");
                    }
                    break;
                // Completed Tasks (doesn't use taskNum)
                case 4:
                    print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                    print("Completed Tasks: \n");
                    for(int i = 0; i < completedTasks.size(); i++) {
                        print("#" + (i + 1) + ": " + completedTasks.get(i) + "\n");
                    }
                    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                // Quitting
                case 5:
                    String answer = input_str("Are you sure? All of your tasks will be lost! (y/n)", scanStr);
                    if(answer.equals("y") || answer.equals("ye") || answer.equals("yes")) {
                        quit = true;
                    }
                    break;
                default:
                    break;
            }
            print("\n");
        }
    }
}
