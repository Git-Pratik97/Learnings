package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Shortest Path Calculation for all the nodes (Dijkstra's Algorithm)
public class ShortestPathDIJKSTRAS {
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);
        dijkstra(graph, 0, v);
    }

    public static void dijkstra(List<Edge>[] graph, int src, int v){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] distances = new int[v];

        for(int i = 0; i < v; i++){
            if(i != src){
                distances[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] vis = new boolean[v];
        pq.offer(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i = 0; i < graph[curr.node].size(); i++){
                    Edge edge = graph[curr.node].get(i);
                    int a = edge.src;
                    int b = edge.dest;

                    if(distances[a] + edge.weight < distances[b]){ //Relaxation for minimizing the distances
                        distances[b] = distances[a] + edge.weight;
                        pq.offer(new Pair(edge.dest, distances[b]));
                    }

                }
            }
        }

        for(int i = 0; i < v; i++){
            System.out.print(distances[i] + " ");
        }
        System.out.println();
    }

    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Pair implements Comparable<Pair>{
        private int node;
        private int dist;

        public Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;  //Ascending Order
        }
    }

    public static void createGraph(List<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }
}
