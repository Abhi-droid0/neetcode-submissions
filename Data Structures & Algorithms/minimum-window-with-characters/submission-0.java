class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetFreqMap = new HashMap<>();

        Map<Character, Integer> windowMap = new HashMap<>();


        for (int i =0; i<t.length(); i++) {
            char ch = t.charAt(i);
            targetFreqMap.put(ch, targetFreqMap.getOrDefault(ch,0) + 1);            
        }

        int start =0;
        int left =0;
        int formed =0;
        int required =targetFreqMap.size();

        int minLength = Integer.MAX_VALUE;

        for (int right =0; right < s.length(); right++) {
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch,0) + 1);

            if (targetFreqMap.containsKey(ch) 
            && targetFreqMap.get(ch).intValue() == windowMap.get(ch).intValue()) {
               formed++; 
            }
            
            while (formed == required) {

                if (right -left + 1< minLength) {
                    minLength = right -left + 1;
                    start = left;
                }
               
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.put(leftChar,0) - 1);

                if (targetFreqMap.containsKey(leftChar) 
            && targetFreqMap.get(leftChar) > windowMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);



    }
}
