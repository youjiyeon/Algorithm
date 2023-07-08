#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <string.h>

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
}
