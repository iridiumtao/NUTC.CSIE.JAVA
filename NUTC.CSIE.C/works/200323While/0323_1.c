#include <stdio.h>
#include <stdlib.h>

int main() {
    int num;
    int count = 0;
    scanf("%d", &num);
    while (num != 0) {
        if (num % 2 == 0) {
            num /= 2;
        } else {
            num--;
        }
        count++;
    }
    printf("%d", count);
    return 0;
}