class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        
        # Step 1: Precompute binomial coefficients using Pascal's Triangle
        c = [[0] * n for _ in range(n)]
        for i in range(n):
            c[i][0] = 1
            for j in range(1, i + 1):
                c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD
                
        def dfs(arr):
            if len(arr) <= 2:
                return 1
            
            root = arr[0]
            left = [x for x in arr[1:] if x < root]
            right = [x for x in arr[1:] if x > root]
            
            l_res = dfs(left)
            r_res = dfs(right)
            
            # Combine ways using combinations: C(left_len + right_len, left_len)
            left_len = len(left)
            right_len = len(right)
            ways = c[left_len + right_len][left_len]
            
            res = (ways * l_res) % MOD
            res = (res * r_res) % MOD
            return res

        # Subtract 1 to exclude the original array ordering
        return (dfs(nums) - 1 + MOD) % MOD