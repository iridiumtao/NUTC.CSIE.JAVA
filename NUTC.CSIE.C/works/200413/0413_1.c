#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    //靜態記憶體配置
    char s[10];


    //動態記憶體配置
    char *t;
    t = (char *) malloc(10);

    //計算字串長度

    printf("請輸入字串：");
    scanf("%s", s);
    int i = 0;
    while (s[i] != '\0') {
        i++;
    }

    printf("字串長度為 %d\n", i);

    printf("請輸入字串：");
    scanf("%s", t);
    i = 0;
    while (s[i] != '\0') {
        i++;
    }
    printf("字串長度為 %d\n", i);

    return 0;
}

