# 修路问题

![[%E6%88%AA%E5%B1%8F2024-01-16_%E4%B8%8A%E5%8D%8810.40.25.png]]

# 最小生成树

普利姆算法求最小生成树

因为**普利姆算法是构造最小生成树的一种方法**。

1. **最小生成树（MST）**：
    - **定义**：在一个加权连通图中，最小生成树是一种包含所有顶点的树形子图，且其所有边的权重之和最小。简而言之，它是这样一棵树，通过这棵树可以连接图中的所有顶点，并且所用边的总权重尽可能小。
    - **应用**：最小生成树在多个领域有应用，如网络设计（如电信网络、计算机网络）、路径规划、集群分析等。
    - **其他算法**：除了普利姆算法，还有克鲁斯卡尔（Kruskal）算法和索尔（Sollin）算法等用于构建最小生成树。
2. **普利姆算法**：
    - **原理**：普利姆算法从图的一个顶点开始，逐渐长大覆盖整个图。在每一步，算法都添加最小的边，该边连接已经在树中的顶点和不在树中的顶点。
    - **步骤**：
        1. 选择任意一个顶点作为起始点。
        2. 找到连接树中顶点和不在树中顶点之间的最小边，并将这条边及其相连的顶点加入到树中。
        3. 重复步骤2，直到所有的顶点都包含在树中。
    - **特点**：普利姆算法特别适用于稠密图，即边数接近顶点数平方的图。

普利姆算法与最小生成树的主要联系在于，普利姆算法是实现最小生成树的一种有效方法，尤其在处理包含大量边的图时。通过智能选择边来逐步构建树，普利姆算法能够保证最终生成的树的总权重最小。

  

# 代码实现

```Java
class MGraph {
    // 表示图的节点个数
    int verxs;
    // 存放结点数据，这里使用字符数组是因为每个节点用一个字符来标识，如 'A', 'B', 'C' 等。
    char[] data;
    // 存放边，就是我们的邻接矩阵。weight[i][j] 表示节点 i 和节点 j 之间的边的权重
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
```

```Java
//创建最小生成树->村庄的图
class MinTree {
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        // 顶点
        for(i = 0; i < verxs; i++) {
            // graph.data[i] = data[i] 这一步是在做数据复制，将外部传入的顶点数据复制到图中
            graph.data[i] = data[i];
            // 邻接矩阵初始化
            for(j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for(int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph, int v) {
        // 标记顶点是否被访问过
        int[] visited = new int[graph.verxs];

        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        int minWeight = 10000;


        //因为有 graph.verxs顶点，普利姆算法结束后，应该生成graph.verxs - 1条边
        for(int k = 1; k < graph.verxs; k++) {
            //这个是确定每一次生成的子图和哪个结点的距离最近
            for(int i = 0; i < graph.verxs; i++) { // i结点表示被访问过的结点
                for(int j = 0; j< graph.verxs;j++) { //j结点表示还没有访问过的结点
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }
    }
}
```