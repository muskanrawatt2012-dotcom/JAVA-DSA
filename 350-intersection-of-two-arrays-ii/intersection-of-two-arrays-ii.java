import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums1.length];
        int index = 0;

        for (int num : nums2) {
            int count = counts.getOrDefault(num, 0);
            if (count > 0) {
                result[index++] = num;
                counts.put(num, count - 1);
            }
        }

        return Arrays.copyOf(result, index);
    }
}