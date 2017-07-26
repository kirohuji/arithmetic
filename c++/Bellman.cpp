/**
*
* author ���㣨Limer��
* date   2017-05-21
* mode   C++
*/
#include<iostream>    
#include<stack>  
using namespace std;

#define MAX 10000  //����Ȩֵ��󲻳���10000

struct Edge
{
    int u;
    int v;
    int w;
};

Edge edge[10000];  //��¼���б�
int dist[100];     //Դ�㵽����i����̾���
int path[100];     //��¼���·��·��
int vertex_num;    //������
int edge_num;      //����
int source;        //Դ��  

bool BellmanFord()
{
    //��ʼ��
    for (int i = 0; i < vertex_num; i++)
        dist[i] = (i == source) ? 0 : MAX;

    //n-1��ѭ�������·��
    for (int i = 1; i <= vertex_num - 1; i++)
    {
        for (int j = 0; j < edge_num; j++)
        {
            if (dist[edge[j].v] > dist[edge[j].u] + edge[j].w)
            {
                dist[edge[j].v] = dist[edge[j].u] + edge[j].w;
                path[edge[j].v] = edge[j].u;
            }
        }
    }

    bool flag = true;  //����Ƿ��и�Ȩ��·

    //��n��ѭ���жϸ�Ȩ��·
    for (int i = 0; i < edge_num; i++)  
    {
        if (dist[edge[i].v] > dist[edge[i].u] + edge[i].w)
        {
            flag = false;
            break;
        }
    }

    return flag;
}

void Print()
{
    for (int i = 0; i < vertex_num; i++)
    {
        if (i != source)
        {
            int p = i;
            stack<int> s;
            cout << "���� " << source << " ������ " << p << " �����·���ǣ� ";

            while (source != p)  //·��˳��������ģ������ȱ��浽ջ
            {
                s.push(p);
                p = path[p];
            }

            cout << source;
            while (!s.empty())  //���δ�ջ��ȡ���Ĳ�������·��
            {
                cout << "--" << s.top();
                s.pop();
            }
            cout << "    ���·�������ǣ�" << dist[i] << endl;
        }

    }
}

int main()
{

    cout << "������ͼ�Ķ�������������Դ�㣺";
    cin >> vertex_num >> edge_num >> source;

    cout << "������" << edge_num << "���ߵ���Ϣ��\n";
    for (int i = 0; i < edge_num; i++)
        cin >> edge[i].u >> edge[i].v >> edge[i].w;

    if (BellmanFord())
        Print();
    else
        cout << "Sorry,it have negative circle!\n";

    return 0;
}