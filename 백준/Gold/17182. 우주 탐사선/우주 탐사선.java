import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] dist;
    static boolean[] visited;
    static int best = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 워샬) 모든 i->j 최단거리로 보정
        // i에서 j로 갈 때, mid를 거쳐가는게 더 빠르다면 해당 값으로 갱신
        for (int mid = 0; mid < N; mid++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cand = dist[i][mid] + dist[mid][j];
                    if (dist[i][j] > cand) dist[i][j] = cand;
                }
            }
        }

        visited = new boolean[N];
        visited[K] = true;

        dfs(K, 1, 0);

        System.out.println(best);
    }

    static void dfs(int cur, int count, int cost) {
        if (cost >= best) return; // 가지치기

        // 전부 방문한 경우 최솟값 갱신 후 return
        if (count == N) {
            best = Math.min(best, cost);
            return;
        }

        // 새로 방문할 행성 선택
        for (int nxt = 0; nxt < N; nxt++) {
            if (!visited[nxt]) {
                visited[nxt] = true;
                dfs(nxt, count + 1, cost + dist[cur][nxt]);
                visited[nxt] = false;
            }
        }
    }
}
