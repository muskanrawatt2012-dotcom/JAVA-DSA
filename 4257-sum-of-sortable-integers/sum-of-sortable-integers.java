import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        long answer = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            if (isSortable(nums, sorted, n, k)) {
                answer += k;
            }
        }

        return (int) answer;
    }

    private boolean isSortable(int[] nums, int[] sorted, int n, int k) {
        for (int start = 0; start < n; start += k) {
            int descent = -1;

            for (int i = start; i < start + k - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    if (descent != -1) return false;
                    descent = i;
                }
            }

            int offset = descent == -1 ? 0 : descent + 1 - start;

            for (int i = 0; i < k; i++) {
                int idx = start + (offset + i) % k;
                if (nums[idx] != sorted[start + i]) {
                    return false;
                }
            }
        }

        return true;
    }
}