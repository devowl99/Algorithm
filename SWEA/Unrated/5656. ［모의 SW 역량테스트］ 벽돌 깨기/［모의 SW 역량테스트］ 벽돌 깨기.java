import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N, W, H;
	static int[][] board;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int minBrick;
	
	static class Point {
	    int x, y, val;
	    
	    Point(int x, int y, int val) {
	        this.x = x;
	        this.y = y;
	        this.val = val;
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			board = new int[H][W];
			for (int h=0; h<H; h++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int w=0; w<W; w++) {
					board[h][w] = Integer.parseInt(st2.nextToken());
				}
			}
			
            int bricks = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                	if (board[i][j] != 0) bricks++;
                }
            }
			
			minBrick = Integer.MAX_VALUE;
            dfs(0, bricks);

            sb.append("#").append(tc).append(" ").append(minBrick).append("\n");
        }
        System.out.print(sb);
	}
	
    static void dfs(int depth, int bricks) {
        if (minBrick == 0) return;
        if (bricks == 0) {
        	minBrick = 0;
        	return;
        	}
        if (depth == N) {
            minBrick = Math.min(minBrick, bricks);
            return;
        }

        for (int x = 0; x < W; x++) {
            int topY = -1;
            for (int y = 0; y < H; y++) {
                if (board[y][x] != 0) {
                	topY = y;
                	break;
                	}
            }

            if (topY == -1) {
                dfs(depth + 1, bricks);
                continue;
            }

            int[][] backup = new int[H][W];
            for (int y = 0; y < H; y++) {
                for (int xx = 0; xx < W; xx++) {
                    backup[y][xx] = board[y][xx];
                }
            }

            int broken = bfsExplode(x, topY);
            gravity();
            
            dfs(depth + 1, bricks - broken);
            for (int y = 0; y < H; y++) {
                for (int xx = 0; xx < W; xx++) {
                    board[y][xx] = backup[y][xx];
                }
            }
        }
    }

	static int bfsExplode(int startX, int startY) {
	    int broken = 0;
	    ArrayDeque<Point> q = new ArrayDeque<>();

	    int v = board[startY][startX];
	    if (v > 1) q.offer(new Point(startX, startY, v));
	    board[startY][startX] = 0;
	    broken++;

	    while (!q.isEmpty()) {
	        Point cur = q.poll();
	        int x = cur.x;
	        int y = cur.y;
	        int k = cur.val;

	        for (int d = 0; d < 4; d++) {
	        	int nx = x, ny = y;
	            for (int step = 1; step < k; step++) {
	                nx += dx[d];
	                ny += dy[d];
	                if ( nx < 0 || nx >= W || ny < 0 || ny >= H) break;
	                if (board[ny][nx] == 0) continue;

	                int val = board[ny][nx];
	                if (val > 1) q.offer(new Point(nx, ny, val));
	                board[ny][nx] = 0;
	                broken++;
	            }
	        }
	    }
	    return broken;
	}
	
	static void gravity() {
	    for (int x = 0; x < W; x++) {
	        int write = H - 1;
	        for (int y = H - 1; y >= 0; y--) {
	            if (board[y][x] != 0) {
	                int v = board[y][x];
	                board[y][x] = 0;
	                board[write--][x] = v;
	            }
	        }
	    }
	}
}
