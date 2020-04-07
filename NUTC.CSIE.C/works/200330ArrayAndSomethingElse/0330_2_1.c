#include <stdio.h>
#include <stdlib.h>

int main() {
    int arr[5] = {6, 5, 4, 8, 3};
    int arr2[5];
    int ansArr[5];

    int temp = 0;
    for (int i = 0; i < 5; ++i) {
        arr2[i] = arr[i];
    }

    for (int i = 0; i < 4; ++i) {
        for(int j = 0; j < 4; j++) {
            if (arr2[j] > arr2[j+1]){
                temp = arr2[j+1];
                arr2[j+1] = arr2[j];
                arr2[j] = temp;
            }
        }
        arr2[4-i] = ansArr[i];

    }

    for (int i = 0; i < 5; ++i) {
        printf("%d ",arr[i]);
    }
    printf("\n\n");
    for (int i = 0; i < 5; ++i) {
        printf("%d ",arr2[i]);
    }

}