import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] T; // 소요 시간
    static int[] P; // 금액
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        StringTokenizer st;
        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+2];
        for (int i=1; i<=N; i++){ // i = 몇 번째 날인지

            // 1. 상담 안하고 넘기는 경우
            dp[i+1] = Math.max(dp[i], dp[i+1]);

            // 2. 퇴사 전까지 상담 끝나는 경우
            if (i+T[i] <= N+1) {
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);
            }
        }

        System.out.println(dp[N+1]);
    }
}
