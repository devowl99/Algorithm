import java.io.*;

public class Main {
	static int N;
	static long[][] dp; // 여기까지 경우의 수가 몇 개 쌓였는가?
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1][2]; // N자리 수, 0/1
		
		// 시작은 항상 1
		dp[1][1] = 1;
		dp[1][0] = 0;
		for (int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1]; // 0 다음엔 0 or 1
			dp[i][1] = dp[i-1][0]; // 연속된 1은 안됨 
		}
		System.out.println(dp[N][0] + dp[N][1]);
	}
}
