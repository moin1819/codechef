# DIGSMPAR - Rating 1077

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Digit Sum Parities

For a positive integer $M$, MoEngage defines $\texttt{digitSum(M)}$ as the sum of digits of the number $M$ (when written in decimal).

For example, $\texttt{digitSum(1023)} = 1 + 0 + 2 + 3 = 6$.

Given a positive integer $N$, find the  **smallest**  integer $X$  **strictly greater**  than $N$ such that:

- $\texttt{digitSum(N)}$ and $\texttt{digitSum(X)}$ have different parity, i.e. one of them is odd and the other is even.
### Input Format
- The first line contains an integer $T$, the number of test cases. The description of the $T$ test cases follow.
- Each test case consists of a single line of input with a single integer, the number $N$.
### Output Format
- For each test case, print in a single line, an integer, the answer to the problem.
### Constraints
- $1 \leq T \leq 1000$
- $1 \leq N \lt 10^{9}$
### Sample 1:
Input
Output

```
3
123
19
509
```

```
124
21
511
```

### Explanation:

 **Test Case $1$:**  $\texttt{digitSum}(123) = 1 + 2 + 3 = 6$ is  **even**  and $\texttt{digitSum}(124) = 1 + 2 + 4 = 7$ is  **odd**, so the answer is $124$.

 **Test Case $2$:**  $\texttt{digitSum}(19) = 1 + 9 = 10$ is  **even**, $\texttt{digitSum}(20) = 2 + 0 = 2$ is also  **even**, whereas $\texttt{digitSum}(21) = 2 + 1 = 3$ is  **odd**. Hence, the answer is $21$.

 **Test Case $3$:**  $\texttt{digitSum}(509) = 5 + 0 + 9 = 14$ is  **even**, $\texttt{digitSum}(510) = 5 + 1 + 0 = 6$ is also  **even**, whereas $\texttt{digitSum}(511) = 5 + 1 + 1 = 7$ is  **odd**. Hence, the answer is $511$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-13T17:51:01.191Z  

```java

import java.util.Scanner;

class Main {

    static int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int sumN = digitSum(n);
            int x = n + 1;

            while (true) {
                int sumX = digitSum(x);

                if (sumN % 2 != sumX % 2) {
                    System.out.println(x);
                    break;
                }

                x++;
            }
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/DIGSMPAR)