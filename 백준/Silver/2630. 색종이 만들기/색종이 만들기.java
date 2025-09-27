import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] garden;
	static int good;
	static int bad;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		garden = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, N);
		sb.append(good).append("\n").append(bad);
		System.out.println(sb);
	}
	
	static void solve(int r, int c, int size) {
		int ck = check(r, c, size);
		if (ck == 0) good++;
		else if (ck == 1) bad++;
		else {
			int half = size/2;
			solve(r, c, half); // 좌상
			solve(r, c+half, half); // 우상
			solve(r+half, c, half); // 좌하
			solve(r+half, c+half, half); // 우하
		}
	}
	
	static int check(int R, int C, int size) {
		int numType = garden[R][C];
		for (int r=R; r<R+size; r++) {
			for (int c=C; c<C+size; c++) {
				if (garden[r][c] != numType) return -1; // 다른 색이 존재하는 경우
			}
		}
		return numType; // 모두 같은 색일 경우
	}
}
