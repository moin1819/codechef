
import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        long base = 31;
        long mod = 1000000007;

        long[] pow = new long[n + 1];
        long[] prefix = new long[n + 1];

        pow[0] = 1;

        for (int i = 0; i < n; i++) {
            pow[i + 1] = (pow[i] * base) % mod;
            prefix[i + 1] = (prefix[i] * base + nums[i]) % mod;
        }

        int left = 1, right = n;
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            HashMap<Long, Integer> map = new HashMap<>();

            for (int i = 0; i + mid <= n; i++) {
                long hash = (prefix[i + mid]
                        - (prefix[i] * pow[mid]) % mod
                        + mod) % mod;

                map.put(hash, map.getOrDefault(hash, 0) + 1);
            }

            boolean found = false;

            for (int count : map.values()) {
                if (count == 1) {
                    found = true;
                    break;
                }
            }

            if (found) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
