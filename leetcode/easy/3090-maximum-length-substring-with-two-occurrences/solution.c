#include <string.h>

int maximumLengthSubstring(char* s) {
    int counts[26] = {0};
    int left = 0;
    int max_len = 0;
    int len = strlen(s);

    for (int right = 0; right < len; right++) {
        // Add the current character to the window count
        counts[s[right] - 'a']++;

        // Shrink the window from the left if any count exceeds 2
        while (counts[s[right] - 'a'] > 2) {
            counts[s[left] - 'a']--;
            left++;
        }

        // Update max length
        int curr_len = right - left + 1;
        if (curr_len > max_len) {
            max_len = curr_len;
        }
    }

    return max_len;
}