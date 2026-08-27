class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Try changing the string from right to left
        for (int i = n - 1; i >= 0; i--) {

            int[] count = new int[26];

            // Count all characters of s
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Try to match target[0 ... i-1]
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

            // At position i, choose the smallest character
            // greater than target[i]
            int x = target.charAt(i) - 'a';

            for (int c = x + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Add target prefix
                    for (int j = 0; j < i; j++) {
                        ans.append(target.charAt(j));
                    }

                    // Add the bigger character
                    ans.append((char) ('a' + c));
                    count[c]--;

                    // Add remaining characters in sorted order
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