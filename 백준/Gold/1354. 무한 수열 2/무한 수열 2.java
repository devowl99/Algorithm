import java.io.*;
import java.util.*;

public class Main {
    static long N, P, Q, X, Y;
    static Map<Long, Long> map; // 키-값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken()); // AN 구하기
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        // i가 0 이하일 경우) Ai = 0
        // i가 1 이상일 경우) Ai = A(i/P 미만의 최대 정수-X) + A(i/Q 미만의 최대 정수-Y)
        map = new HashMap<>();
        map.put(0L, 1L);

        long ans = dfs(N);

        System.out.println(ans);
    }

    static long dfs(long i){
        // i<=0 인 경우
        if (i<=0){
            return 1;
        }

        // i>=1 인 경우
        long aipx;
        long aiqy;

        if (map.containsKey(i/P-X)){
            aipx = map.get(i/P-X);
        }
        else aipx = dfs(i/P-X);

        if (map.containsKey(i/Q-Y)){
            aiqy = map.get(i/Q-Y);
        }
        else aiqy = dfs(i/Q-Y);

        map.put(i, aipx + aiqy);
        return aipx + aiqy;
    }
}
