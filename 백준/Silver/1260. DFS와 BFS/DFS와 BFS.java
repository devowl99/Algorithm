import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static List<Integer>[] adj;
    static boolean[] visited;
    static StringBuilder dfsS;
    static StringBuilder bfsS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dfsS = new StringBuilder();
        bfsS = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new List[N+1];
        for (int n=1; n<=N; n++){
            adj[n] = new ArrayList<>();
        }

        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        for (int i=1; i<=N; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(dfsS.append('\n').append(bfsS));
    }

    static void dfs(int v) {
        visited[v] = true;
        dfsS.append(v).append(" ");

        for (int next : adj[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        bfsS.append(start).append(" ");

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    bfsS.append(next).append(" ");
                    q.offer(next);
                }
            }
        }
    }
}
