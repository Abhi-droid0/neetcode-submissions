class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int right=0; right<s.length(); right++) {

            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch,0) + 1);

            while (freqMap.get(ch)> 1) {

                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.getOrDefault(leftChar,0) - 1); 
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
