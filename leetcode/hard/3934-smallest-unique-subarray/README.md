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
**Runtime:** 314 ms (beats 78.57%)  
**Memory:** 226.5 MB (beats 55.36%)  
**Submitted:** 2026-11-25T12:55:43.329Z  

```java
class Solution {
    private boolean check(int len, int[] nums){
        HashMap<Long, Integer> map = new HashMap<>();
        long base=1_000_003L;
        long hash=0, pow=1;
        for (int i=0; i < len; i++) {
            hash=hash*base + nums[i];
            if (i>0) pow *= base;
        }
        map.put(hash, 1);
        for (int i = len; i < nums.length; i++) {
            hash=(hash - nums[i - len] * pow) * base + nums[i];
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }
        for (int count : map.values()) {
            if (count == 1) return true;
        }
        return false;
    }
    public int smallestUniqueSubarray(int[] nums) {
        int n=nums.length;
        int low=1;
        int high=n;
        int ans=n;
        while(low<high){
            int mid=low+(high-low)/2;
            if(check(mid, nums)){
                high=mid;
                ans=mid;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/smallest-unique-subarray/)