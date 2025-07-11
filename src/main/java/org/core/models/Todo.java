package org.core.models;

public class Todo {
    // Fields (props/attrs)
    private String title;
    private String text;
    private boolean isComplete;

    //Constructor
    public Todo(String title, String text) {
        this.title = title;
        this.text = text;
        this.isComplete = false;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public boolean isComplete() {
        return isComplete;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    // toString method
    @Override
    public String toString() {
        return "Todo{Title='" + title + "', Text='" + text + "', isComplete=" + isComplete + "}";
    }

}


