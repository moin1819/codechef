# PSEUDOSORT - Rating 1067

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Pseudo Sorted Array

An array $A$ of length $N$ is said to be  *pseudo-sorted*  if it can be made non-decreasing after performing the following operation  **at most once**.

- Choose an $i$ such that $1 \le i \leq N-1$ and swap $A_i$ and $A_{i+1}$

Given an array $A$, determine if it is  *pseudo-sorted*  or not.

### Input Format
- The first line contains a single integer $T$ - the number of test cases. Then the test cases follow.
- The first line of each test case contains an integer $N$ - the size of the array $A$.
- The second line of each test case contains $N$ space-separated integers $A_1, A_2, \dots, A_N$ denoting the array $A$.
### Output Format

For each testcase, output `YES` if the array $A$ is pseudo-sorted, `NO` otherwise.

You may print each character of `YES` and `NO` in uppercase or lowercase (for example, `yes`, `yEs`, `Yes` will be considered identical).

### Constraints
- $1 \leq T \leq 1000$
- $2 \leq N \leq 10^5$
- $1 \leq A_i \leq 10^9$
- Sum of $N$ over all test cases do not exceed $2 \cdot 10^5$
### Sample 1:
Input
Output

```
3
5
3 5 7 8 9
4
1 3 2 3
3
3 2 1

```

```
YES
YES
NO

```

### Explanation:

 **Test case 1:**  The array is already sorted in non-decreasing order.

 **Test case 2:**  We can choose $i = 2$ and swap $A_2$ and $A_3$. The resulting array will be $[1, 2, 3, 3]$, which is sorted in non-decreasing order.

 **Test case 3:**  It can be proven that the array cannot be sorted in non-decreasing order in at most one operation.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-07T12:55:50.842Z  

```java

import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int count = 0;

            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    count++;
                }
            }

            if (count <= 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/PSEUDOSORT)