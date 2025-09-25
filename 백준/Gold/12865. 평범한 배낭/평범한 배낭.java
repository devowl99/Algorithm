import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[][] dp;
	static int[] W;
	static int[] V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		W = new int[N+1];
		V = new int[N+1];
		dp = new int[N+1][K+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int w=0; w<=K; w++) {
			dp[0][w] = 0;
		}
		
		for (int i=1; i<=N; i++) {
			for (int w=0; w<=K; w++) {
				dp[i][w] = dp[i-1][w];
				
				if (w >= W[i]) {
					dp[i][w] = Math.max(dp[i][w], dp[i-1][w-W[i]] + V[i]);
				}
			}
		}
		System.out.println(dp[N][K]);	
	}
}
