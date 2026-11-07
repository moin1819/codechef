# PRIME1 - Rating 1620

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Prime Generator

Ram wants to generate some prime numbers for his cryptosystem. Help him please! Your task is to generate all prime numbers between two given numbers.

 **Warning: large Input/Output data, be careful with certain languages (though most should be OK if the algorithm is well designed)** 
### Input Format

The first line contains t, the number of test cases (less then or equal to 10).

Followed by t lines which contain two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.

### Output Format

For every test case print all prime numbers p such that m <= p <= n, one number per line. Separate the answers for each test case by an empty line.

### Constraints

(1 <= m <= n <= 1000000000, n-m<=100000)

### Sample 1:
Input
Output

```
2
1 10
3 5
```

```
2
3
5
7
3
5
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-07T12:56:43.405Z  

```java

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            long m = sc.nextLong();
            long n = sc.nextLong();

            int limit = (int) Math.sqrt(n);

            // Generate primes up to sqrt(n)
            boolean[] isPrime = new boolean[limit + 1];
            Arrays.fill(isPrime, true);

            isPrime[0] = false;
            if (limit >= 1) {
                isPrime[1] = false;
            }

            for (int i = 2; i * i <= limit; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= limit; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            // Segmented sieve for [m, n]
            boolean[] segment = new boolean[(int)(n - m + 1)];
            Arrays.fill(segment, true);

            for (int p = 2; p <= limit; p++) {
                if (isPrime[p]) {
                    long start = Math.max(
                        (long)p * p,
                        ((m + p - 1) / p) * p
                    );

                    for (long j = start; j <= n; j += p) {
                        segment[(int)(j - m)] = false;
                    }
                }
            }

            // 0 and 1 are not prime
            if (m == 0) {
                segment[0] = false;
                if (n >= 1) segment[1] = false;
            } else if (m == 1) {
                segment[0] = false;
            }

            // Print primes
            for (int i = 0; i < segment.length; i++) {
                if (segment[i]) {
                    result.append(m + i).append('\n');
                }
            }

            if (t > 0) {
                result.append('\n');
            }
        }

        System.out.print(result);
        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/PRIME1)