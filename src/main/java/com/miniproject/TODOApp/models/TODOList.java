package com.miniproject.TODOApp.models;

import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class TODOList {
    private static ArrayList<TODOList> todoLists = new ArrayList<>();
    private static ArrayList<TODOList> todoListsToday = new ArrayList<>();
    private String name;
    private String description;
    private String dueDate;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String date) {
        this.dueDate = date;
    }

    public static ArrayList<TODOList> getTodoLists() {
        return todoLists;
    }

    public static ArrayList<TODOList> getTodoListsToday() {
        return todoListsToday;
    }

    public static void addTodo(TODOList todo) {
        todoLists.add(todo);
        for (TODOList t : todoLists) {
            if (t.isDueToday()) {
                todoListsToday.add(t);
                todoLists.remove(t);
            }
        }
    }

    public static void deleteTodo(TODOList todo) {
        todoLists.remove(todo);
    }

    public static void addTodoToday(TODOList todo){
        todoListsToday.add(todo);
    }

    public Boolean isDueToday() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
        String dateNow = date.format(formatter);

        if (this.dueDate.equals(dateNow)) {
            return true;
        }

        return false;
    }
}