class Solution {

    public String reverseWords(String s) {

        int l = 0;
        int r = s.length() - 1;

        // Remove leading spaces
        while (l <= r) {
            if (s.charAt(l) == ' ') {
                l++;
            } else {
                break;
            }
        }

        // Remove trailing spaces
        while (r >= 0) {
            if (s.charAt(r) == ' ') {
                r--;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        // Remove extra spaces between words
        while (l <= r) {

            if (s.charAt(l) != ' ') {
                sb.append(s.charAt(l));
                l++;

            } else {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
                l++;
            }
        }

        int i = 0;

while (i < sb.length()) {

    // Find the end of the current word
    int j = i;

    while (j < sb.length() && sb.charAt(j) != ' ') {
        j++;
    }

    // Reverse this word
    int left = i;
    int right = j - 1;

    while (left < right) {
        char temp = sb.charAt(left);
        sb.setCharAt(left, sb.charAt(right));
        sb.setCharAt(right, temp);

        left++;
        right--;
    }

    // Move to next word
    i = j + 1;
}
return sb.toString();
}}