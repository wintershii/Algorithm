#include<stdio.h>
#include<string.h>

void search(char str[], char son[],int pos)
{
	int index;
	int i = pos;	//�����е�λ���±� 
	int j = 0;	//�ִ��е�λ���±�
	int len1 = strlen(str);
	int len2 = strlen(son);
	
	while(i < len1 && j < len2)
	{
		if(str[i] == son[j])
		{
			i++;
			j++;
		}
		else
		{
			i = i - j + 1;
			j = 0;
		}
	}
	if(j = len2)
	{
		if(pos >= len1-len2 || i >= len1)
		{
			printf("�������Ӵ���\n");
			return;
		}
		printf("���ҵ��Ӵ�����ʼ������������%d��\n",i-len2);
		search(str,son,i-len2+1);				//�ݹ�������� 
	}
}

int main()
{
	char str[1000];
	char son[1000];
	gets(str);
	gets(son); 
	search(str,son,0);
	return 0;
}
