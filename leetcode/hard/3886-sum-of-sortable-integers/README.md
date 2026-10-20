# Sum of Sortable Integers

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` of length `n`.

An integer `k` is called  **sortable**  if `k`  **divides**  `n` and you can sort `nums` in  **non-decreasing**  order by sequentially performing the following operations:

- Partition nums into consecutive subarrays of length k.
- Cyclically rotate each subarray independently any number of times to the left or to the right.

Return an integer denoting the sum of all possible sortable integers `k`.

 

 **Example 1:** 

 **Input:**  nums = [3,1,2]

 **Output:**  3

 **Explanation:** ​​​​​​​

- For n = 3, possible divisors are 1 and 3.
- For k = 1: each subarray has one element. No rotation can sort the array.
- For k = 3: the single subarray [3, 1, 2] can be rotated once to produce [1, 2, 3], which is sorted.
- Only k = 3 is sortable. Hence, the answer is 3.

 **Example 2:** 

 **Input:**  nums = [7,6,5]

 **Output:**  0

 **Explanation:** 

- For n = 3, possible divisors are 1 and 3.
- For k = 1: each subarray has one element. No rotation can sort the array.
- For k = 3: the single subarray [7, 6, 5] cannot be rotated into non-decreasing order.
- No k is sortable. Hence, the answer is 0.

 **Example 3:** 

 **Input:**  nums = [5,8]

 **Output:**  3

 **Explanation:** ​​​​​​​

- For n = 2, possible divisors are 1 and 2.
- Since [5, 8] is already sorted, every divisor is sortable. Hence, the answer is 1 + 2 = 3.

 

 **Constraints:** 

- 1 <= n == nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 58 ms (beats 54.55%)  
**Memory:** 70.1 MB (beats 88.64%)  
**Submitted:** 2026-10-20T17:14:45.823Z  

```java
import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Precompute information to check block conditions in O(1) or O(k)
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;

            for (int i = 0; i < n; i += k) {
                int dropCount = 0;

                // Check block internal properties
                for (int j = 0; j < k; j++) {
                    if (j > 0) {
                        if (nums[i + j - 1] > nums[i + j]) {
                            dropCount++;
                        }
                    }
                }

                // Cyclic check: A block can be rotated to sorted order if:
                // 1. dropCount == 0 (already sorted)
                // 2. dropCount == 1, and nums[i + k - 1] <= nums[i] (rotation boundary condition)
                boolean blockSortable = false;
                if (dropCount == 0) {
                    blockSortable = true;
                } else if (dropCount == 1 && nums[i + k - 1] <= nums[i]) {
                    boolean match = true;
                    int splitIdx = -1;
                    for (int j = 1; j < k; j++) {
                        if (nums[i + j - 1] > nums[i + j]) {
                            splitIdx = i + j;
                            break;
                        }
                    }
                    // Verify the rotated segments
                    for (int j = 0; j < k - 1; j++) {
                        int idx1 = i + (j + (splitIdx - i)) % k;
                        int idx2 = i + (j + 1 + (splitIdx - i)) % k;
                        if (nums[idx1] > nums[idx2]) {
                            match = false;
                            break;
                        }
                    }
                    blockSortable = match;
                }

                if (!blockSortable) {
                    valid = false;
                    break;
                }

                // Find the actual min and max of this block after rotation
                int bMin = nums[i], bMax = nums[i];
                for (int j = 0; j < k; j++) {
                    bMin = Math.min(bMin, nums[i + j]);
                    bMax = Math.max(bMax, nums[i + j]);
                }

                if (bMin < prevMax) {
                    valid = false;
                    break;
                }
                prevMax = bMax;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-sortable-integers/)