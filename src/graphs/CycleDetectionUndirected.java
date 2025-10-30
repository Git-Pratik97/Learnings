package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleDetectionUndirected {
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);
        boolean[] vis = new boolean[v];
        boolean isCycle = false;

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]) {
                isCycle = cycleDetection(graph, vis, i, -1);
            }
        }

        System.out.println("Is Cycle Present - " + isCycle);
    }

    public static boolean cycleDetection(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent){
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if(vis[edge.dest] && parent != edge.dest){
                return true;
            }
            else if(!vis[edge.dest]){
                //Parent will be current
                if(cycleDetection(graph, vis, edge.dest, curr)){
                    return true;
                }
            }
        }

        return false;
    }

    //Edge class of Graph
    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    //Create Function to create graph using Edges
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));


        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }
}
