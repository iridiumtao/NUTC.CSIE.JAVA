#include <stdio.h>
#include <stdlib.h>

int main() {
    int arr[5] = {6, 5, 4, 8, 3};
    int ansArr[5];

    int count;
    for (int i = 0; i < 5; ++i) {
        count = 0;
        for (int j = 0; j < 5; ++j) {
            if (arr[i] - arr[j] > 0) {
                count++;
            }
        }
        ansArr[i] = count;
    }

    for (int i = 0; i < 5; ++i) {
        printf("%d ", ansArr[i]);
    }
}