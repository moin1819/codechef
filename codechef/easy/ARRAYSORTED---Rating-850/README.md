# ARRAYSORTED - Rating 850

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Check if the array is sorted

Given an array $nums$ which is rotated. You have to find out if the given array is sorted and rotated.

An array is considered  **sorted and rotated**  if:

- There exists a non-decreasing sorted array $A$.
- After rotating $A$ by some $k$ positions (possibly $k = 0$), we obtain the given array $nums$.
- Rotation means some suffix of $A$ is moved to the front, keeping the relative order of elements.

Duplicates are allowed in the array.

 **Note:** 
If $A$ is the original sorted array and it is rotated  **right**  by $k$ positions, the resulting array $B$ satisfies:

$$ B[(i+k) \bmod A.length] = A[i] $$

for every valid index $i$.
`1 2 3 4 5` is a sorted array and `2 3 4 5 1` is also a sorted array but after 4 rotations.

## Function Declaration
### Function Name

$check$ – This function checks whether a given array $nums$ is a non-decreasing sorted array that has been rotated any number of times (including zero rotations).

### Parameters
- $nums$ : A reference to a vector of integers representing the array.
### Return Value
- Returns $true$ if the array $nums$ can be obtained by rotating a non-decreasing sorted array.
- Returns $false$ otherwise.
## Constraints
- $1 \leq \text{nums.length} \leq 10^5$
- $1 \leq \text{nums}[i] \leq 100$
### Input Format
- The first line contains an integer $N$ — the size of the array.
- The second line contains $N$ space-separated integers — the elements of the array $nums$.
### Output Format
- $true$ if the array is sorted in non-decreasing order and then rotated any number of times (including zero). $false$ otherwise.
### Sample 1:
Input
Output

```
7
6 7 1 2 3 4 5
```

```
true
```

### Explanation:

The original sorted array was `[1,2,3,4,5,6,7]`.
Rotating by `k = 2` positions gives `[6,7,1,2,3,4,5]`.

### Sample 2:
Input
Output

```
5
68 97 10 21 45

```

```
true

```

### Explanation:

The original sorted array `[10,21,45,68,97]` rotated by `k = 2` results in `[68,97,10,21,45]`.

### Sample 3:
Input
Output

```
5
4 5 2 3 1
```

```
false
```

### Explanation:

No rotation of a sorted array can produce this order.

## Solution

**Language:** Python  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-31T06:08:00.481Z  

```py
class Solution:
    def check(self, nums):
        count = 0
        n = len(nums)

        for i in range(n):
            if nums[i] > nums[(i + 1) % n]:
                count += 1

        return count <= 1
```

---

[View on CodeChef](https://www.codechef.com/problems/ARRAYSORTED)