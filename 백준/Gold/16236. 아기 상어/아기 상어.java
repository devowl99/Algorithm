import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int ateCount = 0;
    static int sharkY, sharkX;
    static int totalTime = 0;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            // 거리가 가까운 순, 위쪽, 왼쪽 순으로 정렬
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1[2] != o2[2]) return Integer.compare(o1[2], o2[2]);
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            });

            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];

            q.add(new int[]{sharkY, sharkX, 0});
            visited[sharkY][sharkX] = true;

            boolean foundFish = false;

            while (!q.isEmpty()) {
                int[] curr = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = curr[0] + dy[i];
                    int nx = curr[1] + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
                        if (map[ny][nx] <= sharkSize) {
                            visited[ny][nx] = true;
                            q.add(new int[]{ny, nx, curr[2] + 1});

                            if (map[ny][nx] > 0 && map[ny][nx] < sharkSize) {
                                pq.add(new int[]{ny, nx, curr[2] + 1});
                                foundFish = true;
                            }
                        }
                    }
                }
            }

            if (!foundFish) break;

            // 가장 우선순위가 높은 물고기 먹기
            int[] target = pq.poll();
            sharkY = target[0];
            sharkX = target[1];
            totalTime += target[2];
            map[sharkY][sharkX] = 0;
            ateCount++;

            if (ateCount == sharkSize) {
                sharkSize++;
                ateCount = 0;
            }
        }

        System.out.println(totalTime);
    }
}