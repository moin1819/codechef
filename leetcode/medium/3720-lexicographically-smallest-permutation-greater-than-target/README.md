# Lexicographically Smallest Permutation Greater Than Target

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given two strings `s` and `target`, both having length `n`, consisting of lowercase English letters.

Return the  **lexicographically smallest permutation**  of `s` that is  **strictly**  greater than `target`. If no permutation of `s` is lexicographically strictly greater than `target`, return an empty string.

A string `a` is  **lexicographically strictly greater** than a string `b` (of the same length) if in the first position where `a` and `b` differ, string `a` has a letter that appears later in the alphabet than the corresponding letter in `b`.

 

 **Example 1:** 

 **Input:**  s = "abc", target = "bba"

 **Output:**  "bca"

 **Explanation:** 

- The permutations of s (in lexicographical order) are "abc", "acb", "bac", "bca", "cab", and "cba".
- The lexicographically smallest permutation that is strictly greater than target is "bca".

 **Example 2:** 

 **Input:**  s = "leet", target = "code"

 **Output:**  "eelt"

 **Explanation:** 

- The permutations of s (in lexicographical order) are "eelt", "eetl", "elet", "elte", "etel", "etle", "leet", "lete", "ltee", "teel", "tele", and "tlee".
- The lexicographically smallest permutation that is strictly greater than target is "eelt".

 **Example 3:** 

 **Input:**  s = "baba", target = "bbaa"

 **Output:**  ""

 **Explanation:** 

- The permutations of s (in lexicographical order) are "aabb", "abab", "abba", "baab", "baba", and "bbaa".
- None of them is lexicographically strictly greater than target. Therefore, the answer is "".

 

 **Constraints:** 

- 1 <= s.length == target.length <= 300
- s and target consist of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 38.71%)  
**Memory:** 46.2 MB (beats 38.71%)  
**Submitted:** 2026-08-27T04:40:13.241Z  

```java
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';
                if (count[x] == 0) {
                    possible = false;
                    break;
                }
                count[x]--;
            }
            if (!possible) {
                continue;
            }
            int x = target.charAt(i) - 'a';
            for (int c = x + 1; c < 26; c++) {
                if (count[c] > 0) {
                    StringBuilder ans = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        ans.append(target.charAt(j));
                    }
                    ans.append((char) ('a' + c));
                    count[c]--;
                    for (int j = 0; j < 26; j++) {
                        while (count[j] > 0) {
                            ans.append((char) ('a' + j));
                            count[j]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }

        return "";
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/)