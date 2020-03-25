#include <stdio.h>
#include <stdlib.h>

//input: Positive Integer
//Output: The number and the
int main() {
    int i;
    scanf("%d", &i);
    printf("Num: %d\n", i);
    int times = 1;
    int count = 0;
    while (1) {
        printf("%d: %d\n", times, (i / times) % 10);
        times *= 10;
        count++;
        if (i / (times) == 0) {
            break;
        }
    }
    printf("%d digit(s)", count);
}