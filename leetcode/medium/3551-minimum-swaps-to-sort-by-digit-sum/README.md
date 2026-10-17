# Minimum Swaps to Sort by Digit Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array `nums` of  **distinct**  positive integers. You need to sort the array in  **increasing**  order based on the sum of the digits of each number. If two numbers have the same digit sum, the  **smaller**  number appears first in the sorted order.

Return the  **minimum**  number of swaps required to rearrange `nums` into this sorted order.

A  **swap**  is defined as exchanging the values at two distinct positions in the array.

 

 **Example 1:** 

 **Input:**  nums = [37,100]

 **Output:**  1

 **Explanation:** 

- Compute the digit sum for each integer: [3 + 7 = 10, 1 + 0 + 0 = 1] → [10, 1]
- Sort the integers based on digit sum: [100, 37]. Swap 37 with 100 to obtain the sorted order.
- Thus, the minimum number of swaps required to rearrange nums is 1.

 **Example 2:** 

 **Input:**  nums = [22,14,33,7]

 **Output:**  0

 **Explanation:** 

- Compute the digit sum for each integer: [2 + 2 = 4, 1 + 4 = 5, 3 + 3 = 6, 7 = 7] → [4, 5, 6, 7]
- Sort the integers based on digit sum: [22, 14, 33, 7]. The array is already sorted.
- Thus, the minimum number of swaps required to rearrange nums is 0.

 **Example 3:** 

 **Input:**  nums = [18,43,34,16]

 **Output:**  2

 **Explanation:** 

- Compute the digit sum for each integer: [1 + 8 = 9, 4 + 3 = 7, 3 + 4 = 7, 1 + 6 = 7] → [9, 7, 7, 7]
- Sort the integers based on digit sum: [16, 34, 43, 18]. Swap 18 with 16, and swap 43 with 34 to obtain the sorted order.
- Thus, the minimum number of swaps required to rearrange nums is 2.

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 109
- nums consists of distinct positive integers.

## Solution

**Language:** Python  
**Runtime:** 1551 ms (beats 12.39%)  
**Memory:** 48.8 MB (beats 35.40%)  
**Submitted:** 2026-10-17T17:28:46.756Z  

```py
class Solution:
    def minSwaps(self, nums: list[int]) -> int:
        def get_digit_sum(n: int) -> int:
            return sum(int(c) for c in str(n))
        
        n = len(nums)
        
        # Sort nums based on digit sum (primary) and value (secondary)
        sorted_nums = sorted(nums, key=lambda x: (get_digit_sum(x), x))
        
        # Map each value to its target index in the sorted array
        val_to_index = {val: i for i, val in enumerate(sorted_nums)}
        
        visited = [False] * n
        swaps = 0
        
        for i in range(n):
            if visited[i] or nums[i] == sorted_nums[i]:
                continue
            
            # Traverse the cycle
            cycle_length = 0
            curr = i
            while not visited[curr]:
                visited[curr] = True
                curr = val_to_index[nums[curr]]
                cycle_length += 1
            
            if cycle_length > 1:
                swaps += (cycle_length - 1)
                
        return swaps
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/)