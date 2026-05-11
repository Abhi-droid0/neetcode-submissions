class Solution {
    public boolean isPalindrome(String s) {
    String trimmedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String newStr = "";



        for (int i = trimmedStr.length() -1; i>=0; i--) {
            newStr = newStr + trimmedStr.charAt(i);
        }

        if (trimmedStr.equals(newStr)) {
            return true;
        }

        return false;



        
    }
}
