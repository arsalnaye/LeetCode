int maxProduct(int* nums, int numsSize) {
    int maxend = nums[0];
    int minend = nums[0];
    int result = nums[0];

    for (int i = 1; i < numsSize; i++) {
        int v1 = nums[i];
        int v2 = minend * nums[i];
        int v3 = maxend * nums[i];

        int newMax = fmax(v1, fmax(v2, v3));
        int newMin = fmin(v1, fmin(v2, v3));

        maxend = newMax;
        minend = newMin;

        result = fmax(result, maxend);
    }

    return result;
}