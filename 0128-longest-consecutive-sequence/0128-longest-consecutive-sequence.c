#include <stdlib.h>
#include <limits.h>

int cmp(const void *a, const void *b) {
    return (*(int *)a > *(int *)b) - (*(int *)a < *(int *)b);
}

int longestConsecutive(int* nums, int numsSize) {
    if (numsSize == 0)
        return 0;

    qsort(nums, numsSize, sizeof(int), cmp);

    int cnt = 1;
    int longest = 1;

    for (int i = 1; i < numsSize; i++) {
        if (nums[i] == nums[i - 1])
            continue;              // ignore duplicates

        if (nums[i] == nums[i - 1] + 1) {
            cnt++;
        } else {
            cnt = 1;
        }

        if (cnt > longest)
            longest = cnt;
    }

    return longest;
}