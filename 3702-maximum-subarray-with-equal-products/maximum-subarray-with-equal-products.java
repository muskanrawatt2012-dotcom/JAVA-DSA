import java.math.BigInteger;

class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            BigInteger prod = BigInteger.ONE;
            long g = 0;
            long l = 1;
            for (int j = i; j < n; j++) {
                int x = nums[j];
                prod = prod.multiply(BigInteger.valueOf(x));
                g = gcd(g, x);
                l = l / gcd(l, x) * x;
                if (prod.equals(BigInteger.valueOf(g * l))) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}