import java.io.*;
import java.util.*;

public class Solution {
	static int T, N;
	static int[][] room;
	static boolean[][] visited;
	static final int[] dx = {1,-1,0,0};
	static final int[] dy = {0,0,1,-1};
	static int maxCount;
	static int roomNum;
	static int startRoom;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			maxCount = Integer.MIN_VALUE;
			roomNum = Integer.MAX_VALUE;
			
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int j=0;
				while (st.hasMoreTokens()) {
					room[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					startRoom = room[i][j];
					bfs(j, i, 1);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(roomNum).append(" ").append(maxCount).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int startX, int startY, int len) {
		Queue<int[]> q = new ArrayDeque<>();
		visited = new boolean[N][N];
		int count;
		
		visited[startY][startX] = true;
		q.add(new int[]{startY, startX, len});
		
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int y = cur[0];
			int x = cur[1];
			count = cur[2];
			
			if (count > maxCount) {
				maxCount = count;
				roomNum = startRoom;
			}
			else if (count == maxCount) {
				if (startRoom < roomNum) {
					roomNum = startRoom;
				}
			}
			
			for (int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if ((0<=nx && nx<N)&&(0<=ny && ny<N)&&!visited[ny][nx]) {
					if (room[ny][nx] == room[y][x]+1) {
						visited[ny][nx] = true;
						q.add(new int[]{ny, nx, count+1});
					}
				}
			}
		}
	}
}