package todolist;

import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Feature  {
    List<Todo> todoList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Feature(){

    }
   /* public Feature(ArrayList<Todo> todoList) {
        this.todoList = todoList;
    }*/
   public void taskList(){
       if(todoList.isEmpty()){
           System.out.println("You have no more todo left!");

       } else{
           System.out.println("You have " + todoList.size()+ "todo left!");
           for (Todo task : todoList){
               System.out.println(task);
           }

       }
   }


    public void displayList(){
        System.out.println("1. Create todo");
        System.out.println("2. Edit todo");
        System.out.println("3. Finish todo");
        System.out.println("4. Delete todo");
        System.out.println("5. Exit");
        System.out.println("Input: ");
    }


    public void taskAdd(){
        while (true) {
            System.out.println("Add your task: ");
            String todo = scanner.nextLine();
            System.out.println("Deadline[yyyy/mm/dd]: ");
            String deadline = scanner.nextLine();

            Todo newTask = new Todo(todo, deadline);
            todoList.add(newTask);

            System.out.println("Save!");


            System.out.println("Add more? [y/n]");
            String addmore = scanner.nextLine();
            if (addmore.equals("n")) break;

        }
        writedata(todoList);
    }

    public void editTask(){
        System.out.println("What task do you want to edit?");
        int in = Integer.parseInt(scanner.nextLine());
        for (Todo task : todoList){
            if (in-1 == todoList.indexOf(task)){

            }
        }


    }

    public void finish(){
        System.out.println("Choose task what you finish: ");
        int in2 = Integer.parseInt(scanner.nextLine());
       for (Todo task : todoList){
           if (in2 - 1 == todoList.indexOf(task)){
               System.out.println(task + "Done");
           }
       }

    }


    public void deleleTask() {
        System.out.println("Choose task you want to delete: ");
        int in3 = Integer.parseInt(scanner.nextLine());
        for (Todo task : todoList){
            if (in3 - 1 == todoList.indexOf(task)){
                todoList.remove(in3-1);
            }
        }
    }

    public static void writedata(List<Todo> todoList){
        try(FileWriter fileWriter = new FileWriter("task.csv");
            BufferedWriter writer = new BufferedWriter(fileWriter)){
            StringBuilder lineBuilder = new StringBuilder();
            for(Todo task : todoList){
                lineBuilder.append(task.getTask()).append(",");
                lineBuilder.append(task.getDeadline());
                writer.write(lineBuilder.toString());
                writer.newLine();
                lineBuilder.setLength(0);
            }
        }catch (IOException e){
            System.out.println("errror" + e.getMessage());
        }
    }

    public static List<Todo> readData(){
       List<Todo> list = new ArrayList<>();
       try(FileReader fileReader = new FileReader("task.csv");
        BufferedReader reader = new BufferedReader(fileReader)) {
    String line;
    while ((line = reader.readLine()) != null){
        String [] elements = line.split(",");
        list.add(new Todo(
                elements[0],
                elements[1]
        ));
    }
        }catch (IOException e){
            System.out.println("error"+ e.getMessage());
        }
        return list;

    }


}
