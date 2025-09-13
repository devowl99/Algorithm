import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] dp;
	static List<Integer> square;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		square = new ArrayList<>();
		for (int i=1; i*i<=N; i++) {
			square.add(i*i);
		}
		
		dp[1] = 1;
		for (int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			
			for (int x: square) {
				if (i >= x) {
					dp[i] = Math.min(dp[i], dp[i-x] + 1);
				}
				else break;
			}
		}
		System.out.println(dp[N]);
	}
}
