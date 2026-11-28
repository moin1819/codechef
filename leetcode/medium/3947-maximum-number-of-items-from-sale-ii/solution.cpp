
class Solution {
public:
    long long maximumSaleItems(vector<vector<int>>& items, int budget) {
        int n = items.size();

        // Count frequency of each factor
        vector<int> freq(n + 1, 0);

        for (auto &item : items) {
            freq[item[0]]++;
        }

        // Count how many items each factor can provide for free
        vector<int> cnt(n + 1, 0);

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                cnt[i] += freq[j];
            }
        }

        // Find minimum price
        long long minPrice = LLONG_MAX;

        for (auto &item : items) {
            minPrice = min(minPrice, (long long)item[1]);
        }

        // Sort items by price
        sort(items.begin(), items.end(),
             [](const vector<int>& a, const vector<int>& b) {
                 return a[1] < b[1];
             });

        long long ans = 0;
        long long remaining = budget;

        // Purchase bonus copies first
        for (auto &item : items) {
            long long factor = item[0];
            long long price = item[1];

            // Bonus copies are not beneficial beyond this price
            if (price >= 2 * minPrice) {
                break;
            }

            // Exclude the item itself
            long long freeCount = cnt[factor] - 1;

            // Maximum bonus copies we can afford
            long long take = min(freeCount, remaining / price);

            ans += 2 * take;
            remaining -= take * price;
        }

        // Spend the remaining budget on the cheapest item
        ans += remaining / minPrice;

        return ans;
    }
};
