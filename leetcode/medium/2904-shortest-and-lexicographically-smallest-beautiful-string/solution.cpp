#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n = s.length();
        string ans = "";
        int min_len = n + 1;
        
        int count_ones = 0;
        int left = 0;
        
        for (int right = 0; right < n; ++right) {
            if (s[right] == '1') {
                count_ones++;
            }
            
            while (count_ones == k) {
                while (s[left] == '0') {
                    left++;
                }
                
                int curr_len = right - left + 1;
                string curr_sub = s.substr(left, curr_len);
                
                if (curr_len < min_len) {
                    min_len = curr_len;
                    ans = curr_sub;
                } else if (curr_len == min_len) {
                    if (curr_sub < ans) {
                        ans = curr_sub;
                    }
                }
                
                if (s[left] == '1') {
                    count_ones--;
                }
                left++;
            }
        }
        
        return ans;
    }
};