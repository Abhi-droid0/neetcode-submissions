class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {


        int [] result = new int[nums.length - k + 1];

        for (int right = 0; right <= nums.length - k; right++) {
        int maxInWindow = Integer.MIN_VALUE; 

            for (int i = right; i < right + k; i++) {
                maxInWindow = Math.max(maxInWindow, nums[i]);
            }

            result[right] = (maxInWindow);
            
        }

        return result;
    }
}
