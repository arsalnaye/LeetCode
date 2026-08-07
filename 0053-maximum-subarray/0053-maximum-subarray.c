int maxSubArray(int* arr, int n) {
    int bestEnding = arr[0];
    int ans = arr[0];

    for (int i = 1; i < n; i++) {
        int v1 = bestEnding + arr[i];
        int v2 = arr[i];
        bestEnding = (v1 > v2) ? v1 : v2;
        ans = (ans > bestEnding) ? ans : bestEnding;
    }

    return ans;
}