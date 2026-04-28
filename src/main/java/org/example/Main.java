package org.example;

import org.example.entity.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Java Sets", "Learn Set logic", "Ann", Status.IN_PROGRESS, Priority.HIGH);
        Task task2 = new Task("Java Sets", "Write equals method", "Bob", Status.ASSIGNED, Priority.MED);
        Task task3 = new Task("API Proj", "Setup database", "Carol", Status.IN_QUEUE, Priority.LOW);
        Task task4 = new Task("Java Sets", "Learn Set logic", "Bob", Status.IN_PROGRESS, Priority.HIGH);

        Set<Task> annSet = new HashSet<>();
        annSet.add(task1);

        Set<Task> bobSet = new HashSet<>();
        bobSet.add(task2);
        bobSet.add(task4);

        Set<Task> carolSet = new HashSet<>();
        carolSet.add(task3);

        Set<Task> unassignedSet = new HashSet<>();

        unassignedSet.add(new Task("New Proj", "Unknown Task", null, Status.IN_QUEUE, Priority.LOW));

        TaskData taskData = new TaskData(annSet, bobSet, carolSet, unassignedSet);

        System.out.println("--- TÜM ÇALIŞANLARIN TASKLARI ---");
        System.out.println(taskData.getUnion(annSet, bobSet, carolSet));

        System.out.println("--- ANN'S TASKS ---");
        System.out.println(taskData.getTasks("ann"));

        System.out.println("--- ATANMAMIŞ TASKLAR ---");
        System.out.println(taskData.getTasks("unassigned"));

        System.out.println("--- BENZERSİZ KELİMELER ---");
        System.out.println(StringSet.findUniqueWords());
    }
}