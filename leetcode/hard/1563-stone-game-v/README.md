# Stone Game V

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

There are several stones  **arranged in a row**, and each stone has an associated value which is an integer given in the array `stoneValue`.

In each round of the game, Alice divides the row into  **two non-empty rows**  (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.

The game ends when there is only  **one stone remaining**. Alice's score is initially  **zero**.

Return  *the maximum score that Alice can obtain*.

 

 **Example 1:** 

```
Input: stoneValue = [6,2,3,4,5,5]
Output: 18
Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5]. The left row has the value 11 and the right row has value 14. Bob throws away the right row and Alice's score is now 11.
In the second round Alice divides the row to [6], [2,3]. This time Bob throws away the left row and Alice's score becomes 16 (11 + 5).
The last round Alice has only one choice to divide the row which is [2], [3]. Bob throws away the right row and Alice's score is now 18 (16 + 2). The game ends because only one stone is remaining in the row.

```

 **Example 2:** 

```
Input: stoneValue = [7,7,7,7,7,7,7]
Output: 28

```

 **Example 3:** 

```
Input: stoneValue = [4]
Output: 0

```

 

 **Constraints:** 

- 1 <= stoneValue.length <= 500
- 1 <= stoneValue[i] <= 106

## Solution

**Language:** Java  
**Runtime:** 305 ms (beats 25.48%)  
**Memory:** 47.4 MB (beats 87.74%)  
**Submitted:** 2026-08-17T14:49:31.172Z  

```java
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stoneValue[i];
        }
        int[][] dp = new int[n][n];

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                int maxScore = 0;

                for (int k = i; k < j; k++) {
                    int leftSum = pref[k + 1] - pref[i];
                    int rightSum = pref[j + 1] - pref[k + 1];

                    if (leftSum < rightSum) {
                        maxScore = Math.max(maxScore, leftSum + dp[i][k]);
                    } else if (leftSum > rightSum) {
                        maxScore = Math.max(maxScore, rightSum + dp[k + 1][j]);
                    } else {
                        maxScore = Math.max(maxScore, leftSum + Math.max(dp[i][k], dp[k + 1][j]));
                    }
                }
                dp[i][j] = maxScore;
            }
        }

        return dp[0][n - 1];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/stone-game-v/)