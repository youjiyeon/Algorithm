#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

//int main(void)
//{
//	char word[100][101] = { NULL, };
//	char find = NULL;
//	int num = 0;
//	int sum = 0;
//	int cnt = 0;
//	int r = 0;
//
//	scanf("%d", &r);
//
//	for (int k = 0; k < r; k++)
//	{
//
//		scanf("%s", word[k]);
//
//	}
//
//	//printf("%s", word[k][i]);
//
//	/*for (int k = 0; k < r; k++)
//	{
//		for (int i = 0; word[k][i] != '\0'; i++)
//		{
//			printf("%c", word[k][i]);
//			printf("%d",i);
//		}
//		printf("\n");
//
//	}*/
//
//
//	for (int k = 0; k < r; k++)
//	{
//		for (int i = 0; word[k][i] != '\0'; i++)
//		{
//			find = word[k][i];
//
//
//			if (word[k][i + 1] != find)
//			{
//				//find = word[k][i];
//				num = i + 2;
//
//
//				while (word[k][num] != '\0')
//				{
//					if (word[k][num] == find)
//					{
//						cnt = 0;
//						break;
//					}
//					num++;
//					cnt = 1;
//				}
//
//				//for (int j = num; word[k][j] != '\0'; j++)
//				//{
//				//	if (word[k][j] == find)
//				//	{
//				//		cnt = 0;
//				//		printf("cnt is%d\n", cnt);
//				//		printf("k is%d\n", k);
//				//		break;
//				//	}
//				//	else
//				//	{
//				//		cnt = 1;
//				//		printf("cnt is%d\n", cnt);
//				//		printf("k is %d\n", k);
//				//		//break;
//				//	}
//				//}
//			}
//		}
//		sum = sum + cnt;
//		
//	}
//	printf("%d", sum);
//}
//

int main(int argc, char* argv[])

{

    int N, y;

    char words[100][101] = { NULL };

    int check[26] = { 0, }; //알파벳 사용되었는지 확인

    int temp = 0; //중복 알파벳이 나올 경우, 연속되는지 확인 (0이면 연속)

    int cnt = 0; //그룹 단어 갯수



    scanf("%d", &N);

    for (int i = 0; i < N; i++)

    {

        scanf("%s", words[i]);

        // 한 번의 작업을 위한 초기화

        temp = 0;

        for (int x = 0; x < 26; x++)

        {

            check[x] = 0;

        }



        // 그룹단어 체크하기

        for (y = 0; words[i][y] != NULL; y++)

        {

            if (check[words[i][y] - 97] == 0) // 알파벳이 처음 사용되는 경우 

                check[words[i][y] - 97] = 1;



            else if (words[i][y] != words[i][y - 1]) // 알파벳 중복 사용, 연속되지 않은 경우->조건 탈락-> break

            {

                temp = 1;

                break;

            }

        }

        if (temp != 1 || y == 1) // (y==1)--->단어가 한 글자인 경우는 무조건 그룹 단어

            cnt++;

    }

    printf("%d\n", cnt);



    return 0;

}

