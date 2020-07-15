#include <stdio.h>
#include <stdlib.h>

// 檔案處理：將文件中的「字串」後加上換行。

void main()

{
    FILE *file1, *file2;
    char filename1[] = "in1.txt";
    char filename2[] = "output.txt";
    char s[32];

    //scanf("%s", filename1);


    file1 = fopen(filename1, "r");
    file2 = fopen(filename2, "w");
    if (file1 != NULL && file2 != NULL){
        // 逐字串迴圈
        while (fscanf(file1, "%s",s) != EOF){
            fprintf(file2, "%s\n",s);
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