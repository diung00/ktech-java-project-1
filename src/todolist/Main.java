package todolist;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Todo> todoList = new ArrayList<>();
        Feature obj = new Feature();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!!");

        while (true) {
            obj.taskList();
            obj.displayList();

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    obj.taskAdd();
                    break;
                case 2:
                    obj.editTask();
                    break;
                case 3:
                    obj.finish();
                    break;
                case 4:
                    obj.deleleTask();
                    break;
                case 5:
                    break;
            }


        }


    }
}
