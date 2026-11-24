
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long lcm = 1;
            int gcd = 0;

            for (int j = i; j < n; j++) {
                prod *= nums[j];

                gcd = findGCD(gcd, nums[j]);
                lcm = findLCM(lcm, nums[j]);

                if (prod == lcm * gcd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b, a % b);
    }

    long findLCM(long a, int b) {
        return (a / findGCD((int)a, b)) * b;
    }
}
