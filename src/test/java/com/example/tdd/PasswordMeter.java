package com.example.tdd;

public class PasswordMeter {
    public PasswordStrength meter(String pw) {
        if(pw == null || pw.isEmpty())
            throw new IllegalArgumentException();
        int metCount = 0;
        if(isLengthAtLeast8(pw)) metCount++;
        if(containsUppercase(pw)) metCount++;
        if(containsNumber(pw)) metCount++;
        if(metCount == 1 || metCount == 0) {
            return PasswordStrength.WEAK;
        } else if(metCount == 2) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;

    }

    private static boolean isLengthAtLeast8(String pw) {
        return pw.length() >= 8;
    }

    private static boolean containsUppercase(String pw) {
        for(char ch : pw.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private static boolean containsNumber(String pw) {
        for(char ch : pw.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
