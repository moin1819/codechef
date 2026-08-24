class Solution:
    def stoneGameVIII(self, stones: list[int]) -> int:
        # Prefix sum array
        n = len(stones)
        pref = [0] * n
        pref[0] = stones[0]
        for i in range(1, n):
            pref[i] = pref[i - 1] + stones[i]
            
        # dp[i] represents the maximum score difference a player can get
        # choosing to stop at index i or further to the right.
        # Base case: at index n - 1, the player has no choice but to take pref[n - 1]
        dp = pref[n - 1]
        
        # Traverse backwards from n - 2 down to 1
        for i in range(n - 2, 0, -1):
            dp = max(dp, pref[i] - dp)
            
        return dp