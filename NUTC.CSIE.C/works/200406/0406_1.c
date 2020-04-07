#include <stdio.h>

/*
    利用break及flag來讓迴圈提早結束。
*/

int main()
{
    int a[5]={0,0,0,0,0};
    int b[3][4]={
            {91,2,3,4},
            {5,600,7,8},
            {9,10,11,12}
    };
    //找出600的索引編號
    int i, j, row, col;
    int n=91;
    int flag = 0;
    for (i=0; i<3; i++){
        for (j=0; j<4; j++){
            if (b[i][j]==n){
                row=i;
                col=j;
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            break;
        }
        printf("* ");
    }

    printf("%d %d", row, col);
    return 0;
}

