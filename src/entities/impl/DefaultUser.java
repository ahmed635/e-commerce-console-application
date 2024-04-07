package entities.impl;

import entities.User;

public class DefaultUser implements User {
    private static int id = 0;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public DefaultUser() {
    }

    public DefaultUser(String firstName, String lastName, String password, String email) {
        id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User[FullName: " + getFirstName() + " " + getLastName() + " Email: " + getEmail() + "]";
    }

    @Override
    public void setPassword(String password) {
        if (password != null)
            this.password = password;
    }

    @Override
    public void setEmail(String newEmail) {
        if (newEmail != null) {
            this.email = newEmail;
        }
    }

    @Override
    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLasttName(String lastName) {
        this.lastName = lastName;
    }

    void clearState() {
        id = 0;
    }
}
