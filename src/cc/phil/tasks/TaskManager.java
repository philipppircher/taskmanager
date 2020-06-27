package cc.phil.tasks;

import java.util.List;
import java.util.Scanner;

public class TaskManager {
    // Membervariables
    //
    private TaskDAO taskDAO;

    // Constructor
    //
    public TaskManager() {
        this.taskDAO = new TaskDAO();
    }

    // Methodes
    //
    public  void readInput() {
        boolean hasLoop = true;
        System.out.println("Willkommen");
        printAllTasks();

        while (hasLoop) {
            System.out.println("\nEingabe: c - Anzahl Datensätze, d - delete, i - insert, " +
                    "e - end of program, p - print, u - update");
            System.out.print("\nBitte gib einen Befehl ein: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("i")) {
                insertTask();
            }

            if (input.equalsIgnoreCase("c")) {
                counterTask();
            }

            if (input.equalsIgnoreCase("d")) {
                deleteTask();
            }

            if (input.equalsIgnoreCase("p")) {
                printAllTasks();
            }

            if (input.equalsIgnoreCase("u")) {
                updateTask();
            }

            if (input.equalsIgnoreCase("e")) {
                hasLoop = false;
            }
        }
        System.out.println("Programm wurde beendet");
    }

    public void printAllTasks () {
        if (isDataCounterOverZero()) {
            List<TaskVO> tasks = this.taskDAO.getAllTasks();
            for (TaskVO task : tasks) {
                System.out.println("id: " + task.getId() + ", name: " + task.getName());
            }
        }
    }

    private void insertTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Name eingeben: ");
        String input = scanner.nextLine();
        TaskVO task = new TaskVO(0, input);
        this.taskDAO.insertTask(task);
        printAllTasks();
    }

    private void deleteTask () {
        if (isDataCounterOverZero()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcher Datensatz soll gelöscht werden: ");
            printAllTasks();
            int inputID = scanner.nextInt();
            this.taskDAO.deleteTask(inputID);
        }
    }

    private void updateTask(){
        if (isDataCounterOverZero()){
            Scanner scanner = new Scanner(System.in);
            printAllTasks();
            System.out.print("Welcher Datensatz soll verändert werden (id): ");
            int inputID = scanner.nextInt();
            scanner = new Scanner(System.in);
            System.out.print("Bitte Neuer Name eingeben: ");
            String newName = scanner.nextLine();
            this.taskDAO.updateTask(inputID, newName);
        }
    }

    private void counterTask(){
        if (isDataCounterOverZero()) {
            int count = taskDAO.getDataCounter();
            System.out.println("Anzahl Datensätze in tasks-Tabelle : " + count);
        }
    }

    private boolean isDataCounterOverZero(){
        int counter = taskDAO.getDataCounter();
        boolean isOverZero = counter > 0;

        if (!isOverZero) {
            System.out.println("Keine Datensätze vorhanden");
        }
        return isOverZero;
    }
}