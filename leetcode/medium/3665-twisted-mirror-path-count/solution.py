class Solution:
    def uniquePaths(self, grid):
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])

        down = [0] * n
        ans = 0

        for i in range(m):
            right = 0

            for j in range(n):
                r = right
                d = down[j]
                down[j] = 0

                if i == 0 and j == 0:
                    ways = 1
                else:
                    ways = 0

                if grid[i][j] == 0:
                    ways = (ways + r + d) % MOD

                    right = ways
                    down[j] = ways

                else:
                    right = d
                    down[j] = r

            if i == m - 1:
                ans = right

        return ans % MOD