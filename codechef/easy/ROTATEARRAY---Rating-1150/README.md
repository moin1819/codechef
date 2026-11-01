# ROTATEARRAY - Rating 1150

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Rotate the array

You are given an integer array $nums$. Rotate the array to the right by $k$ positions, where $k$ is a non-negative integer.
 ***For example** *:
Given the array [10, 20, 30, 40, 50], rotating it two times to the right results in:
First rotation - [50, 10, 20, 30, 40]
Second rotation - [40, 50, 10, 20, 30]
You need to implement a solution that operates  **in-place**  and uses only  **$O(1)$**  additional space.
You don’t need to print any values; simply edit the values of the array.

## Function Declaration
### Function Name

$rotate$ – This function rotates an array to the right by $k$ positions in-place.

### Parameters
- $nums$ : An array of integers.
- $k$ : A non-negative integer representing the number of right rotations.
### Return Value
- This function does not return anything.
- The array $nums$ is modified in-place.
## Constraints
- $1 \leq nums.length \leq 10^5$
- $−2^\text{31} \leq nums[i] \leq 2^\text{31} − 1$
- $0 \leq k \leq 10^9$
- Rotation must be done using O(1) extra space
#### Follow up:
- Can you think of multiple approaches to solve this problem? (There are at least three different strategies.)
### Input Format
- The first line contains two integers $N$ and $K$ — the size of the array and the number of right rotations.
- The second line contains $N$ space-separated integers representing the array elements.
### Output Format
- Print the rotated array in a line (space-separated).
### Sample 1:
Input
Output

```
5 2
10 20 30 40 50
```

```
40 50 10 20 30
```

### Explanation:

rotate 1 step to the right: [50,10,20,30,40]
rotate 2 steps to the right: [40,50,10,20,30]

### Sample 2:
Input
Output

```
5 3
7 8 9 1 2
```

```
9 1 2 7 8
```

### Explanation:

rotate 1 step to the right: [2,7,8,9,1]
rotate 2 steps to the right: [1,2,7,8,9]
rotate 3 steps to the right: [9,1,2,7,8]

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T15:23:02.546Z  

```java

static void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;

    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
}

static void reverse(int[] nums, int left, int right) {
    while (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        left++;
        right--;
    }
}

```

---

[View on CodeChef](https://www.codechef.com/problems/ROTATEARRAY)