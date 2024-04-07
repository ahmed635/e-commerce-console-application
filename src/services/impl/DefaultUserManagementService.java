package services.impl;

import entities.User;
import services.UserManagementService;

import java.util.Arrays;

public class DefaultUserManagementService implements UserManagementService {
    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;
    private User[] users;
    private int userLastIndex;

    private static DefaultUserManagementService instance;

    // <write your code here>

    private DefaultUserManagementService() {
        users = new User[DEFAULT_USERS_CAPACITY];
        userLastIndex = 0;
    }

    @Override
    public String registerUser(User user) {
        if (user == null) {
            return NO_ERROR_MESSAGE;
        }

        String errorMessage = checkUniqueEmail(user.getEmail());
        if (user.getEmail() != null && !errorMessage.isEmpty()) {
            return errorMessage;
        }
        if (users.length <= userLastIndex) {
            users = Arrays.copyOf(users, users.length << 1);
        }

        users[userLastIndex++] = user;
        return NO_ERROR_MESSAGE;
    }

    private String checkUniqueEmail(String email) {
        if(email == null || email.isEmpty())
            return EMPTY_EMAIL_ERROR_MESSAGE;
        for(User user: users){
            if(isNotUniqueEmail(user, email))
                return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
        }
        return NO_ERROR_MESSAGE;
    }

    private boolean isNotUniqueEmail(User user, String email) {
        return (user != null) && (user.getEmail() != null) && (user.getEmail().equalsIgnoreCase(email));
    }

    public static UserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }


    @Override
    public User[] getUsers() {
        int nonNullUserAmount = 0;
        for (User user : users) {
            if (user != null)
                nonNullUserAmount++;
        }

        User[] nonNullUsers = new User[nonNullUserAmount];
        int index = 0;
        for (User user : users) {
            if (user != null)
                nonNullUsers[index++] = user;
        }
        return nonNullUsers;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        for (User user : users) {
            if (user.getEmail().equals(userEmail))
                return user;
        }
        return null;
    }

    void clearServiceState() {
        users = new User[DEFAULT_USERS_CAPACITY];
        userLastIndex = 0;
    }
}
