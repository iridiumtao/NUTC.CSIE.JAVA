#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i, j;
    for (i=0;i<=10;i++){
        printf("%d ",i);
    }

    i=0;
    while (i<=10){
       printf("%d ",i);
       i++;
    }


    printf ("\n");
    for (i=1;i<=9;i++){
        for (j=1;j<=9;j++){
            printf("%d*%d=%d ", i, j, i*j);
        }
        printf("\n");
    }


    /* 作業範圍 */
    while (i <= 9){
        while (j <= 9){
            printf("%d*%d=%d ", i, j, i*j);
            j++;
        }
        i++;
        j = 1;
        printf("\n");
    }
    return 0;
}