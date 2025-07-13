package org.core.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.core.service.TodoService;
import org.core.models.Todo;

public class CoreFxApplication extends Application {

    private ApplicationContext springContext;
    private TodoService todoService;

    // This will be set by our Main class
    public static ApplicationContext applicationContext;

    @Override
    public void start(Stage primaryStage) {
        // Get Spring context and TodoService
        this.springContext = applicationContext;
        this.todoService = springContext.getBean(TodoService.class);

        // Create the UI
        createUI(primaryStage);
    }

    private void createUI(Stage primaryStage) {
        primaryStage.setTitle("Todo Application");

        // Create UI components
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        // Input fields
        TextField titleField = new TextField();
        titleField.setPromptText("Enter todo title...");

        TextField textField = new TextField();
        textField.setPromptText("Enter todo description...");

        Button addButton = new Button("Add Todo");

        // Todo list display
        ListView<String> todoListView = new ListView<>();

        // Add button action
        addButton.setOnAction(e -> {
            String title = titleField.getText().trim();
            String text = textField.getText().trim();

            if (!title.isEmpty() && !text.isEmpty()) {
                todoService.addTodo(title, text);
                titleField.clear();
                textField.clear();
                updateTodoList(todoListView);
            }
        });

        // Add components to layout
        root.getChildren().addAll(
                new Label("Add New Todo:"),
                titleField,
                textField,
                addButton,
                new Label("Your Todos:"),
                todoListView
        );

        // Load initial todos
        updateTodoList(todoListView);

        // Create and show scene
        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Close Spring context when window closes
        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    private void updateTodoList(ListView<String> listView) {
        listView.getItems().clear();

        for (Todo todo : todoService.getAllTodos()) {
            String status = todo.isComplete() ? "✓" : "○";
            String display = status + " " + todo.getTitle() + " - " + todo.getText();
            listView.getItems().add(display);
        }
    }
}
