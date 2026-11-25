# Smallest Unique Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums`.

Find the  **minimum** length of a subarray that is  **not**   **identical**  to any other  **subarray**  in `nums`.

Return an integer denoting the  **minimum possible length**  of such a  **subarray**.

Two  **subarrays**  are considered identical if they have the same length and the same elements in corresponding positions.

 

Original
Java
 **Example 1:** 

 **Input:**  nums = [3,3,3]

 **Output:**  3

 **Explanation:** 

- Subarrays of length 1: [3] → appears 3 times
- Subarrays of length 2: [3, 3] → appears 2 times
- Subarrays of length 3: [3, 3, 3] → appears once

The subarray `[3, 3, 3]` is unique, so the smallest unique subarray length is 3.

 **Example 2:** 

 **Input:**  nums = [2,1,2,3,3]

 **Output:**  1

 **Explanation:** 

Subarrays of length 1:

- [2] → appears 2 times
- [1] → appears once
- [3] → appears 2 times
The subarray `[1]` is unique, so the smallest unique subarray length is 1.

 **Example 3:** 

 **Input:**  nums = [1,1,2,2,1]

 **Output:**  2

 **Explanation:** 

Subarrays of length 1:

- [1] → appears 3 times
- [2] → appears 2 times

Subarrays of length 2:

- [1, 1] → appears once
- [1, 2] → appears once
- [2, 2] → appears once
- [2, 1] → appears once
There is at least one subarray of length 2 that is unique, so the smallest unique subarray length is 2.

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 41.3 MB  
**Submitted:** 2026-11-25T12:52:25.318Z  

```java

import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long base = 31;
        long mod = 1000000007;

        long[] pow = new long[n + 1];
        long[] prefix = new long[n + 1];

        pow[0] = 1;

        for (int i = 0; i < n; i++) {
            pow[i + 1] = (pow[i] * base) % mod;
            prefix[i + 1] = (prefix[i] * base + nums[i]) % mod;
        }

        int left = 1, right = n;
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            HashMap<Long, Integer> map = new HashMap<>();

            for (int i = 0; i + mid <= n; i++) {
                long hash = (prefix[i + mid]
                        - (prefix[i] * pow[mid]) % mod
                        + mod) % mod;

                map.put(hash, map.getOrDefault(hash, 0) + 1);
            }

            boolean found = false;

            for (int count : map.values()) {
                if (count == 1) {
                    found = true;
                    break;
                }
            }

            if (found) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/smallest-unique-subarray/)