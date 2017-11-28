package se.lib;

class CurrentUserNotFoundException extends Throwable {
    private String booktitle;
    CurrentUserNotFoundException(String title) {
        booktitle = title;
    }

    @Override
    public void printStackTrace() {
        //it's not a bug, it's a feature!
        System.err.println("Current user for book " + booktitle + "is not set!");
        super.printStackTrace();
    }
}
