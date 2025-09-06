import java.io.*;

public class Main {
	static int T;
	static int N;
	static int[] dp; // 여기까지 오는데 만들어지는 경우의 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
//		dp[4] = 7;
//		dp[5] = 13;
		for (int i=4; i<=11; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append('\n');
		}
		System.out.println(sb);
	}
}
