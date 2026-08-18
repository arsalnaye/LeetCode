class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            // Find the beginning of the word
            int j = i;

            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Add space before the word if ans already has something
            if (ans.length() > 0) {
                ans.append(' ');
            }

            // Append the word
            ans.append(s.substring(j + 1, i + 1));

            i = j;
        }

        return ans.toString();
    }
}