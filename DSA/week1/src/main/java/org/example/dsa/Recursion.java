package org.example.dsa;

public class Recursion {

    /** @throws IllegalArgumentException if n < 0 */
    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException();

        if (n == 1  || n == 0 ) return 1;
        return n * factorial(n-1);
    }

    /** Returns the nth Fibonacci number (fib(0)=0, fib(1)=1).
     *  @throws IllegalArgumentException if n < 0 */
    public int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException();

        if (n == 0 ) return 0;
        if (n == 1 ) return 1;
        return fibonacci(n-1) + fibonacci(n-2);

    }

    /** Returns the sum of the digits of n.
     * ie sumOfDigits(123) => 1 + 2 + 3 = 6 */
    public int sumOfDigits(int n) {
        if(n < 10) return n;
        return n % 10 + sumOfDigits(n/10);
    }

    /** Returns base raised to the power exp.
     *  @throws IllegalArgumentException if exp < 0 */
    public long power(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException();
        }
        if (exp == 0) return 1L;
        return base * power(base,exp-1);
    }
}
