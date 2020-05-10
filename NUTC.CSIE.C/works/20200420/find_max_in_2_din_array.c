#include "stdio.h"

/*
 * 找出二維陣列所有元素的最大值
 */
int main() {
    int number[2][4] = {
            {1, 11, 12, 13},
            {14, 50, 16, 17}
    };
    //int number[5] = {0, 1, 2, 3, 4};

    int row = sizeof(number) / sizeof(number[0]);
    int column = sizeof(number[0]) / sizeof(number[0][0]);

    int i;
    int j;
    int max = 0;
    for (i = 0; i < row; i++) {
        for (j = 0; j < column; j++) {
            max = (max < number[i][j]) ? number[i][j] : max;
        }
    }

    printf("row: %d\ncolumn: %d\n",row, column);
    printf("max: %d", max);
    return 0;
}

