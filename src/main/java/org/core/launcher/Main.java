package org.core.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;  // ← Fixed import
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.core.service.TodoService;

@SpringBootApplication(scanBasePackages = "org.core")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);  // ← Fixed method
        System.out.println("Main Entry Point of the Application");

        TodoService service = context.getBean(TodoService.class);  // ← Get from Spring
        service.addTodo("Learn Java", "Practice building");
        service.printAllTodos();
    }
}