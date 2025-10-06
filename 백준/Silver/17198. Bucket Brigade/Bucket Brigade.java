import java.io.*;
import java.util.*;

public class Main {
    static char[][] farm;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int barnX;
    static int barnY;
    static int lakeX;
    static int lakeY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        farm = new char[10][10];
        visited = new boolean[10][10];

        for (int y=0; y<10; y++){
            String str = br.readLine();
            for (int x=0; x<10; x++){
                farm[y][x] = str.charAt(x);
                if (str.charAt(x) == 'B'){
                    barnX = x;
                    barnY = y;
                }
                else if (str.charAt(x) == 'L'){
                    lakeX = x;
                    lakeY = y;
                }
            }
        }
        int ans = bfs(barnX, barnY);
        System.out.println(ans);
    }

    static int bfs(int startX, int startY){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            visited[y][x] = true;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx && nx < 10 && 0 <= ny && ny < 10){
                    if (farm[ny][nx] != 'R' && !visited[ny][nx]) {
                        if (farm[ny][nx] == 'L') {
                            return count;
                        }
                        q.offer(new int[]{nx, ny, count + 1});
                    }
                }
            }
        }
        return 0;
    }
}
