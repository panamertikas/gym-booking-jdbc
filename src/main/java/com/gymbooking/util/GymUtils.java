package com.gymbooking.util;

/**
 * Utility class providing helper methods for the gym booking system.
 */
public class GymUtils {

    // Non-instantiable
    private GymUtils() {}

    /**
     * Returns true if the given string is null or empty.
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Returns true if the given integer is positive.
     */
    public static boolean isPositive(int value) {
        return value > 0;
    }

    /**
     * Returns true if the given object is null
     */
    public static boolean isNull(Object value) {
        return value == null;
    }

    /**
     * Returns true if the given string is a valid email address.
     */
    public static boolean isValidEmail(String email) {
        return email.matches("^[\\w.]+@[\\w]+\\.(com|gr)$");
    }
}