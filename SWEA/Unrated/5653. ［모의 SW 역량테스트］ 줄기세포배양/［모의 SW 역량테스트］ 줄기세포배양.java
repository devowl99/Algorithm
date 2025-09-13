import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N, M, K; // 세로 크기, 가로 크기, 배양 시간
    static int[][] board; // 배양 용기
    static int[][] state; // 1 비활성, 2 활성, 3 죽음
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
	
    static class Cell {
        int	x, y, life, hp, state;
        
        Cell(int x, int y, int life, int hp, int state) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.hp = hp;
            this.state = state;
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
			K = Integer.parseInt(st.nextToken());
			
			int size = N + K*2;
			board = new int[size][size];
			state = new int[size][size];
			
            Queue<Cell> q = new ArrayDeque<>();
			
	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < M; j++) {
	                int x = Integer.parseInt(st.nextToken());
	                if (x > 0) {
	                    int r = i + K;
	                    int c = j + K;
	                    board[r][c] = x;
	                    state[r][c] = 1;
	                    q.offer(new Cell(r, c, x, x, 1));
	                }
	            }
	        }
			
            int result = simulate(q, K, size);
            sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
	
    static int simulate(Queue<Cell> q, int K, int size) {
        for (int time = 1; time <= K; time++) {
            int sizeQ = q.size();
            int[][] newBoard = new int[size][size];

            for (int s = 0; s < sizeQ; s++) {
                Cell cur = q.poll();

                if (cur.state == 1) {
                    cur.hp--;
                    if (cur.hp == 0) {
                        cur.state = 2;
                        cur.hp = cur.life;
                    }
                    q.offer(cur);

                } else if (cur.state == 2) {
                    if (cur.hp == cur.life) {
                        for (int d = 0; d < 4; d++) {
                            int nx = cur.x + dx[d];
                            int ny = cur.y + dy[d];
                            if (board[nx][ny] == 0 && state[nx][ny] == 0) {
                                newBoard[nx][ny] = Math.max(newBoard[nx][ny], cur.life);
                            }
                        }
                    }
                    cur.hp--;
                    if (cur.hp > 0) {
                        q.offer(cur);
                    } else {
                        state[cur.x][cur.y] = 3;
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (newBoard[i][j] > 0 && board[i][j] == 0 && state[i][j] == 0) {
                        board[i][j] = newBoard[i][j];
                        state[i][j] = 1;
                        q.offer(new Cell(i, j, newBoard[i][j], newBoard[i][j], 1));
                    }
                }
            }
        }

        int count = 0;
        for (Cell c : q) {
            if (c.state == 1 || c.state == 2) count++;
        }
        return count;
    }
}
