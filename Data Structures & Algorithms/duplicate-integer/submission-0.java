class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> storeUniqueNums = new HashSet<>();
        boolean hasDuplicate = false;
        for (int num : nums) {
            if (!storeUniqueNums.add(num)) {
                hasDuplicate = true;
            } 
        }
        return hasDuplicate;
    }
}