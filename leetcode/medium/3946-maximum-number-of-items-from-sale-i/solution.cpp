
class Solution {
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int n = items.size();

        vector<int> factors(n), prices(n);

        int top = 0;
        int cheapest = INT_MAX;

        for (int i = 0; i < n; i++) {
            factors[i] = items[i][0];
            prices[i] = items[i][1];

            top = max(top, factors[i]);
            cheapest = min(cheapest, prices[i]);
        }

        vector<int> have(top + 1, 0);
        vector<int> gains(top + 1, 0);

        // Count items having each factor
        for (int factor : factors) {
            have[factor]++;
        }

        // Calculate free copies for each factor
        for (int factor = 1; factor <= top; factor++) {
            for (int multiple = factor; multiple <= top; multiple += factor) {
                gains[factor] += have[multiple];
            }
        }

        vector<int> best(budget + 1);

        // Initially buy copies of the cheapest item
        for (int money = 0; money <= budget; money++) {
            best[money] = money / cheapest;
        }

        // 0/1 Knapsack
        for (auto& item : items) {
            int factor = item[0];
            int price = item[1];
            int gain = gains[factor];

            if (gain > price / cheapest) {
                for (int money = budget; money >= price; money--) {
                    best[money] = max(
                        best[money],
                        best[money - price] + gain
                    );
                }
            }
        }

        return best[budget];
    }
};
