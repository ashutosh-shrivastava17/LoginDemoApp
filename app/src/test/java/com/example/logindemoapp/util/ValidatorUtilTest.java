package com.example.logindemoapp.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test for ValidatorUtil.
 */
public class ValidatorUtilTest {

    @Test
    public void validate_null_email_and_password_isEmailPasswordEmpty_returns_true() {
        assertTrue(ValidatorUtil.isEmailPasswordEmpty(null, null));
    }

    @Test
    public void validate_null_email_and_not_null_password_isEmailPasswordEmpty_returns_true() {
        assertTrue(ValidatorUtil.isEmailPasswordEmpty(null, "Test@123"));
    }

    @Test
    public void validate_not_null_email_and_null_password_isEmailPasswordEmpty_returns_true() {
        assertTrue(ValidatorUtil.isEmailPasswordEmpty("abc1@xyz.com", null));
    }

    @Test
    public void validate_empty_email_and_empty_password_isEmailPasswordEmpty_returns_true() {
        assertTrue(ValidatorUtil.isEmailPasswordEmpty("", ""));
    }

    @Test
    public void validate_empty_email_and_non_empty_password_isEmailPasswordEmpty_returns_false() {
        assertFalse(ValidatorUtil.isEmailPasswordEmpty("", "Test@123"));
    }

    @Test
    public void validate_non_empty_email_and_empty_password_isEmailPasswordEmpty_returns_false() {
        assertFalse(ValidatorUtil.isEmailPasswordEmpty("abc1@xyz.com", ""));
    }

    @Test
    public void validate_non_empty_email_and_non_empty_password_isEmailPasswordEmpty_returns_false() {
        assertFalse(ValidatorUtil.isEmailPasswordEmpty("abc1@xyz.com", "Test@123"));
    }

    @Test
    public void validate_email_with_correct_input_isEmailValid_returns_true() {
        assertTrue(ValidatorUtil.isEmailValid("abc1@xyz.com"));
    }

    @Test
    public void validate_email_with_null_input_isEmailValid_returns_false() {
        assertFalse(ValidatorUtil.isEmailValid(null));
    }

    @Test
    public void validate_email_with_more_than_20_characters_isEmailValid_returns_false() {
        assertFalse(ValidatorUtil.isEmailValid("thisistestemailaddress@ignore.com"));
    }

    @Test
    public void validate_email_without_at_the_rate_character_isEmailValid_returns_false() {
        assertFalse(ValidatorUtil.isEmailValid("abc1.com"));
    }

    @Test
    public void validate_email_without_dot_com_isEmailValid_returns_false() {
        assertFalse(ValidatorUtil.isEmailValid("abc1@def.xyz"));
    }

    @Test
    public void validate_email_with_special_character_other_than_at_the_rate_isEmailValid_returns_false() {
        assertFalse(ValidatorUtil.isEmailValid("abc#1@xyz.com"));
    }

    @Test
    public void validate_email_without_any_digit_isEmailValid_returns_false() {
        assertFalse(ValidatorUtil.isEmailValid("abc@xyz.com"));
    }

    @Test
    public void validate_password_with_correct_input_isPasswordValid_returns_true() {
        assertTrue(ValidatorUtil.isPasswordValid("Test@123"));
    }

    @Test
    public void validate_password_with_null_input_isPasswordValid_returns_false() {
        assertFalse(ValidatorUtil.isPasswordValid(null));
    }

    @Test
    public void validate_password_without_any_upper_case_letter_isPasswordValid_returns_false() {
        assertFalse(ValidatorUtil.isPasswordValid("test@123"));
    }

    @Test
    public void validate_password_without_any_lower_case_letter_isPasswordValid_returns_false() {
        assertFalse(ValidatorUtil.isPasswordValid("TEST@123"));
    }

    @Test
    public void validate_password_without_any_special_character_isPasswordValid_returns_false() {
        assertFalse(ValidatorUtil.isPasswordValid("Test123"));
    }

    @Test
    public void validate_password_without_any_digit_isPasswordValid_returns_false() {
        assertFalse(ValidatorUtil.isPasswordValid("test@xyz"));
    }

    @Test
    public void validate_password_with_less_than_8_characters_isPasswordValid_returns_false() {
        assertFalse(ValidatorUtil.isPasswordValid("Test@12"));
    }
}