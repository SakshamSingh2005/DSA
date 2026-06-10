class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }

        return 1L * k * (mx - mn);
    }
}