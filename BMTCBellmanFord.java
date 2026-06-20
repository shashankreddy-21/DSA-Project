import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class BMTCBellmanFord {

    static final int V = 7;

    public static void bellmanFord(ArrayList<Edge> edges, int source) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.src] != Integer.MAX_VALUE &&
                    dist[e.src] + e.weight < dist[e.dest]) {

                    dist[e.dest] = dist[e.src] + e.weight;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.src] != Integer.MAX_VALUE &&
                dist[e.src] + e.weight < dist[e.dest]) {

                System.out.println("Negative Cycle Detected!");
                return;
            }
        }

        String[] hubs = {"MJC", "KEM", "JAY", "KOR", "WHF", "HBR", "MRT"};

        System.out.println("Shortest distance from MJC:");
        for (int i = 0; i < V; i++) {
            System.out.println(hubs[i] + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,8));
        edges.add(new Edge(0,2,5));
        edges.add(new Edge(1,3,1));
        edges.add(new Edge(2,3,4));
        edges.add(new Edge(3,4,6));
        edges.add(new Edge(4,6,-3));
        edges.add(new Edge(6,5,3));
        edges.add(new Edge(2,5,10));
        edges.add(new Edge(1,4,7));
        edges.add(new Edge(3,6,3));
        edges.add(new Edge(5,6,2));

        bellmanFord(edges,0);
    }
}