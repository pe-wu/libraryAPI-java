package se.lib;

class TooManyBorrowsException extends Exception {
    private String username;

    TooManyBorrowsException(String username) {
        this.username = username;
    }

    @Override
    public void printStackTrace() {
        //it's not a bug, it's a feature!
        System.err.println("User " + username + "already borrowed too much books!");
        super.printStackTrace();
    }
}
