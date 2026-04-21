package org.example.answers.week2;

public class Recursion {

    // Cast to long early (before the multiplication) to avoid int overflow for
    // larger values of n — factorial grows extremely fast.
    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return 1; // Base case: 0! = 1 by definition.
        return (long) n * factorial(n - 1);
    }

    // Naive recursive Fibonacci — intuitive but O(2^n) because it recomputes the
    // same sub-problems repeatedly. Fine for small n; use memoisation for larger n.
    public int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return 0; // Base cases match the mathematical definition F(0)=0, F(1)=1.
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int sumOfDigits(int n) {
        // Negative numbers have the same digit sum as their absolute value.
        n = Math.abs(n);
        // Base case: a single digit is its own sum.
        if (n < 10) return n;
        // n % 10 peels off the last digit; n / 10 drops it, shrinking the problem.
        return n % 10 + sumOfDigits(n / 10);
    }

    // base^exp = base * base^(exp-1); each call reduces exp by 1 until it hits 0.
    // Cast to long before multiplying to avoid overflow for large results.
    public long power(int base, int exp) {
        if (exp < 0) throw new IllegalArgumentException("exp must be >= 0");
        if (exp == 0) return 1; // Anything to the power of 0 is 1.
        return (long) base * power(base, exp - 1);
    }
}
