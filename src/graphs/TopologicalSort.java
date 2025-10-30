package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);

        topSort(graph, v);
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> stack){
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge edge = graph[curr].get(i);
//            System.out.println("Source :" + edge.src + " and Dest : " + edge.dest);
            if(!vis[edge.dest]) {
                topSortUtil(graph, vis, edge.dest, stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge>[] graph, int v){
        boolean[] vis = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < v; i++){
            if(!vis[i]){
                topSortUtil(graph, vis, i, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
//        graph[0].add(new Edge(0, 5));
//        graph[0].add(new Edge(0, 4));
//
//        graph[1].add(new Edge(1, 3));
//        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 3));
//        graph[2].add(new Edge(2, 5));

        graph[3].add(new Edge(3, 1));
//        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
}
