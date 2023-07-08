#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

//char Ar[9] = { 'c=','c-','dz=','d-','lj','nj','s=','z='};

int main(void)
{



		char word[101];
		scanf("%s", word);

		int i;
		int cnt = 0;
		for (i = 0;; i++) {
			char lett = word[i];
			if (word[i] == NULL)
				break;

			if (lett == 'n' || lett == 'l') {
				if (word[i + 1] == 'j') continue;
			}
			else if (lett == 'c' || lett == 's' || lett == 'z') {
				if (word[i + 1] == '=' || word[i + 1] == '-') continue;
			}
			else if (lett == 'd') {
				if (word[i + 1] == '-') continue;
				if (word[i + 1] == 'z' && word[i + 2] == '=') continue;
			}

			cnt++;
		}
		printf("%d", cnt);
	
	//char a[100] = { NULL, };
	//int cnt = 0;
	//
	//scanf("%s", a);

	/*if (a[0] == 'c')
	{
		printf("OK");
	}*/
	
	//for (int i = 0; i < 10; i++)
	//{
	//	if (a[i] == 'c')
	//	{
	//		if ((a[i + 1] == '=') || (a[i + 1] == '-'))
	//		{
	//			i++;
	//			cnt++;
	//		}
	//	}

	//	if (a[i] == 'd')
	//	{
	//		if (a[i+1] == 'z')
	//		{
	//			if ((a[i + 2] == '-'))
	//			{
	//				i=i+2;
	//				cnt++;
	//			}
	//		}
	//		if ((a[i + 1] == '-'))
	//		{
	//			i++;
	//			cnt++;
	//		}
	//	}

	//	if (a[i] == 'l')
	//	{
	//		if ((a[i + 1] == 'j'))
	//		{
	//			i++;
	//			cnt++;
	//		}
	//	}

	//	if (a[i] == 'h')
	//	{
	//		if ((a[i + 1] == 'j'))
	//		{
	//			i++;
	//			cnt++;
	//		}
	//	}

	//	if (a[i] == 's')
	//	{
	//		if ((a[i + 1] == '='))
	//		{
	//			i++;
	//			cnt++;
	//		}
	//	}

	//	if (a[i] == 'z')
	//	{
	//		if ((a[i + 1] == '='))
	//		{
	//			i++;
	//			cnt++;
	//		}
	//	}
	//	else
	//	{
	//		cnt++;
	//	}
	//}
	//
	//printf("%d", cnt);
	

}