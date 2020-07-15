#include <stdio.h>
#include <stdlib.h>

// 檔案處理：複製一個檔案內的所有文字至另外一個檔案。

void main()

{
    FILE *file1, *file2;
    char filename1[80];
    char filename2[] = "output.txt";
    char c;

    scanf("%s", filename1);


    file1 = fopen(filename1, "r");
    file2 = fopen(filename2, "w");
    if (file1 != NULL && file2 != NULL){
        // 逐字複製至file2
        while ((c = fgetc(file1)) != EOF){
            printf("%c", c);
            fputc(c, file2);
        }
        printf("\n");
    } else{
        printf("File %s failed to open.\n", filename1);
        exit(1);
    }

    fclose(file1);
    fclose(file2);
    printf("File %s, %s closed.\n", filename1, filename2);

}