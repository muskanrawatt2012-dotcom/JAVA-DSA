class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long onlyBoth = (long) costBoth * Math.max(need1, need2);
        long separate = (long) cost1 * need1 + (long) cost2 * need2;
        long mixed;
        if (need1 < need2) {
            mixed = (long) costBoth * need1 + (long) cost2 * (need2 - need1);
        } else {
            mixed = (long) costBoth * need2 + (long) cost1 * (need1 - need2);
        }
        long useBoth = Math.min(onlyBoth, mixed);
        return Math.min(separate, useBoth);
    }
}