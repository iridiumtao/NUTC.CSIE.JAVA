#include <stdio.h>
#include <stdlib.h>

FILE *data;
FILE *data2;

void change(unsigned char *p,int m){
    unsigned char *pp;
    int i;
    pp=(unsigned char*)malloc(sizeof(unsigned char)*m);
    for(i=0; i<m; i+=3){
        *(pp+i)=*(p+(m-3)-i);
        *(pp+i+1)=*(p+(m-2)-i);
        *(pp+i+2)=*(p+(m-1)-i);
    }
    for(i=0; i<m; i++){
        *(p+i)=*(pp+i);
    }
    free(pp);
}

int main(){
    int num,headsize,low,high;
    unsigned char *title,H,*detail,headersize[4];
    char filename[12]="LAND.BMP",filename2[11]="result.bmp";

    data=fopen(filename,"rb");

    fseek(data,10,SEEK_SET);
    fread(headersize,sizeof(unsigned char),4,data);
    fseek(data,0,SEEK_SET);

    low=headersize[0]%16;
    high=(headersize[0]-low)/16;
    headsize+=high*16+low;

    low=headersize[1]%16;
    high=(headersize[1]-low)/16;
    headsize+=high*16*16*16+low*16*16;

    title=(unsigned char*)malloc(sizeof(unsigned char)*headsize);
    fread(title,sizeof(unsigned char),headsize,data);

    fseek(data,0,SEEK_END);
    num=(ftell(data)/sizeof(unsigned char));
    printf("%d\n",num);
    num=num-headsize;

    detail=(unsigned char*)malloc(sizeof(unsigned char)*num);
    fseek(data,headsize,SEEK_SET);
    fread(detail,sizeof(unsigned char),num+1,data);
    change(detail,num);

    data2=fopen(filename2,"wb");
    fwrite(title,sizeof(unsigned char),headsize,data2);
    fclose(data2);

    data2=fopen(filename2,"ab");

    fwrite(detail,sizeof(unsigned char),num,data2);

    free(title);
    free(detail);
    fclose(data);
    fclose(data2);
}