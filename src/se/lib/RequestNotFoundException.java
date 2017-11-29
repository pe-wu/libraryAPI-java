package se.lib;

public class RequestNotFoundException extends Exception {

	private static final long serialVersionUID = -5518199670119852558L;
	private String title;

    RequestNotFoundException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
