import java.io.*;
import java.util.*;

public class Main {
    // Python
    public static void print(String string) {
        System.out.print(string);
    }

    // String Input
    public static String input_str(String prompter, Scanner scan_input) {
        print(prompter);
        return scan_input.nextLine();
    }

    // Integer Input
    public static int input_int(String prompter, Scanner scan_input) {
        print(prompter);
        return scan_input.nextInt();
    }

    // Double Input
    public static double input_double(String prompter, Scanner scan_input) {
        print(prompter);
        return scan_input.nextDouble();
    }

    // Task Managing functions (methods)

    // Completing (2)
    public static void complete(ArrayList<String> taskList, ArrayList<String> completeList, int number) {
        completeList.add(taskList.get(number));
        taskList.get(number) += " (Completed!)";
    }

    // Deleting (3)
    public static void delete(ArrayList<String> taskList, int number) {
        taskList.remove(taskList.get(number));
    }

    public static void main(String[] args) {
        Scanner scan;
        scan = new Scanner(System.in);

        String name = input_str("What's ur name?", scan);
        print(name);

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<String> completedTasks = new ArrayList<>();

        print("==================================\n" +
                "           Task Manager           \n" +
                "           Version 1.0            \n" +
                " All rights reserved (not really) \n" +
                "==================================\n");

        boolean quit = false;
        while(!quit) {
            for(int i = 0; i < tasks.size(); i++) {
                print("Task #" + i + ": " + tasks.get(i) + "\n");
            }
            print("--------------------------------------\n");
            int action = input_int("What would you like to do?\n" +
                    "1) Add a Task\n" +
                    "2) Complete a Task\n" +
                    "3) Delete a Task\n" +
                    "4) See Completed Tasks\n" +
                    "5) Quit\n", scan);

            int taskNum = 0;
            switch(action) {
                // Adding a task (doesn't use taskNum)
                case 1:
                    String task = input_str("What is the name of the task you want to add?\n", scan);
                    tasks.add(task);
                    break;
                // Completing a task (uses taskNum)
                case 2:
                    taskNum = input_int("What is the task you want to delete? ", scan);
                    completedTasks.add(taskList.get(taskNum));
                    taskList.get(number) += " (Completed!)";
                    break;
                // Deleting a Task (uses taskNum)
                case 3:
                    taskNum = input_int("What is the task you want to delete? ", scan);
                    tasks.remove(tasks.get(taskNum));
                    break;
                // Completed Tasks (doesn't use taskNum)
                case 4:
                    for(int i = 0; i < completedTasks.size(); i++) {
                        print("#" + i + ": " + completedTasks.get(i) + "\n");
                    }
                    break;
                // Quitting
                case 5:
                    String answer = input_str("Are you sure? All of your tasks will be lost! (y/n)", scan);
                    if(answer == "y") {
                        quit = true;
                    } else {
                        break;
                    }
            }
            print("\n");
        }
    }
}
