import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M, X;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverseGraph;
    static final int INF = Integer.MAX_VALUE;

    static int[] dijkstra(ArrayList<Node>[] g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > dist[now.to]) continue;

            for (Node next : g[now.to]) {
                if (dist[next.to] > now.cost + next.cost) {
                    dist[next.to] = now.cost + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
            reverseGraph[to].add(new Node(from, cost));
        }

        int[] go = dijkstra(graph, X);
        int[] back = dijkstra(reverseGraph, X);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, go[i] + back[i]);
        }

        System.out.println(answer);
    }
}
