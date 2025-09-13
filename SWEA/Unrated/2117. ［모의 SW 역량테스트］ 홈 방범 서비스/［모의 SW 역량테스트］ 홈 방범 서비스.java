import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N, M; // 도시의 크기, 집이 지불할 수 있는 비용
	static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
	
    static class Node {
        int x, y, d;
        Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = 0;
            for (int y=0; y<N; y++) {
                for (int x=0; x<N; x++) {
                    for (int k=1; k<=N+1; k++) {
                        int cost = k*k + (k-1)*(k-1);
                        int houses = bfs(x, y, k-1);

                        if (houses * M >= cost) {
                            answer = Math.max(answer, houses);
                        }
                    }
                }
            }
            
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
    static int bfs(int x, int y, int maxD) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        
        q.offer(new Node(x, y, 0));
        visited[y][x] = true;

        int count = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (map[cur.y][cur.x] == 1) count++;
            if (cur.d == maxD) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (0<=nx && nx<N && 0<=ny && ny<N && !visited[ny][nx]) {
                	visited[ny][nx] = true;
                    q.offer(new Node(nx, ny, cur.d + 1));
                }
            }
        }
        return count;
    }
}