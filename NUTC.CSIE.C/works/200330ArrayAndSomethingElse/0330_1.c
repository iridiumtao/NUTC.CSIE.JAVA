#include <stdio.h>
#include <stdlib.h>

int main() {
    int arr[10] = {2, 5, 7, 9, 15, 16, 19, 20, 42, 30};
    int temp;
    for (int i = 9; i > 0; i--) {
        temp = arr[i];
        arr[i] = arr[i-1];
        arr[i-1] = temp;

    }
    for (int j = 0; j < 10; ++j) {
        printf("arr:%d\n",arr[j]);
    }
}