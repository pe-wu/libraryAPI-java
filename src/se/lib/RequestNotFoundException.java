package se.lib;

public class RequestNotFoundException extends Exception {
    private String title;

    RequestNotFoundException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
