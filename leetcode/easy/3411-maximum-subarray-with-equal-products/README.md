# Maximum Subarray With Equal Products

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given an array of  **positive**  integers `nums`.

An array `arr` is called  **product equivalent**  if `prod(arr) == lcm(arr) * gcd(arr)`, where:

- prod(arr) is the product of all elements of arr.
- gcd(arr) is the GCD of all elements of arr.
- lcm(arr) is the LCM of all elements of arr.

Return the length of the  **longest**   **product equivalent**  subarray of `nums`.

 

Original
Java
 **Example 1:** 

 **Input:**  nums = [1,2,1,2,1,1,1]

 **Output:**  5

 **Explanation:**  

The longest product equivalent subarray is `[1, 2, 1, 1, 1]`, where `prod([1, 2, 1, 1, 1]) = 2`, `gcd([1, 2, 1, 1, 1]) = 1`, and `lcm([1, 2, 1, 1, 1]) = 2`.

 **Example 2:** 

 **Input:**  nums = [2,3,4,5,6]

 **Output:**  3

 **Explanation:**  

The longest product equivalent subarray is `[3, 4, 5].`

 **Example 3:** 

 **Input:**  nums = [1,2,3,1,4,5,1]

 **Output:**  5

 

 **Constraints:** 

- 2 <= nums.length <= 100
- 1 <= nums[i] <= 10

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 52.63%)  
**Memory:** 43.9 MB (beats 53.16%)  
**Submitted:** 2026-11-24T02:43:07.607Z  

```java

class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long lcm = 1;
            int gcd = 0;

            for (int j = i; j < n; j++) {
                prod *= nums[j];

                gcd = findGCD(gcd, nums[j]);
                lcm = findLCM(lcm, nums[j]);

                if (prod == lcm * gcd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }

    long findLCM(long a, int b) {
        return (a / findGCD((int)a, b)) * b;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/maximum-subarray-with-equal-products/)