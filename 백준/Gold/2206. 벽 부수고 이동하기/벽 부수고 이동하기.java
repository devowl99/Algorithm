import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] visited; // [row][col][벽 파괴 여부]
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M][2]; // 0: 벽 안부숨, 1: 벽 부숨

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            int destroyed = curr[3];

            if (x == N-1 && y == M-1) {
                return dist;
            }

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0 && visited[nx][ny][destroyed] == 0) {
                        visited[nx][ny][destroyed] = 1;
                        q.offer(new int[]{nx, ny, dist+1, destroyed});
                    }

                    if (map[nx][ny] == 1 && destroyed == 0 && visited[nx][ny][1] == 0) {
                        visited[nx][ny][1] = 1;
                        q.offer(new int[]{nx, ny, dist+1, 1});
                    }
                }
            }
        }

        return -1;
    }
}
