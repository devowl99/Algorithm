import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] coins;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N+1];
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        count = 0;
        for (int i = N; i > 0; i--) {
            count += (K/coins[i]);
            K %= coins[i];
        }
        
        System.out.println(count);
    }
}
