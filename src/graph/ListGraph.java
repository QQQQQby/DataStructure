package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ListGraph { //邻接表实现的图

    private int n; //顶点个数
    private int e; //边数
    private EdgeNode[] edgeNodes; //邻接表

    public ListGraph(int n) {
        this.n = n;
        e = 0;
        edgeNodes = new EdgeNode[n];
    }

    public boolean exist(int u, int v) { //判断从顶点u邻接到v的边是否存在
        if (u < 0 || v < 0 || u >= n || v >= n)
            throw new RuntimeException("顶点下标越界");
        if (u == v)
            throw new RuntimeException("不允许图中有自回路");
        EdgeNode p = edgeNodes[u];
        while (p != null && p.adjVertex != v) {
            p = p.next;
        }
        return p != null;
    }

    public void insert(int u, int v, int w) { //插入从顶点u邻接到顶点v的值为w的边，在不带权图中w为1
        if (exist(u, v))
            throw new RuntimeException("边已存在");
        EdgeNode p = new EdgeNode(v, w);
        p.next = edgeNodes[u];
        edgeNodes[u] = p;
        e++;
    }

    public void remove(int u, int v) { //删除从顶点u邻接到v的边
        if (u < 0 || v < 0 || u >= n || v >= n)
            throw new RuntimeException("顶点下标越界");
        if (u == v)
            throw new RuntimeException("图中无自回路");
        EdgeNode p = edgeNodes[u], q = null;
        while (p != null && p.adjVertex != v) {
            q = p;
            p = p.next;
        }
        if (p == null)
            throw new RuntimeException("要删除的边不存在");
        if (q == null)
            edgeNodes[u] = p.next;
        else
            q.next = p.next;
    }

    public void reverse() { //将图中所有结点倒序
        EdgeNode[] reversedNodes = new EdgeNode[n];
        for (int i = 0; i < n; i++) {
            EdgeNode p = edgeNodes[i];
            while (p != null) {
                int u = p.adjVertex;
                EdgeNode q = new EdgeNode(i, p.w);
                if (reversedNodes[u] == null) {
                    reversedNodes[u] = q;
                } else {
                    q.next = reversedNodes[u].next;
                    reversedNodes[u].next = q;
                }
                p = p.next;
            }
        }
        edgeNodes = reversedNodes;
    }

    public void DFS() { //深度优先遍历
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(visited, i);
            }
        }
        System.out.println();
    }

    private void DFS(boolean[] visited, int i) { //从顶点i开始深度优先遍历
        visited[i] = true;
        System.out.print(i + " ");
        EdgeNode p = edgeNodes[i];
        while (p != null) {
            if (!visited[p.adjVertex]) {
                DFS(visited, p.adjVertex);
            }
            p = p.next;
        }
    }

    public void BFS() { //宽度优先遍历
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                BFS(visited, i);
            }
        }
        System.out.println();
    }

    private void BFS(boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int v = queue.peek();
            System.out.print(v + " ");
            visited[v] = true;
            queue.remove();
            EdgeNode p = edgeNodes[v];
            while (p != null) {
                if (!visited[p.adjVertex]) {
                    queue.add(p.adjVertex);
                }
                p = p.next;
            }
        }
    }
}


