import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] target = arr.clone();
        Arrays.sort(target);

        boolean sorted = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] != target[i]) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        if (n == 2) return -1;

        int left = -1, right = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != target[i]) {
                if (left == -1) left = i;
                right = i;
            }
        }

        if (left > 0 || right < n - 1) return 1;

        char minChar = target[0];
        char maxChar = target[n - 1];
        int minFirst = -1;
        int maxLast = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == minChar && minFirst == -1) minFirst = i;
            if (arr[i] == maxChar) maxLast = i;
        }

        if (minFirst < n - 1 || maxLast > 0) return 2;
        return 3;
    }
}