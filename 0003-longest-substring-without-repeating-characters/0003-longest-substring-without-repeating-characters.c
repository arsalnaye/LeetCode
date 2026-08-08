int lengthOfLongestSubstring(char* s) {
    int arr[256];
    for(int i=0;i<256;i++){
        arr[i]=-1;
    }

    int n = strlen(s);
    int l = 0, r = 0, maxlen = 0;

    while (r < n) {
        if (arr[s[r]] >= l) {
            l = arr[s[r]] + 1;
        }

        int len = r - l + 1;
        maxlen = (len > maxlen) ? len : maxlen;

        arr[s[r]] = r;
        r++;
    }

    return maxlen;
}