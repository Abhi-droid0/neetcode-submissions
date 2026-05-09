class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> storeNums = new HashMap<>();

        for (int i=0; i< nums.length; i++) {
            int seen = target - nums[i];

            if (storeNums.containsKey(seen)) {
                return new int[] {storeNums.get(seen), i};
            } else {
                storeNums.put(nums[i], i);
            }
        }

        return new int[] {0,0};
    }
}
