
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1000000;

        // Step 1: Precompute semi-palindrome cost
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                cost[l][r] = INF;

                // Check all proper divisors
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Divide into groups based on d
                    for (int offset = 0; offset < d; offset++) {
                        int count = (len - 1 - offset) / d + 1;

                        // Make each group a palindrome
                        for (int t = 0; t < count / 2; t++) {
                            int left = l + offset + t * d;
                            int right = l + offset + (count - 1 - t) * d;

                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }
                        }
                    }

                    cost[l][r] = Math.min(cost[l][r], changes);
                }
            }
        }

        // Step 2: Dynamic Programming
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            java.util.Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        // dp[p][i] = minimum changes to divide
        // first i characters into p substrings

        for (int p = 1; p <= k; p++) {
            for (int i = 2 * p; i <= n; i++) {

                for (int j = 2 * (p - 1); j <= i - 2; j++) {

                    if (dp[p - 1][j] == INF) {
                        continue;
                    }

                    dp[p][i] = Math.min(
                        dp[p][i],
                        dp[p - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
