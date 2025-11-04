import java.io.*;

public class Main {
    static int N;
    static int[] dp; // 2*i 타일을 채우는 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }

        dp = new int[N+1];
        dp[1] = 1; // 1*1 세로
        dp[2] = 2; // 1*1 가로, 세로
        for (int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}
