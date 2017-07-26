package Graph;
public class Dijkstra{
    public static final int M = -1;

    public static void main(String[] args){
        int[][] map1 = { 
                { 0,  7,  9,  M,  M, 14 }, 
                { 7,  0,  10, 15, M, M },
                { 9,  10, 0,  11, M, 2 }, 
                { M,  15, 11, 0,  6, M },
                { M,  M,  M,  6,  0, 9 }, 
                { 14, M,  2,  M,  9, 0 } };
        for(int orig=0;orig<6;orig++){
        	 int[] shortPath = dijkstra_alg(map1, orig);
        	 if (shortPath == null)
                 return;
             
             for (int i = 0; i < shortPath.length; i++){
                 System.out.println("从" + (orig + 1) + "出发到" + (i + 1) + "的最短距离为："
                         + shortPath[i]);
             }
        }
    }

    public static int[] dijkstra_alg(int[][] weight, int orig){
        int n = weight.length;              // 顶点个数

        int[] shortest = new int[n];        // 存放从start到其他各点的最短路径
        boolean[] visited = new boolean[n]; // 标记当前该顶点的最短路径是否已经求出，true表示已求出

        // 初始化，第一个顶点求出
        shortest[orig] = 0;
        visited[orig] = true;

        for (int count = 0; count != n - 1; count++){ // 要加入n-1个顶点
            // 选出一个距离初始顶点最近的未标记顶点
            int k = M;     
            int dmin = M;
            for (int i = 0; i < n; i++){
                if (!visited[i] && weight[orig][i] != M){
                     if (dmin == -1 || dmin > weight[orig][i]) {
                         dmin = weight[orig][i];
                         k = i;
                     }
                }
            }

            // 正确的图生成的矩阵不可能出现K == M的情况
            if (k == M){
                System.out.println("the input map matrix is wrong!");
                return null;
            }
            
            shortest[k] = dmin;
            visited[k] = true;

            // 以k为中间点，修正从原点到未访问各点的距离
            for (int i = 0; i < n; i++){
                if (!visited[i] && weight[k][i] != M)  {
                    int callen = dmin + weight[k][i];
                    if (weight[orig][i] == M || weight[orig][i] > callen){
                        weight[orig][i] = callen;
                    }
                }
            }
        }

        return shortest;
    }
}