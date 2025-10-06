import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static char[][] farm;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        farm = new char[R][C];
        for (int r=0; r<R; r++){
            String str = br.readLine();
            for (int c=0; c<C; c++){
                farm[r][c] = str.charAt(c);
            }
        }
        visited = new boolean[R][C];

        count = 0;
        for (int r=0; r<R; r++){
            for (int c=0; c<C; c++){
                if (!visited[r][c] && farm[r][c] == '#') {
                    dfs(r, c);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int r, int c){
        visited[r][c] = true;

        for (int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (0<=nr && nr<R && 0<=nc && nc<C && !visited[nr][nc] && farm[nr][nc] == '#') {
                dfs(nr, nc);
            }
        }
    }
}
