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