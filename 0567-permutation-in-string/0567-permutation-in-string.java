class Solution {

    static boolean compare(int[] ct1, int[] ct2) {
        for (int i = 0; i < 26; i++) {
            if (ct1[i] != ct2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];

        // Frequency of s1
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = ch - 'a';
            count1[index]++;
        }

        int[] count2 = new int[26];
        int windowLen = s1.length();

        // First window
        for (int i = 0; i < windowLen; i++) {
            char ch = s2.charAt(i);
            int index = ch - 'a';
            count2[index]++;
        }

        if (compare(count1, count2)) {
            return true;
        }

        // Sliding window
        for (int i = windowLen; i < s2.length(); i++) {

            // Add new character
            char newChar = s2.charAt(i);
            int newCharIdx = newChar - 'a';
            count2[newCharIdx]++;

            // Remove old character
            int oldCharIdx = i - windowLen;
            char oldChar = s2.charAt(oldCharIdx);
            count2[oldChar - 'a']--;

            // Compare frequencies
            if (compare(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}