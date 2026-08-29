# Lexicographically Smallest Palindromic Permutation Greater Than Target

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given two strings `s` and `target`, each of length `n`, consisting of lowercase English letters.

Return the  **lexicographically smallest string**  that is  **both**  a  **palindromic permutation**  of `s` and  **strictly**  greater than `target`. If no such permutation exists, return an empty string.

 

 **Example 1:** 

 **Input:**  s = "baba", target = "abba"

 **Output:**  "baab"

 **Explanation:** 

- The palindromic permutations of s (in lexicographical order) are "abba" and "baab".
- The lexicographically smallest permutation that is strictly greater than target is "baab".

 **Example 2:** 

 **Input:**  s = "baba", target = "bbaa"

 **Output:**  ""

 **Explanation:** 

- The palindromic permutations of s (in lexicographical order) are "abba" and "baab".
- None of them is lexicographically strictly greater than target. Therefore, the answer is "".

 **Example 3:** 

 **Input:**  s = "abc", target = "abb"

 **Output:**  ""

 **Explanation:** 

`s` has no palindromic permutations. Therefore, the answer is `""`.

 **Example 4:** 

 **Input:**  s = "aac", target = "abb"

 **Output:**  "aca"

 **Explanation:** 

- The only palindromic permutation of s is "aca".
- "aca" is strictly greater than target. Therefore, the answer is "aca".

 

 **Constraints:** 

- 1 <= n == s.length == target.length <= 300
- s and target consist of only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 66.67%)  
**Memory:** 47.2 MB (beats 47.62%)  
**Submitted:** 2026-08-28T17:59:26.680Z  

```java
class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Check whether palindrome is possible
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Build the left half
        StringBuilder halfBuilder = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                halfBuilder.append((char) ('a' + i));
            }
        }

        String half = halfBuilder.toString();
        int m = half.length();

        /*
         * CASE 1:
         * The left half can be exactly equal to target's
         * first half.
         *
         * This is important for cases like:
         *
         * s = "aabb"
         * target = "baaa"
         *
         * left = "ba"
         * palindrome = "baab"
         */
        if (m <= n) {

            int[] available = new int[26];

            for (char c : half.toCharArray()) {
                available[c - 'a']++;
            }

            boolean possible = true;

            // Check whether target's first half can be formed
            for (int i = 0; i < m; i++) {

                int c = target.charAt(i) - 'a';

                if (available[c] == 0) {
                    possible = false;
                    break;
                }

                available[c]--;
            }

            if (possible) {

                String targetHalf = target.substring(0, m);

                String equalCandidate =
                    makePalindrome(targetHalf, middle);

                if (equalCandidate.compareTo(target) > 0) {
                    return equalCandidate;
                }
            }
        }

        /*
         * CASE 2:
         * Find the smallest left half that is greater than
         * target's first half.
         *
         * Change the rightmost possible position.
         */
        for (int pos = m - 1; pos >= 0; pos--) {

            int[] available = new int[26];

            for (char c : half.toCharArray()) {
                available[c - 'a']++;
            }

            // Match target prefix [0 ... pos-1]
            boolean possible = true;

            for (int i = 0; i < pos; i++) {

                int c = target.charAt(i) - 'a';

                if (available[c] == 0) {
                    possible = false;
                    break;
                }

                available[c]--;
            }

            if (!possible) {
                continue;
            }

            int targetChar = target.charAt(pos) - 'a';

            // Find smallest character greater than target[pos]
            for (int c = targetChar + 1; c < 26; c++) {

                if (available[c] == 0) {
                    continue;
                }

                StringBuilder newHalf = new StringBuilder();

                // Copy target prefix
                for (int i = 0; i < pos; i++) {
                    newHalf.append(target.charAt(i));
                }

                // Put a greater character
                newHalf.append((char) ('a' + c));

                available[c]--;

                // Fill remaining characters in sorted order
                for (int x = 0; x < 26; x++) {
                    while (available[x] > 0) {
                        newHalf.append((char) ('a' + x));
                        available[x]--;
                    }
                }

                String candidate =
                    makePalindrome(newHalf.toString(), middle);

                if (candidate.compareTo(target) > 0) {
                    return candidate;
                }

                available[c]++;
            }
        }

        return "";
    }

    private String makePalindrome(String left, char middle) {

        StringBuilder result = new StringBuilder();

        result.append(left);

        if (middle != 0) {
            result.append(middle);
        }

        result.append(new StringBuilder(left).reverse());

        return result.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/)