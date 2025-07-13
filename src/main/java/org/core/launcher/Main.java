package org.core.launcher;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.core.ui.CoreFxApplication;

@SpringBootApplication(scanBasePackages = "org.core")
public class Main {
    public static void main(String[] args) {
        // Configure Spring Boot for JavaFX
        System.setProperty("java.awt.headless", "false");
        System.setProperty("spring.main.web-application-type", "none");

        // Start Spring context
        ApplicationContext context = SpringApplication.run(Main.class, args);

        // Pass Spring context to JavaFX
        CoreFxApplication.applicationContext = context;

        // Launch JavaFX application
        Application.launch(CoreFxApplication.class, args);
    }
}