import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Point> devilQ;
	static Queue<Point> suyeonQ;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
	
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			visited = new boolean[N][M];
			devilQ = new ArrayDeque<>();
			suyeonQ = new ArrayDeque<>();
			
			for (int n=0; n<N; n++) {
				String str = br.readLine();
				for (int m=0; m<M; m++) {
					char ch = str.charAt(m);
					map[n][m] = ch;
					if (ch == '*') {
						devilQ.offer(new Point(m, n));
					}
					else if (ch == 'S') {
						suyeonQ.offer(new Point(m, n));
						visited[n][m] = true;
					}
				}
			}
			
			int answer = bfs();
			if (answer != -1) {
				sb.append("#").append(tc).append(" ").append(answer).append("\n");
			}
			else {
				sb.append("#").append(tc).append(" GAME OVER\n");
			}
		}
		System.out.println(sb);
	}
	
	static int bfs() {
        int time = 0;

        while (!suyeonQ.isEmpty()) {
            time++;

            // 악마의 손아귀 확장
            int dSize = devilQ.size();
            for (int i = 0; i < dSize; i++) {
                Point cur = devilQ.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                    if (map[ny][nx] == '.') {
                        map[ny][nx] = '*';
                        devilQ.offer(new Point(nx, ny));
                    }
                }
            }

            // 수연 이동
            int sSize = suyeonQ.size();
            for (int i = 0; i < sSize; i++) {
                Point cur = suyeonQ.poll();
                
                if (map[cur.y][cur.x] == '*') continue;
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                    if (map[ny][nx] == 'D') {
                        return time;
                    }
                    if (map[ny][nx] == '.' && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        suyeonQ.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return -1;
	}
}