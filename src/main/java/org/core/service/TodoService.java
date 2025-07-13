package org.core.service;

import org.core.models.Todo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class TodoService {

    private final List<Todo> todos;

    public TodoService() {
        this.todos = new ArrayList<>();
    }

    public void addTodo(String title, String text) {
        Todo newTodo = new Todo(title, text);
        todos.add(newTodo);
    }

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos);
    }

    public void printAllTodos() {
        System.out.println("=== Todo List ===");
        for (int i = 0; i < todos.size(); i++) {
            Todo todo = todos.get(i);
            String status = todo.isComplete() ? "✓ DONE" : "○ TODO";
            System.out.println((i + 1) + ". " + status + ": " + todo.getTitle());
        }
    }

    public void markComplete(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.get(index).setComplete(true);
        }
    }

    public void deleteTodo(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.remove(index);
        }
    }
}
