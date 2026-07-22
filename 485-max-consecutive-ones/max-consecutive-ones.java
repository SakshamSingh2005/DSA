class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int i = 0;

        while (i < nums.length) {
            int n = 0;

            if (nums[i] == 1) {
                while (i < nums.length && nums[i] == 1) {
                    n++;
                    i++;
                }
            } else {
                i++;
            }

            maxOnes = Math.max(maxOnes, n);
        }

        return maxOnes;
    }
}