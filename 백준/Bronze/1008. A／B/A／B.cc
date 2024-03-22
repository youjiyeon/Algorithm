#define _CRT_SECURE_NO_WARNINGS

#include<stdio.h>

int main()
{
	double a, b;
	scanf("%lf %lf",&a,&b);

	if (a > 0 && b < 10)
	{
		printf("%.16lf",a/b);
	}
	

}