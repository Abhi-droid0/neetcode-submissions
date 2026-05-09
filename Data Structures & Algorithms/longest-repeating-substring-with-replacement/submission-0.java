class Solution {
   public int characterReplacement(String s, int k) {
    int[] freq = new int[26];
    int left = 0;
    int maxCharFreq = 0;
    int maxLen = 0;

    for (int right = 0; right < s.length(); right++) {

        // Add right char to window
        freq[s.charAt(right) - 'A']++;

        // Update max frequency in current window
        maxCharFreq = Math.max(maxCharFreq, freq[s.charAt(right) - 'A']);

        // Check if window is invalid
        // replacements needed = windowSize - maxCharFreq
        while ((right - left + 1) - maxCharFreq > k) {
            freq[s.charAt(left) - 'A']--;   // remove left char
            left++;                          // shrink window
            // Note: maxCharFreq is NOT updated here (see Q&A below)
        }

        // Window is valid â update answer
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
}
