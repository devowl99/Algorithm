import java.io.*;
import java.util.*;

public class Main {
    static int N, F;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        F = Integer.parseInt(br.readLine());

        // 일단 마지막 2자리를 0으로 만들기
        int base = N - N%100;
        int after = base;
        for (int i=0; i<100; i++){
            if (after % F == 0) break;
            after++;
        }
        int ans = after - base;
        System.out.printf("%02d", ans);
    }
}
