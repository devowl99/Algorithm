import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ans = 0;
        for (int x = 1; x < N; x++) {
            int sum = x;
            int temp = x;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == N) {
                ans = x;
                break;
            }
        }

        System.out.println(ans);
    }
}
