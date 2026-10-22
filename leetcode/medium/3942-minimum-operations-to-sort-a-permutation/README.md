# Minimum Operations to Sort a Permutation

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` of length `n`, where `nums` is a permutation of the integers from 0 to `n - 1`.

You may perform  **only**  the following operations:

- Reverse the entire array.
- Rotate Left by One: Move the first element to the end of the array, and rest elements to left by one position.

Return an integer denoting the  **minimum**  number of operations required to sort the array in  **increasing**  order. If it is  **not possible**  to sort the array using only the given operations, return -1.

 

 **Example 1:** 

 **Input:**  nums = [0,2,1]

 **Output:**  2

 **Explanation:** 

- Rotate Left by one: [2, 1, 0]
- Reverse the array: [0, 1, 2]

The array becomes sorted in 2 operations, which is minimal

 **Example 2:** 

 **Input:**  nums = [1,0,2]

 **Output:**  2

 **Explanation:** 

- Reverse the array: [2, 0, 1]
- Rotate Left by one: [0, 1, 2]

The array becomes sorted in 2 operations, which is minimal.

 **Example 3:** 

 **Input:**  nums = [2,0,1,3]

 **Output:**  -1

 **Explanation:** 

It is impossible to reach `[2, 0, 1, 3]`. Thus, the answer is -1.

 

 **Constraints:** 

- 1 <= n == nums.length <= 105
- 0 <= nums[i] <= n - 1
- nums is a permutation of integers from 0 to n - 1.

## Solution

**Language:** Python  
**Runtime:** 167 ms (beats 14.61%)  
**Memory:** 31.3 MB (beats 86.52%)  
**Submitted:** 2026-10-22T17:35:38.041Z  

```py
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        i0 = nums.index(0)

        inc = True
        dec = True

        for i in range(n):
            if nums[(i + 1) % n] != (nums[i] + 1) % n:
                inc = False

            if nums[(i + 1) % n] != (nums[i] - 1) % n:
                dec = False

        if inc:
            return min(i0, n - i0 + 2)

        if dec:
            return min(i0 + 2, n - i0)

        return -1
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/)