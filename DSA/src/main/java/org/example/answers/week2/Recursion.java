package org.example.answers.week2;

public class Recursion {

    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");

        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int sumOfDigits(int n) {
        if (n < 0) {
            n = -n;
        }

        if (n < 10) {
            return n;
        }

        int lastDigit = n % 10;
        int remaining = n / 10;
        return lastDigit + sumOfDigits(remaining);
    }

    public long power(int base, int exp) {
        if (exp < 0) throw new IllegalArgumentException("exp must be >= 0");

        if (exp == 0) {
            return 1;
        }

        return base * power(base, exp - 1);
    }
}
