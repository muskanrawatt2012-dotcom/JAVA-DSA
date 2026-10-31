class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        int consecutiveLateCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absentCount++;
                consecutiveLateCount = 0;
            } else if (c == 'L') {
                consecutiveLateCount++;
            } else {
                consecutiveLateCount = 0;
            }

            if (absentCount >= 2 || consecutiveLateCount >= 3) {
                return false;
            }
        }

        return true;
    }
}