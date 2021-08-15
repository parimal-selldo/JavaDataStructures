import java.util.*;

public class PrimsAlgo {

    public static class Edge {

        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

    }

    static class Pair implements Comparable<Pair> {
        int v;
        int av; // acquiring vertex
        int wt;

        Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(PrimsAlgo.Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the vertices : ");
        int vtces = sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[vtces];

        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        System.out.print("Enter the edges : ");
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {

            System.out.println();
            System.out.print("Ente the v1 : ");
            int v1 = sc.nextInt();
            System.out.print("Ente the v2 : ");
            int v2 = sc.nextInt();
            System.out.print("Ente the wt : ");
            int wt = sc.nextInt();

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));

        }

        DisplayGraph(graph);
        // calling the display graph function

        System.out.println();

        // write the PRIM'S algo here.

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[vtces];

        while (pq.size() > 0) {

            Pair rem = pq.remove();
            
            if(visited[rem.v])
                continue;

            visited[rem.v] = true;

            if(rem.av != -1)
                System.out.println("[ " + rem.v + " <= " + rem.av + " @ " + rem.wt + " ]");

            for (Edge e : graph[rem.v]) {
                if (visited[e.nbr] == false) {
                    pq.add(new Pair(e.nbr, rem.v, e.wt));
                }
            }

        }


        System.out.println();
        sc.close();

    }

    public static void DisplayGraph(ArrayList<Edge> graph[]) {
        int count = 1;
        System.out.println();
        for (ArrayList<Edge> e : graph) {
            System.out.printf("ArrayList %d : ", count);
            for (Edge a : e) {
                System.out.print("[ ");
                System.out.print(a.src + " => " + a.nbr + " @ " + a.wt);
                System.out.print(" ]   ");

            }
            count++;
            System.out.println();
        }
        System.out.println();
    }

}
