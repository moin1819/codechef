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