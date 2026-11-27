import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        final int MAXF = 1500;
        int[] cnt = new int[MAXF + 1];
        for (int[] it : items) {
            cnt[it[0]]++;
        }

        List<Integer>[] byPrice = new List[budget + 1];
        for (int[] it : items) {
            int f = it[0], p = it[1];
            if (p > budget) continue;

            int value = 0;
            for (int x = f; x <= MAXF; x += f) {
                value += cnt[x];
            }

            if (byPrice[p] == null) {
                byPrice[p] = new ArrayList<>();
            }
            byPrice[p].add(value);
        }

        final int NEG = -1_000_000_000;
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, NEG);
        dp[0] = 0;

        int ans = 0;

        for (int price = budget; price >= 1; price--) {
            List<Integer> vals = byPrice[price];
            if (vals == null || vals.isEmpty()) continue;

            Collections.sort(vals, Collections.reverseOrder());

            int sz = vals.size();
            int[] pref = new int[sz + 1];
            for (int i = 0; i < sz; i++) {
                pref[i + 1] = pref[i] + vals.get(i);
            }

            for (int k = 1; k <= sz; k++) {
                int cost = k * price;
                if (cost > budget) break;

                int maxC = budget - cost;
                int addValue = pref[k];

                for (int c = 0; c <= maxC; c++) {
                    if (dp[c] == NEG) continue;

                    int total = dp[c] + addValue + (budget - cost - c) / price;
                    ans = Math.max(ans, total);
                }
            }

            for (int v : vals) {
                for (int c = budget; c >= price; c--) {
                    if (dp[c - price] != NEG) {
                        dp[c] = Math.max(dp[c], dp[c - price] + v);
                    }
                }
            }
        }

        return ans;
    }
}