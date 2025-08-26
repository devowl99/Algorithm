import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][] P;
	static int K;
	static int i, j, x, y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int j=0;
			while(st2.hasMoreTokens()) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
				j++;
			}
		}
		
		P = new int[N+1][M+1];
		for (int r=1; r<=N; r++) {
			for (int c=1; c<=M; c++) {
				P[r][c] = arr[r-1][c-1] + P[r-1][c] + P[r][c-1] - P[r-1][c-1];
			}
		}
		
		K = Integer.parseInt(br.readLine());
		for (int c=0; c<K; c++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st3.nextToken());
			j = Integer.parseInt(st3.nextToken());
			x = Integer.parseInt(st3.nextToken());
			y = Integer.parseInt(st3.nextToken());
			
			int sum = 0;
			sum = P[x][y] - P[i-1][y] - P[x][j-1] + P[i-1][j-1];
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
