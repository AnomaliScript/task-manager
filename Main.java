import java.util.Scanner;
import java.util.Arrays;

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

    // Adding (1)
    public static void add(String newItem, String[] list) {
        list = Arrays.copyOf(list, list.length + 1);
        list[list.length - 1] = newItem;
    }

    // Completing (2)
    // scan_complete is only being "transitted" though this function
    public static void complete(String[] list, int number) {
        list[number] += " (Completed!)";
        add(list[number], list);
    }

    // Deleting (3)
    public static void delete(String[] list, int number) {
        list = Arrays.copyOf(list, list.length - 1);
    }
    // Viewing Completed (4)
    public static void view(String[] list) {
        for(int i = 0; i < list.length; i++) {
            print("#" + i + ": " + list[i] + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner scan;
        scan = new Scanner(System.in);

        String name = input_str("What's ur name?", scan);
        print(name);

        String[] tasks = {};
        String[] completedTasks = {};

        print("==================================\n" +
                "           Task Manager           \n" +
                "           Version 1.0            \n" +
                " All rights reserved (not really) \n" +
                "==================================\n");

        boolean quit = false;
        while(!quit) {
            int action = input_int("What would you like to do?\n" +
                    "1) Add a Task\n" +
                    "2) Complete a Task\n" +
                    "3) Delete a Task\n" +
                    "4) See Completed Tasks\n", scan);

            switch(action) {
                // Adding a task
                case 1:
                    String newTask = input_str("What task would you like to add? ", scan);
                    add()
                    break;
                // Completing a task
                case 2:
                    complete()
                    break;
                // Deleting a Task
                case 3:

                    break;
                // Completed Tasks
                case 4:
                    view(completedTasks);
                    break;
            }
        }
    }
}
