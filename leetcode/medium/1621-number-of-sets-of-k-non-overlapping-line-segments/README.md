# Number of Sets of K Non-Overlapping Line Segments

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given `n` points on a 1-D plane, where the `ith` point (from `0` to `n-1`) is at `x = i`, find the number of ways we can draw  **exactly**  `k`  **non-overlapping**  line segments such that each segment covers two or more points. The endpoints of each segment must have  **integral coordinates**. The `k` line segments  **do not**  have to cover all `n` points, and they are  **allowed**  to share endpoints.

Return  *the number of ways we can draw* `k` *non-overlapping line segments **.*  Since this number can be huge, return it** modulo** `109 + 7`.

 

 **Example 1:** 

```
Input: n = 4, k = 2
Output: 5
Explanation: The two line segments are shown in red and blue.
The image above shows the 5 different ways {(0,2),(2,3)}, {(0,1),(1,3)}, {(0,1),(2,3)}, {(1,2),(2,3)}, {(0,1),(1,2)}.

```

 **Example 2:** 

```
Input: n = 3, k = 1
Output: 3
Explanation: The 3 ways are {(0,1)}, {(0,2)}, {(1,2)}.

```

 **Example 3:** 

```
Input: n = 30, k = 7
Output: 796297179
Explanation: The total number of possible ways to draw 7 line segments is 3796297200. Taking this number modulo 109 + 7 gives us 796297179.

```

 

 **Constraints:** 

- 2 <= n <= 1000
- 1 <= k <= n-1

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.3 MB (beats 84.52%)  
**Submitted:** 2026-09-16T18:48:07.952Z  

```java
class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        
        int N = n + k - 1;
        int R = 2 * k;
        
        if (R > N) {
            return 0;
        }
        
        long num = 1;
        long den = 1;
        
        for (int i = 1; i <= R; i++) {
            num = (num * (N - i + 1)) % MOD;
            den = (den * i) % MOD;
        }
        
        // Compute (num * den^(-1)) % MOD using Fermat's Little Theorem
        return (int) ((num * power(den, MOD - 2, MOD)) % MOD);
    }
    
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/)