#include<stdio.h>
int main(void){

	int h,m;
	scanf("%d%d",&h,&m);

	if(h<0 || h>23) printf("error\n");
	if(m<0 || m>59) printf("error\n");

    m-=45;
	if(m<0){
		m+=60;
		h-=1;
		if(h==-1) h=23;
	}
	printf("%d %d\n", h,m);
	return 0;
}