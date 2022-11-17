package com.example.logindemoapp.util;

/**
 * Util class to validate login credentials.
 */
public class ValidatorUtil {

    /**
     * Checks if both email and password are empty.
     *
     * @param password entered password.
     * @return true if both are empty, otherwise false.
     */
    public static boolean isPasswordEmpty(String password) {
        return password.isEmpty();
    }

    /**
     * Checks if provided email address is valid or not.
     *
     * @param emailAddress email-id.
     * @return true if email is valid, otherwise false.
     */
    public static boolean isEmailValid(String emailAddress) {
        return emailAddress != null && emailAddress.matches(Constant.EMAIL_PATTERN);
    }

    /**
     * Checks if provided password is valid or not.
     *
     * @param password password.
     * @return true if password is valid, otherwise false.
     */
    public static boolean isPasswordValid(String password) {
        return password != null && password.matches(Constant.PASSWORD_PATTERN);
    }
}
