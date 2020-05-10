#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int main() {
    int a;
    srand(time(NULL));

    int arr[1000] = {0};
    for (int i = 0; i < 10000; ++i) {
        arr[rand()%1001]++;


    }
    for (int i = 0; i < 1001; ++i) {
        // I wonder what is this
        printf("%d:%d,  %d\n",i, arr[i],arr[rand()%1001]);
    }

    return 0;
}

