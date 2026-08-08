int* productExceptSelf(int* nums, int numsSize, int* returnSize) {
    int n = numsSize;
    int* ans = malloc(n * sizeof(int));

    *returnSize = n;

    // Prefix products
    ans[0] = 1;
    for (int i = 1; i < n; i++) {
        ans[i] = ans[i - 1] * nums[i - 1];
    }

    // Suffix products
    int suffix = 1;
    for (int i = n - 1; i >= 0; i--) {
        ans[i] *= suffix;
        suffix *= nums[i];
    }

    return ans;
}