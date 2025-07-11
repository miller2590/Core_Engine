package org.core.launcher;
import org.core.models.Todo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main Entry Point of the Application");
        Todo myTodo = new Todo("Learn Java", "Practice building");
        System.out.println(myTodo);
    }
}