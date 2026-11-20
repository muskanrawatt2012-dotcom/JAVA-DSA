class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 2];
        int ans = 0;
        for (int x : nums) {
            int a = dp[x - 1] + 1;
            int b = dp[x] + 1;
            dp[x] = Math.max(dp[x], a);
            dp[x + 1] = Math.max(dp[x + 1], b);
            ans = Math.max(ans, Math.max(dp[x], dp[x + 1]));
        }
        return ans;
    }
}