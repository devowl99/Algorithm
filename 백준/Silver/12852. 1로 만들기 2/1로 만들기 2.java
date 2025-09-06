import java.io.*;

public class Main {
	static int N;
	static int[] dp; // 사용된 연산 수
	static int[] prev;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		prev = new int[N+1];
		
		dp[1] = 0; // 기저조건, 1이 될 때까지 사용된 연산 수
		prev[1] = 0;
		
		for (int i=2; i<=N; i++) {
			// 1을 빼는 경우
			dp[i] = dp[i-1] + 1;
			prev[i] = i-1;
			
			// 2로 나누어 떨어지는 경우
			if (i%2 == 0) {
				if (dp[i] > dp[i/2] + 1) {
					dp[i] = dp[i/2] + 1;
					prev[i] = i/2;
				}
			}
			
			// 3으로 나누어 떨어지는 경우
			if (i%3 == 0) {
				if (dp[i] > dp[i/3] + 1) {
					dp[i] = dp[i/3] + 1;
					prev[i] = i/3;
				}
			}
		}
		
		sb.append(dp[N]).append('\n');
		
		// 경로 복원
		int cur=N;
		while (cur != 0) {
			sb.append(cur).append(' ');
			cur = prev[cur];
		}
		
		System.out.println(sb);
	}
}