import java.io.*;

public class Main {
	static int N;
	static int[] dp; // 오는데까지 걸리는 횟수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dp[1] = 0; // 1까지 오는데 0회 (초기값)
		for (int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			
			if (i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
			if (i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}