class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // int [] result = new int[nums.length - k + 1];
        // for (int right = 0; right <= nums.length - k; right++) {
        // int maxInWindow = Integer.MIN_VALUE; 
        //     for (int i = right; i < right + k; i++) {
        //         maxInWindow = Math.max(maxInWindow, nums[i]);
        //     }
        //     result[right] = (maxInWindow);
        // }

        // return result;

    int n = nums.length;
    int[] result = new int[n - k + 1];
    Deque<Integer> deque = new ArrayDeque<>(); // Stores indices

    for (int i = 0; i < n; i++) {
        // 1. Remove indices that are out of the current window range
        if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }

        // 2. Remove indices of smaller elements as they'll never be the max
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
        }

        deque.offerLast(i);

        // 3. Add to result once the first window is complete
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()];
        }
    }
    return result;

    }
}
