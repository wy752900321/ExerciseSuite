/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: wu_ch[wu_ch@suixingpay.com]
 * @date: 2017年10月18日 上午10:29:12
 * @Copyright ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.cenrise.algorithms.graph;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * TODO
 *
 * @author: wu_ch[wu_ch@suixingpay.com]
 * @date: 2017年10月18日 上午10:29:12
 * @version: V1.0
 * @review: wu_ch[wu_ch@suixingpay.com]/2017年10月18日 上午10:29:12
 */

/*
 * 求解无向图的单源最短路径
 */
public class NonDirectedGraph {
    //顶点
    private class Vertex {
        public String vertexLabel;// 顶点标识
        private List<Edge> adjEdges;// 与该顶点邻接的边(点)
        private int dist;// 顶点距离
        private Vertex preNode;

        public Vertex(String vertexLabel) {
            this.vertexLabel = vertexLabel;
            adjEdges = new LinkedList<Edge>();
            dist = Integer.MAX_VALUE;
            preNode = null;
        }
    }

    //边
    private class Edge {
        private Vertex endVertex;

        public Edge(Vertex endVertex) {
            this.endVertex = endVertex;
        }
    }

    private Map<String, Vertex> nonDirectedGraph;
    private Vertex startVertex;// 图的起始顶点
    private Vertex endVertex;// 图的结束顶点

    public NonDirectedGraph(String graphContent) {
        nonDirectedGraph = new LinkedHashMap<String, Vertex>();
        buildGraph(graphContent);
    }

    private void buildGraph(String graphContent) {
        String[] lines = graphContent.split("\n");

        String startNodeLabel, endNodeLabel;
        Vertex startNode, endNode;
        for (int i = 0; i < lines.length; i++) {
            String[] nodesInfo = lines[i].split(",");
            startNodeLabel = nodesInfo[1];
            endNodeLabel = nodesInfo[2];

            endNode = nonDirectedGraph.get(endNodeLabel);
            if (endNode == null) {
                endNode = new Vertex(endNodeLabel);
                nonDirectedGraph.put(endNodeLabel, endNode);
            }

            startNode = nonDirectedGraph.get(startNodeLabel);
            if (startNode == null) {
                startNode = new Vertex(startNodeLabel);
                nonDirectedGraph.put(startNodeLabel, startNode);
            }
            Edge e = new Edge(endNode);
            // 对于无向图而言,起点和终点都要添加边
            endNode.adjEdges.add(e);
            startNode.adjEdges.add(e);
        }
        startVertex = nonDirectedGraph.get(lines[0].split(",")[1]);// 总是以文件中第一行第二列的那个标识顶点作为源点
    }

    public void setSearchtKey(Integer startKey, Integer endKey) {
        startVertex = nonDirectedGraph.get(startKey.toString());
        endVertex = nonDirectedGraph.get(endKey.toString());
    }

    public List<Integer> getShortestPath(Integer startKey, Integer lastKey) {
        List<Integer> shortPath = new ArrayList<Integer>();
        setSearchtKey(startKey, lastKey);
        unweightedShortestPath(startVertex, endVertex);
        Collection<Vertex> vertexs = nonDirectedGraph.values();
        for (Vertex vertex : vertexs) {
            if (vertex.vertexLabel.equals(lastKey.toString())) {
                //System.out.print(vertex.vertexLabel + "<--");
                shortPath.add(Integer.parseInt(vertex.vertexLabel));
                Vertex tmpPreNode = vertex.preNode;
                while (tmpPreNode != null) {
                    //System.out.print(tmpPreNode.vertexLabel + "<--");
                    shortPath.add(Integer.parseInt(tmpPreNode.vertexLabel));
                    tmpPreNode = tmpPreNode.preNode;
                }
                //System.out.println("distance=" + vertex.dist);
            }
        }
        Collections.reverse(shortPath);
        return shortPath;
    }

    public void unweightedShortestPath() {
        unweightedShortestPath(startVertex);
    }

    /*
     * 计算源点s到无向图中各个顶点的最短路径 需要一个队列来保存图中的顶点,初始时,源点入队列,然后以广度的形式向外扩散求解其他顶点的最短路径
     */
    private void unweightedShortestPath(Vertex s) {
        // 初始化
        Queue<Vertex> queue = new LinkedList<Vertex>();
        s.dist = 0;
        queue.offer(s);// 将源点dist设置为0并入队列

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge e : v.adjEdges) {// 扫描v的邻接边(点)
                if (e.endVertex.dist == Integer.MAX_VALUE) {// 如果这个顶点(e.endVertex)未被访问(每个顶点只会入队列一次)
                    e.endVertex.dist = v.dist + 1;// 更新该顶点到源点的距离
                    queue.offer(e.endVertex);
                    e.endVertex.preNode = v;// 设置该顶点的前驱顶点
                } // end if
            } // end for
        } // end while
    }

    /*
     * 计算源点s到指定顶点的最短路径 需要一个队列来保存图中的顶点,初始时,源点入队列,然后以广度的形式向外扩散求解其他顶点的最短路径
     */
    private void unweightedShortestPath(Vertex start, Vertex end) {
        // 初始化
        Queue<Vertex> queue = new LinkedList<Vertex>();
        start.dist = 0;
        queue.offer(start);// 将源点dist设置为0并入队列

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge e : v.adjEdges) {// 扫描v的邻接边(点)
                if (e.endVertex.dist == Integer.MAX_VALUE) {// 如果这个顶点(e.endVertex)未被访问(每个顶点只会入队列一次)
                    e.endVertex.dist = v.dist + 1;// 更新该顶点到源点的距离
                    queue.offer(e.endVertex);
                    e.endVertex.preNode = v;// 设置该顶点的前驱顶点
                } // end if
            } // end for
        } // end while
    }

    // 打印图中所有顶点到源点的距离及路径
    public void showDistance() {
        Collection<Vertex> vertexs = nonDirectedGraph.values();
        for (Vertex vertex : vertexs) {
            System.out.print(vertex.vertexLabel + "<--");
            Vertex tmpPreNode = vertex.preNode;
            while (tmpPreNode != null) {
                System.out.print(tmpPreNode.vertexLabel + "<--");
                tmpPreNode = tmpPreNode.preNode;
            }
            System.out.println("     distance=" + vertex.dist);
        }
    }

    public static void main(String[] args) {
        ClassLoader classLoader = NonDirectedGraph.class.getClassLoader();
        URL resource = classLoader.getResource("Graph2NonDirectedGraph2.txt");
        String graphFilePath = resource.getPath();
        System.out.println(graphFilePath);

        String graphContent = FileUtil.read(graphFilePath, 10000);
        NonDirectedGraph graph = new NonDirectedGraph(graphContent);
        graph.unweightedShortestPath();
        graph.showDistance();
        System.out.println();

        //序号，起点，终点，权重
        List<Integer> path = graph.getShortestPath(0, 4);
        for (Integer tmp : path) {
            System.out.println(tmp);
        }
    }
}