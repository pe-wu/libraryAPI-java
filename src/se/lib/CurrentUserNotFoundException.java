package se.lib;

class CurrentUserNotFoundException extends Exception {
    private String title;

    CurrentUserNotFoundException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
