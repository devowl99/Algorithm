import java.io.*;
import java.util.*;

public class Solution {
	static int T, N;
	static int[][] cheese;
	static int maxDate = 0;
	static int loaf, maxLoaf;
	static boolean[][] visited;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					int taste = Integer.parseInt(st.nextToken());
					cheese[i][j] = taste;
					if (maxDate < taste) maxDate = taste;
				}
			}
			
			maxLoaf = 1;
			for (int day=1; day<maxDate; day++) {
				loaf = 0;
				
				for (int i=0; i<N; i++) {
					for (int j=0; j<N; j++) {
						if (cheese[i][j] == day) {
							cheese[i][j] = 0;
						}
					}
				}
				
				visited = new boolean[N][N];
				
				for (int i=0; i<N; i++) {
					for (int j=0; j<N; j++) {
						if (cheese[i][j] != 0 && !visited[i][j]) {
							loaf++;
							bfs(i, j);
						}
					}
				}
				maxLoaf = Math.max(maxLoaf, loaf);
			}
			
			sb.append("#").append(tc).append(" ").append(maxLoaf).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int startR, int startC) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {startR, startC});
		visited[startR][startC] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (0<=nr && nr<N && 0<=nc && nc<N) {
					if (!visited[nr][nc] && cheese[nr][nc] != 0) {
						q.add(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
