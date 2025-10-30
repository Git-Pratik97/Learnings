package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DeepCopyGraph {
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        printGraph_BFS(graph, v);
        ArrayList<Edge>[] copiedGraph = new ArrayList[v];

        for (int i = 0; i < copiedGraph.length; i++) {
            copiedGraph[i] = new ArrayList<>();
        }


        boolean[] vis = new boolean[v];

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                dfsCopy(graph, i, copiedGraph, vis);
            }
        }
        System.out.println("Printing Copied Graph ----- ");
        printGraph_BFS(copiedGraph, v);

    }

    public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));

    }

    public static void printGraph_BFS(ArrayList<Edge>[] graph, int v){
        Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[v];
        que.add(graph[0].get(0).src);
        while(!que.isEmpty()){
            int curr = que.remove();
            if(!vis[curr]){
                System.out.println(curr + " ");
                vis[curr] = true;

                for(int i = 0; i < graph[curr].size(); i++){
                    Edge edge = graph[curr].get(i);
                    que.add(edge.dest);
                }
            }
        }
    }

    public static void dfsCopy(ArrayList<Edge>[] graph, int curr, ArrayList<Edge>[] copiedGraph, boolean[] vis){
        System.out.print(curr + " ");
        for(int i = 0; i < graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            copiedGraph[curr].add(new Edge(edge.src, edge.dest));
        }
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
            if(!vis[edge.dest]){
                dfsCopy(graph, edge.dest, copiedGraph, vis);
            }
        }
    }
}
