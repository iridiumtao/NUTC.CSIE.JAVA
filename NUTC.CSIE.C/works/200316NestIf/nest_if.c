#include <stdio.h>
#include <stdlib.h>

int main() {
    int mask = 0;
    printf("Please the number of masks.\n");
    scanf("%d", &mask);
    if (mask > 200 || mask < 0) {
        printf("error");
    } else if (mask >= 150) {
        printf("很多");
    } else if (mask >= 100) {
        printf("足夠");
    } else if (mask >= 1) {
        printf("不多");
    } else if (mask == 0) {
        printf("發完");
    } else {
        printf("error");
    }
    printf("\n");

    if (mask > 200 || mask < 0) {
        printf("error");
    } else {
        if (mask >= 150) {
            printf("很多");
        } else {
            if (mask >= 100) {
                printf("足夠");
            } else {
                if (mask >= 1) {
                    printf("不多");
                } else {
                    if (mask == 0) {
                        printf("發完");
                    }
                }
            }
        }
    }
}
