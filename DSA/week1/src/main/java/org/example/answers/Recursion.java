package org.example.answers;

public class Recursion {

    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return 1;
        return (long) n * factorial(n - 1);
    }

    public int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int sumOfDigits(int n) {
        n = Math.abs(n);
        if (n < 10) return n;
        return n % 10 + sumOfDigits(n / 10);
    }

    public String reverseString(String s) {
        if (s == null || s.length() <= 1) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public long power(int base, int exp) {
        if (exp < 0) throw new IllegalArgumentException("exp must be >= 0");
        if (exp == 0) return 1;
        return (long) base * power(base, exp - 1);
    }
}
