class Solution {

    public int compress(char[] chars) {

        int readidx = 0, writeidx = 0;

        while (readidx < chars.length) {

            char currentchar = chars[readidx];
            int ct = 0;

            // Count consecutive characters
            while (readidx < chars.length && currentchar == chars[readidx]) {
                readidx++;
                ct++;
            }

            // Write character
            chars[writeidx] = currentchar;
            writeidx++;

            // Write count
            if (ct > 1) {

                String ctstr = String.valueOf(ct);

                for (char digit : ctstr.toCharArray()) {
                    chars[writeidx] = digit;
                    writeidx++;
                }
            }
        }

        return writeidx;
    }
}