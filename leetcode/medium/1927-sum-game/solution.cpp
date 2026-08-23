#include <string>

class Solution {
public:
    bool sumGame(std::string num) {
        int n = num.length();
        int half = n / 2;
        
        int sumLeft = 0, countLeft = 0;
        int sumRight = 0, countRight = 0;
        
        for (int i = 0; i < half; ++i) {
            if (num[i] == '?') {
                countLeft++;
            } else {
                sumLeft += num[i] - '0';
            }
        }
        
        for (int i = half; i < n; ++i) {
            if (num[i] == '?') {
                countRight++;
            } else {
                sumRight += num[i] - '0';
            }
        }
        
        return (sumLeft - sumRight) * 2 != (countRight - countLeft) * 9;
    }
};