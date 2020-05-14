package graph;

public class EdgeNode { //边结点

    int adjVertex; //邻接的顶点下标
    int w; //边的权值
    EdgeNode next; //下一个边结点

    public EdgeNode(int adjVertex, int w) {
        this.adjVertex = adjVertex;
        this.w = w;
        next = null;
    }

}
