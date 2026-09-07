# Distinct Subsequences II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string s, return  *the number of  **distinct non-empty subsequences**  of*  `s`. Since the answer may be very large, return it  **modulo**  `109 + 7`.

A  **subsequence**  of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence of `"abcde"` while `"aec"` is not.

 

 **Example 1:** 

```
Input: s = "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".

```

 **Example 2:** 

```
Input: s = "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".

```

 **Example 3:** 

```
Input: s = "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".

```

 

 **Constraints:** 

- 1 <= s.length <= 2000
- s consists of lowercase English letters.

## Solution

**Language:** Python  
**Runtime:** 7 ms (beats 89.58%)  
**Memory:** 19.3 MB (beats 72.40%)  
**Submitted:** 2026-09-07T13:25:15.776Z  

```py
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
```

---

[View on LeetCode](https://leetcode.com/problems/distinct-subsequences-ii/)