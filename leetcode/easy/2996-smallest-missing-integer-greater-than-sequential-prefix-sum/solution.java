import java.util.HashSet;
import java.util.Set;
class Solution {
    public int missingInteger(int[] nums) {
        int seqSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                seqSum += nums[i];
            } else {
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(seqSum)) {
            seqSum++;
        }
        return seqSum;
    }
}