package com.example.logindemoapp.util;

/**
 * Constant class to hold all the constant values.
 */
public class Constant {

    public static final String EMAIL_KEY = "email_key";
    public static final String PASSWORD_KEY = "password_key";
    public static final String EMAIL_PATTERN = "(?=^.{7,20}$)[a-zA-Z0-9]+[0-9]+([A-Za-z0-9]*)*@[A-Za-z0-9]+.com$";
    public static final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
}
