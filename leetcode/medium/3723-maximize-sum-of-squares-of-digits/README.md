# Maximize Sum of Squares of Digits

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two  **positive**  integers `num` and `sum`.

A positive integer `n` is  **good**  if it satisfies both of the following:

- The number of digits in n is exactly num.
- The sum of digits in n is exactly sum.

The  **score**  of a  **good**  integer `n` is the sum of the squares of digits in `n`.

Return a  **string**  denoting the  **good**  integer `n` that achieves the  **maximum**   **score**. If there are multiple possible integers, return the  **maximum** ​​​​​​​one. If no such integer exists, return an empty string.

 

 **Example 1:** 

 **Input:**  num = 2, sum = 3

 **Output:**  "30"

 **Explanation:** 

There are 3 good integers: 12, 21, and 30.

- The score of 12 is 12 + 22 = 5.
- The score of 21 is 22 + 12 = 5.
- The score of 30 is 32 + 02 = 9.

The maximum score is 9, which is achieved by the good integer 30. Therefore, the answer is `"30"`.

 **Example 2:** 

 **Input:**  num = 2, sum = 17

 **Output:**  "98"

 **Explanation:** 

There are 2 good integers: 89 and 98.

- The score of 89 is 82 + 92 = 145.
- The score of 98 is 92 + 82 = 145.

The maximum score is 145. The maximum good integer that achieves this score is 98. Therefore, the answer is `"98"`.

 **Example 3:** 

 **Input:**  num = 1, sum = 10

 **Output:**  ""

 **Explanation:** 

There are no integers that have exactly 1 digit and whose digits sum to 10. Therefore, the answer is `""`.

 

 **Constraints:** 

- 1 <= num <= 2 * 105
- 1 <= sum <= 2 * 106

## Solution

**Language:** Python  
**Runtime:** 1 ms (beats 79.53%)  
**Memory:** 21.1 MB (beats 59.06%)  
**Submitted:** 2026-10-14T13:13:52.376Z  

```py
class Solution:

  def maxSumOfSquares(self, num: int, sum: int) -> str:
    # Check if the sum is out of the possible range
    if sum < 0 or sum > 9 * num:
      return ""

    q = sum // 9
    r = sum % 9

    # Build the string with 9s first, then the remainder digit, then 0s
    result = []
    result.append("9" * q)
    if r > 0:
      result.append(str(r))

    zeros_needed = num - q - (1 if r > 0 else 0)
    result.append("0" * zeros_needed)

    return "".join(result)
```

---

[View on LeetCode](https://leetcode.com/problems/maximize-sum-of-squares-of-digits/)