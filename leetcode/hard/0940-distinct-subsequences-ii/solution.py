class Solution:
    def distinctSubseqII(self, s: str) -> int:
        MOD = 10**9 + 7
        dp = 1  
        last = [0] * 26  
        
        for char in s:
            idx = ord(char) - ord('a')
            new_added = (dp - last[idx]) % MOD
            dp = (dp + new_added) % MOD
            last[idx] = (last[idx] + new_added) % MOD
        return (dp - 1 + MOD) % MOD