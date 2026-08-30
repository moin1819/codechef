class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int a = Math.min(minIdx, maxIdx);
        int b = Math.max(minIdx, maxIdx);
        int op1 = b + 1;
        int op2 = n - a;
        int op3 = (a + 1) + (n - b);

        return Math.min(op1, Math.min(op2, op3));
    }
}