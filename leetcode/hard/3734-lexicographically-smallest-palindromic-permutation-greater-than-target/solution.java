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