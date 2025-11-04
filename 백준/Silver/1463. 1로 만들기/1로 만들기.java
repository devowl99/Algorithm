import java.io.*;
import java.util.*;

public class Main {
    static int X;
    static int[] dp; // 여기까지 오는 데 걸리는 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        dp = new int[X+1];
        dp[1] = 0; // 1까지 오는데 0번 필요

        for (int i=2; i<=X; i++){
            dp[i] = dp[i-1] + 1; // 가장 기본 경우

            if (i%2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if (i%3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }

        System.out.println(dp[X]);
    }
}
