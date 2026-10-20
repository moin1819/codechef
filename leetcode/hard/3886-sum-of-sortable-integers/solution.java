import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // Precompute information to check block conditions in O(1) or O(k)
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;

            for (int i = 0; i < n; i += k) {
                int dropCount = 0;

                // Check block internal properties
                for (int j = 0; j < k; j++) {
                    if (j > 0) {
                        if (nums[i + j - 1] > nums[i + j]) {
                            dropCount++;
                        }
                    }
                }

                // Cyclic check: A block can be rotated to sorted order if:
                // 1. dropCount == 0 (already sorted)
                // 2. dropCount == 1, and nums[i + k - 1] <= nums[i] (rotation boundary condition)
                boolean blockSortable = false;
                if (dropCount == 0) {
                    blockSortable = true;
                } else if (dropCount == 1 && nums[i + k - 1] <= nums[i]) {
                    boolean match = true;
                    int splitIdx = -1;
                    for (int j = 1; j < k; j++) {
                        if (nums[i + j - 1] > nums[i + j]) {
                            splitIdx = i + j;
                            break;
                        }
                    }
                    // Verify the rotated segments
                    for (int j = 0; j < k - 1; j++) {
                        int idx1 = i + (j + (splitIdx - i)) % k;
                        int idx2 = i + (j + 1 + (splitIdx - i)) % k;
                        if (nums[idx1] > nums[idx2]) {
                            match = false;
                            break;
                        }
                    }
                    blockSortable = match;
                }

                if (!blockSortable) {
                    valid = false;
                    break;
                }

                // Find the actual min and max of this block after rotation
                int bMin = nums[i], bMax = nums[i];
                for (int j = 0; j < k; j++) {
                    bMin = Math.min(bMin, nums[i + j]);
                    bMax = Math.max(bMax, nums[i + j]);
                }

                if (bMin < prevMax) {
                    valid = false;
                    break;
                }
                prevMax = bMax;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}