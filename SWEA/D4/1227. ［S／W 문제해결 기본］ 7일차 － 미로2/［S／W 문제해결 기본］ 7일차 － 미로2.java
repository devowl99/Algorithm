import java.io.*;

public class Solution {
	static int T = 10;
	static int N = 100;
	static int testCase;
	static int[][] maze;
	static boolean[][] visited;
	static int startX, startY;
	static int answer;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			testCase = Integer.parseInt(br.readLine());
			maze = new int[N][N];
			answer = 0;
			
			for (int i=0; i<N; i++) {
				String str = br.readLine();
				for (int j=0; j<N; j++) {
					int cur = str.charAt(j) - '0';
					maze[i][j] = cur;
					if (cur == 2) {
						startX = j;
						startY = i;
					}
				}
			}
			
			visited = new boolean[N][N];
			dfs(startX, startY);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int x, int y) {
		visited[y][x] = true;
		
		if (maze[y][x] == 3) {
			answer = 1;
			return;
		}
		
		for (int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (0<=nx && nx<N && 0<=ny && ny<N) {
				if (maze[ny][nx] != 1 && !visited[ny][nx]) {
					dfs(nx, ny);
					if (answer == 1) return;
				}
			}
		}
	}
}
