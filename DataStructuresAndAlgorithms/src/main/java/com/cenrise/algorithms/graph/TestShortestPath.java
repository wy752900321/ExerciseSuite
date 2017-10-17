package com.cenrise.algorithms.graph;

public class TestShortestPath {

    public static void main(String[] args) {
        String graphFilePath;
        if (args.length == 0)
            graphFilePath = "./无向图的最短路径算法.txt";
        else
            graphFilePath = args[0];
        String graphContent = FileUtil.read(graphFilePath, null);
        NonDirectedGraph graph = new NonDirectedGraph(graphContent);
        graph.unweightedShortestPath();
        graph.showDistance();
    }
}
