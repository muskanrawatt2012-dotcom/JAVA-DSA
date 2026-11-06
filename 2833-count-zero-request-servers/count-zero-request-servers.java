import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int m = logs.length;
        int qn = queries.length;
        Integer[] order = new Integer[qn];
        for (int i = 0; i < qn; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] freq = new int[n + 1];
        int distinct = 0;
        int left = 0;
        int right = 0;
        int[] ans = new int[qn];

        for (int qi : order) {
            int q = queries[qi];
            int l = q - x;

            while (right < m && logs[right][1] <= q) {
                int id = logs[right][0];
                if (freq[id] == 0) distinct++;
                freq[id]++;
                right++;
            }

            while (left < m && logs[left][1] < l) {
                int id = logs[left][0];
                if (freq[id] == 1) distinct--;
                freq[id]--;
                left++;
            }

            ans[qi] = n - distinct;
        }

        return ans;
    }
}