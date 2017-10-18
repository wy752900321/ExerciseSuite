package com.cenrise.algorithms.graph;

/**
 * 邻接矩阵
 * 图的邻接矩阵表示方式
 * 首先需要了解图数据结构的组成部分。图的表示需要顶点数、边数以及它们的连接关系。本方法采用一个大小为V*V的矩阵Adj，其中矩阵的值为布尔值。
 * 如果存在一条从顶点u到顶点v的边，则设置Adj[u,v]为1，否则为0.
 */
public class Graph {
    private boolean adjMatrix[][];
    private int vertexCount;

    public Graph(int vertexCount) {
        //顶点
        this.vertexCount = vertexCount;
        //矩阵
        adjMatrix = new boolean[vertexCount][vertexCount];
    }

    /**
     * 添加边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
        }

    }

    /**
     * 删除边
     *
     * @param i
     * @param j
     */
    public void removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            adjMatrix[i][j] = false;
            adjMatrix[j][i] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            return adjMatrix[i][j];
        } else {
            return false;
        }
    }
}
