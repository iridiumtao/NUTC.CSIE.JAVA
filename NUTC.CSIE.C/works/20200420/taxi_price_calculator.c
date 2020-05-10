#include "stdio.h"

/*
 * 計程車車費計算程式
 */
int main() {
    printf("搭乘時間 日間(1) 夜間(2) 請選擇:");
    int t;
    scanf("%d", &t);

    printf("請輸入里程(公里):");
    float km;
    scanf("%f", &km);
    int m = km * 1000;
    int price = 0;

    //printf("t: %d\n", t);
    //printf("m: %d\n", m);

    if (t == 1) {
        price += 70;
        if (m > 1500) {
            m -= 1500;
            while (m > 0) {
                m -= 300;
                price += 5;
            }
        }
    } else if (t == 2) {
        price += 70;
        if (m > 1250) {
            m -= 1250;
            while (m > 0) {
                m -= 250;
                price += 5;
            }
        }
    }

    printf("price: %d", price);
    return 0;
}

