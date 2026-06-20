import java.util.*;

class Edge implements Comparable<Edge> {
    char src, dest;
    int weight;

    Edge(char s, char d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class IoTMST {

    static Map<Character, Character> parent = new HashMap<>();

    static char find(char x) {
        if (parent.get(x) == x)
            return x;

        char root = find(parent.get(x));
        parent.put(x, root);
        return root;
    }

    static void union(char a, char b) {
        parent.put(find(a), find(b));
    }

    public static void main(String[] args) {

        char[] vertices = {'A','B','C','D','E','F','G'};

        for(char v : vertices)
            parent.put(v, v);

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge('E','F',1));
        edges.add(new Edge('B','C',2));
        edges.add(new Edge('F','G',2));
        edges.add(new Edge('C','D',3));
        edges.add(new Edge('A','C',4));
        edges.add(new Edge('D','F',4));

        Collections.sort(edges);

        int cost = 0;

        System.out.println("Minimum Spanning Tree:");

        for(Edge e : edges) {

            char x = find(e.src);
            char y = find(e.dest);

            if(x != y) {

                System.out.println(
                    e.src + " - " + e.dest + " : " + e.weight
                );

                cost += e.weight;
                union(x, y);
            }
        }

        System.out.println("\nTotal MST Cost = " + cost);
    }
}