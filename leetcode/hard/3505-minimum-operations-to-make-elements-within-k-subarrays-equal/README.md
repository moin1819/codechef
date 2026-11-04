# Minimum Operations to Make Elements Within K Subarrays Equal

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` and two integers, `x` and `k`. You can perform the following operation any number of times (**including zero**):

- Increase or decrease any element of nums by 1.

Return the  **minimum**  number of operations needed to have  **at least**  `k`  *non-overlapping subarrays*  of size  **exactly**  `x` in `nums`, where all elements within each subarray are equal.

 

 **Example 1:** 

 **Input:**  nums = [5,-2,1,3,7,3,6,4,-1], x = 3, k = 2

 **Output:**  8

 **Explanation:** 

- Use 3 operations to add 3 to nums[1] and use 2 operations to subtract 2 from nums[3]. The resulting array is [5, 1, 1, 1, 7, 3, 6, 4, -1].
- Use 1 operation to add 1 to nums[5] and use 2 operations to subtract 2 from nums[6]. The resulting array is [5, 1, 1, 1, 7, 4, 4, 4, -1].
- Now, all elements within each subarray [1, 1, 1] (from indices 1 to 3) and [4, 4, 4] (from indices 5 to 7) are equal. Since 8 total operations were used, 8 is the output.

 **Example 2:** 

 **Input:**  nums = [9,-2,-2,-2,1,5], x = 2, k = 2

 **Output:**  3

 **Explanation:** 

- Use 3 operations to subtract 3 from nums[4]. The resulting array is [9, -2, -2, -2, -2, 5].
- Now, all elements within each subarray [-2, -2] (from indices 1 to 2) and [-2, -2] (from indices 3 to 4) are equal. Since 3 operations were used, 3 is the output.

 

 **Constraints:** 

- 2 <= nums.length <= 105
- -106 <= nums[i] <= 106
- 2 <= x <= nums.length
- 1 <= k <= 15
- 2 <= k * x <= nums.length

## Solution

**Language:** Java  
**Runtime:** 782 ms (beats 44.74%)  
**Memory:** 257.1 MB (beats 7.89%)  
**Submitted:** 2026-11-04T04:56:14.822Z  

```java
import java.util.*;

class Solution {

    class SlidingMedian {
        PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> high = new PriorityQueue<>();

        Map<Integer, Integer> delayed = new HashMap<>();

        int lowSize = 0, highSize = 0;
        long lowSum = 0, highSum = 0;

        void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int val = heap.peek();

                if (delayed.getOrDefault(val, 0) == 0)
                    break;

                heap.poll();
                delayed.put(val, delayed.get(val) - 1);
            }
        }

        void rebalance() {
            prune(low);
            prune(high);

            while (lowSize > highSize + 1) {
                int val = low.poll();
                lowSum -= val;
                lowSize--;

                high.offer(val);
                highSum += val;
                highSize++;

                prune(low);
            }

            while (lowSize < highSize) {
                int val = high.poll();
                highSum -= val;
                highSize--;

                low.offer(val);
                lowSum += val;
                lowSize++;

                prune(high);
            }
        }

        void add(int val) {
            prune(low);

            if (low.isEmpty() || val <= low.peek()) {
                low.offer(val);
                lowSum += val;
                lowSize++;
            } else {
                high.offer(val);
                highSum += val;
                highSize++;
            }

            rebalance();
        }

        void remove(int val) {
            prune(low);

            delayed.put(val, delayed.getOrDefault(val, 0) + 1);

            if (val <= low.peek()) {
                lowSum -= val;
                lowSize--;

                if (val == low.peek())
                    prune(low);
            } else {
                highSum -= val;
                highSize--;

                if (!high.isEmpty() && val == high.peek())
                    prune(high);
            }

            rebalance();
        }

        long cost() {
            prune(low);

            long median = low.peek();

            return median * lowSize - lowSum
                    + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        SlidingMedian sm = new SlidingMedian();

        long[] costs = new long[n - x + 1];

        for (int i = 0; i < n; i++) {

            sm.add(nums[i]);

            if (i >= x) {
                sm.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                costs[i - x + 1] = sm.cost();
            }
        }

        int m = costs.length;

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[m + 1][k + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= k; j++) {

                dp[i][j] = dp[i - 1][j];

                int prev = Math.max(0, i - x);

                if (dp[prev][j - 1] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[prev][j - 1] + costs[i - 1]
                    );
                }
            }
        }

        return dp[m][k];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/)