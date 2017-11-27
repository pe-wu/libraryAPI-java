package se.lib;

class UserNotFoundException extends Exception {
    private String username;

    UserNotFoundException(String username) {
        this.username = username;
    }

    @Override
    public void printStackTrace() {
        //it's not a bug, it's a feature!
        System.err.println("User " + username + "not found!");
        super.printStackTrace();
    }
}
