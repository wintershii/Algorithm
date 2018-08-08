
/**
	KMPģʽƥ���㷨+�ݹ�����
	�������ַ���ƥ����ȣ�ȡ������������i�Ļ��ݣ�����
	ͨ����next����ʹ�Ӵ�����j�й��ɻ���
	��������Ч�� 
*/

#include<stdio.h>
#include<string.h>

void get_next(char son[],int next[])
{
	int i,j;
	int len = strlen(son);
	i = 0;
	j = -1;
	next[0]=0;
	while(i < len)
	{
		if(j == -1 || son[i] == son[j])
		{
			i++;
			j++;
			next[i] = j + 1;
		}
		else
			j = next[j] -1;
	}
}

void KMP(char str[],char son[],int pos)
{
	int i = pos;	//�����е�λ������ 
	int j =-1;		//�Ӵ��е�λ������
	
	int len1 = strlen(str);
	int len2 = strlen(son);
	
	int next[1000];	//next����
	get_next(son,next);
	
	while(i < len1 && j <len2)
	{
		if(j == -1 || str[i] == son[j])
		{
			i++;
			j++;
		}
		else
		{
			j = next[j] - 1;
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
		KMP(str,son,i-len2+1);
	}
}

int main()
{
	char str[1000];
	char son[1000];
	gets(str);
	gets(son);
	
	KMP(str,son,0);
	
	return 0;
} 
