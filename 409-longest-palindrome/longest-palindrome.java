class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        int ans = 0;
        for (int count : freq) {
            ans += count / 2 * 2;
            if (ans % 2 == 0 && count % 2 == 1) {
                ans += 1;
            }
        }
        
        return ans;
    }
    
}