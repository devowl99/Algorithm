import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Edge>[] g;
    static boolean[] vis;
    static long maxDist;
    static int farNode;

    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        g = new ArrayList[n+1];
        for (int i=1; i<=n; i++) g[i] = new ArrayList<>();

        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g[p].add(new Edge(c, w));
            g[c].add(new Edge(p, w));
        }

        vis = new boolean[n+1];
        vis[1] = true;
        maxDist = 0;
        farNode = 1;
        dfs(1, 0);

        vis = new boolean[n+1];
        vis[farNode] = true;
        maxDist = 0;
        dfs(farNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int u, long dist) {
        if (dist > maxDist) {
            maxDist = dist;
            farNode = u;
        }

        for (Edge e : g[u]) {
            if (!vis[e.to]) {
                vis[e.to] = true;
                dfs(e.to, dist + e.w);
            }
        }
    }
}
