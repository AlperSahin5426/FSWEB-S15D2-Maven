package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String owner) {
        if (owner == null) return new HashSet<>();

        switch (owner.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default:

                return unassignedTasks;
        }
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> totalTasks = new HashSet<>();
        for (Set<Task> taskSet : sets) {
            if (taskSet != null) {
                totalTasks.addAll(taskSet);
            }
        }
        return totalTasks;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> intersect = new HashSet<>(first);
        intersect.retainAll(second);
        return intersect;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second) {
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;
    }
}