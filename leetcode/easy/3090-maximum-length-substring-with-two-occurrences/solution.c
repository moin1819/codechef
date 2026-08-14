#include <string.h>
int maximumLengthSubstring(char* s) {
    int counts[26] = {0};
    int left = 0;
    int max_len = 0;
    int len = strlen(s);

    for (int right = 0; right < len; right++) {
        counts[s[right] - 'a']++;

        while (counts[s[right] - 'a'] > 2) {
            counts[s[left] - 'a']--;
            left++;
        }

        int curr_len = right - left + 1;
        if (curr_len > max_len) {
            max_len = curr_len;
        }
    }

    return max_len;
}