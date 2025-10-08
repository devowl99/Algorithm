import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			
			int[][] ladder = new int[100][100];
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int j = 0;
				while (st.hasMoreTokens()) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
			
			int x = 0;
			int y = 99;
			for (int i=0; i<100; i++) {
				if (ladder[99][i] == 2) {
					x = i;
					ladder[y][x] = 0;
					break;
				}
			}
			
			int[] dx = {1, -1, 0};
			int[] dy = {0, 0, -1};
			
			while (true) {
				for (int d=0; d<3; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if ((0 <= nx && nx <= 99) && (0 <= ny && ny <= 99)) {
						if (ladder[ny][nx] == 1) {
							ladder[ny][nx] = 0;
							x = nx;
							y = ny;
							break;
						}
					}
				}
				if (y == 0) break;
			}
			
			System.out.println("#" + T + " " + x);
		}
	}
}
