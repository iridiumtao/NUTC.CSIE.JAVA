#include <stdio.h>
#include <stdlib.h>


int findNumbers(int* nums, int numsSize){
    int numsOfEven = 0;
    for (int i = 0; i < numsSize; i++) {
        int times = 1;
        int count = 0;
        while (1) {
            printf("%d: %d\n", times, (nums[i] / times) % 10);
            times *= 10;
            count++;
            if (nums[i] / (times) == 0) {
                break;
            }
        }
        if(count % 2 == 0){
            numsOfEven++;
        }
    }
    return numsOfEven;
}