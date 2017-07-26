package Graph;

import java.util.Scanner;
public class BellmanFord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //起点，终点，权值，最短距离
        int[] fromVertex, toVertex, weightVertex, dis, preNode;
        //顶点个数，边
        int n, m;
        //表无穷大
        int Inf = 999;
        n = in.nextInt();
        m = in.nextInt();

        //初始化数据
        fromVertex = new int[m];
        toVertex = new int[m];
        weightVertex = new int[m];
        dis = new int[n];
        preNode = new int[n];

        for (int i = 0; i < m; i++) {
            fromVertex[i] = in.nextInt();
            toVertex[i] = in.nextInt();
            weightVertex[i] = in.nextInt();
        }
        //初始化dis
        dis[0] = 0;
        preNode[0] = 1;
        for (int i = 1; i < n; i++) {
            dis[i] = Inf;
        }

        boolean flag;
        //开始处理边，寻找最短路径
        for (int k = 0; k < n - 1; k++) {
            flag = true;
            for (int i = 0; i < m; i++) {
                if (dis[toVertex[i] - 1] > dis[fromVertex[i] - 1] + weightVertex[i]) {
                    dis[toVertex[i] - 1] = dis[fromVertex[i] - 1] + weightVertex[i];
                    //记录终点顶点的前一个顶点
                    //用于输出路径，目标顶点的前一个点到目标顶点一定最短
                    preNode[toVertex[i] - 1] = fromVertex[i];
                    flag = false;
                    //System.out.println("from " + fromVertex[i] + " to " + toVertex[i] + " i=" + (i+1));
                    //刚开始不明白怎么输出路径，就打印了一下
                    //System.out.println("pre " + toVertex[i] + " from " + fromVertex[i] + " i=" + (i+1));
                }
            }
            //如果没有更新过最短路径，表示最短路径寻找完毕。
            if (flag) {
                break;
            }
        }

        //输出顶点1到各个顶点之间的最短路径和距离
        for (int i = 0; i < 5; i++) {
            showPath(preNode, 1, i+1);
            System.out.println(" 距离：" + dis[i]);
        }
    }
    public static void showPath(int[] path, int from, int to) {
        int pre;
        if (from == to) {
            System.out.print(to + " ");
            return;
        }
        pre = path[to - 1];
        showPath(path, from, pre);
        System.out.print(" " + to + " ");
    }
}