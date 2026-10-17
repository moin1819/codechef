# Subarrays Distinct Element Sum of Squares II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a  **0-indexed** integer array `nums`.

The  **distinct count**  of a subarray of `nums` is defined as:

- Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].

Return  *the sum of the  **squares**  of  **distinct counts**  of all subarrays of* `nums`.

Since the answer may be very large, return it  **modulo**  `109 + 7`.

A subarray is a contiguous  **non-empty**  sequence of elements within an array.

 

 **Example 1:** 

```
Input: nums = [1,2,1]
Output: 15
Explanation: Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 + 22 + 22 + 22 = 15.

```

 **Example 2:** 

```
Input: nums = [2,2]
Output: 3
Explanation: Three possible subarrays are:
[2]: 1 distinct value
[2]: 1 distinct value
[2,2]: 1 distinct value
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 = 3.
```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Python  
**Runtime:** 7057 ms (beats 10.34%)  
**Memory:** 51.4 MB (beats 65.52%)  
**Submitted:** 2026-10-16T14:26:24.084Z  

```py
class SegmentTree:
    def __init__(self, n, MOD=10**9 + 7):
        self.n = n
        self.MOD = MOD
        self.tree_sum = [0] * (4 * n)
        self.tree_sq_sum = [0] * (4 * n)
        self.lazy = [0] * (4 * n)

    def _apply(self, node, val, l, r):
        # Update sum of squares: new_sq_sum = sum((x + val)^2) = sq_sum + 2*val*sum + val^2 * length
        length = (r - l + 1)
        self.tree_sq_sum[node] = (
            self.tree_sq_sum[node] + 
            2 * val * self.tree_sum[node] + 
            val * val * length
        ) % self.MOD
        
        # Update linear sum
        self.tree_sum[node] = (self.tree_sum[node] + val * length) % self.MOD
        self.lazy[node] = (self.lazy[node] + val) % self.MOD

    def _push(self, node, l, r):
        if self.lazy[node] != 0:
            mid = (l + r) // 2
            self._apply(2 * node, self.lazy[node], l, mid)
            self._apply(2 * node + 1, self.lazy[node], mid + 1, r)
            self.lazy[node] = 0

    def update(self, node, l, r, ql, qr, val):
        if ql <= l and r <= qr:
            self._apply(node, val, l, r)
            return
        self._push(node, l, r)
        mid = (l + r) // 2
        if ql <= mid:
            self.update(2 * node, l, mid, ql, qr, val)
        if qr > mid:
            self.update(2 * node + 1, mid + 1, r, ql, qr, val)
        
        self.tree_sum[node] = (self.tree_sum[2 * node] + self.tree_sum[2 * node + 1]) % self.MOD
        self.tree_sq_sum[node] = (self.tree_sq_sum[2 * node] + self.tree_sq_sum[2 * node + 1]) % self.MOD

    def query_sum(self, node, l, r, ql, qr):
        if ql <= l and r <= qr:
            return self.tree_sum[node]
        self._push(node, l, r)
        mid = (l + r) // 2
        res = 0
        if ql <= mid:
            res = (res + self.query_sum(2 * node, l, mid, ql, qr)) % self.MOD
        if qr > mid:
            res = (res + self.query_sum(2 * node + 1, mid + 1, r, ql, qr)) % self.MOD
        return res

class Solution:
    def sumCounts(self, nums: list[int]) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        seg_tree = SegmentTree(n, MOD)
        last_seen = {}
        
        total_sum_sq = 0
        current_sum_sq = 0
        
        for r in range(n):
            l = last_seen.get(nums[r], -1) + 1
            
            # Query current linear sum in range [l, r]
            sub_sum = seg_tree.query_sum(1, 0, n - 1, l, r)
            
            # Update sum of squares based on the derivation
            length = (r - l + 1)
            current_sum_sq = (current_sum_sq + 2 * sub_sum + length) % MOD
            
            total_sum_sq = (total_sum_sq + current_sum_sq) % MOD
            
            # Update segment tree for range [l, r] with +1
            seg_tree.update(1, 0, n - 1, l, r, 1)
            last_seen[nums[r]] = r
            
        return total_sum_sq
```

---

[View on LeetCode](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/)