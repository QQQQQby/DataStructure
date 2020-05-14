package graph;

public class MatrixGraph { //用邻接矩阵实现的图

    int n, e; //顶点和边的数量
    int noEdgeValue; //没有边时的值
    int[][] a; //邻接矩阵

    public MatrixGraph(int n, int noEdgeValue) {
        this.n = n;
        this.e = 0;
        this.noEdgeValue = noEdgeValue;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = noEdgeValue;
            }
            a[i][i] = 0;
        }
    }

    public boolean exist(int u, int v) { //判断从顶点u邻接到v的边是否存在
        if (u < 0 || v < 0 || u >= n || v >= n)
            throw new RuntimeException("顶点下标越界");
        return u != v && a[u][v] != noEdgeValue;
    }

    public void insert(int u, int v, int w) { //插入从顶点u邻接到顶点v的值为w的边，在不带权图中w为1
        if (u < 0 || v < 0 || u >= n || v >= n)
            throw new RuntimeException("顶点下标越界");
        if (u == v)
            throw new RuntimeException("不允许图中有自回路");
        if (a[u][v] != noEdgeValue)
            throw new RuntimeException("边已经存在");
        if (w == noEdgeValue)
            throw new RuntimeException("边的值不合法");
        a[u][v] = w;
        e++;
    }

    public void remove(int u, int v) { //删除从顶点u邻接到v的边
        if (u < 0 || v < 0 || u >= n || v >= n)
            throw new RuntimeException("顶点下标越界");
        if (u == v)
            throw new RuntimeException("图中没有自回路");
        if (a[u][v] == noEdgeValue)
            throw new RuntimeException("边不存在");
        a[u][v] = noEdgeValue;
        e--;
    }


}
