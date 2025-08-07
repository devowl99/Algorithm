import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y;
    static boolean[][] graph;
    static List<Integer> invited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new boolean[n][n]; // boolean 배열 기본값 false

        for (int t = 1; t <= m; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i=0; i<2; i++) {
                if (i==0) x = Integer.parseInt(st.nextToken());
                else y = Integer.parseInt(st.nextToken());
            }

            graph[x-1][y-1] = true;
            graph[y-1][x-1] = true;
        }

        invited = new ArrayList<>();
        for (int i=1; i<n; i++) {
            if (graph[0][i]) {
                if (!invited.contains(i)) {
                    invited.add(i);
                }
                
                for (int j = 1; j < n; j++) {
                    if (graph[i][j] && !invited.contains(j)) {
                        invited.add(j);
                    }
                }
            }
        }

        System.out.println(invited.size());
    }
}