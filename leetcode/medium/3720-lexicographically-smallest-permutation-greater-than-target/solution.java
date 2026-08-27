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