import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        // 원소를 다 더한 값이 S가 되는 경우의 수

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = ans = 0;
        subset(0, sum);

        if (S==0) ans--;
        System.out.println(ans);
    }

    static void subset(int i, int sum){
        if (i == N) {
            if (sum == S) ans++;
            return;
        }

        subset(i+1, sum+arr[i]);
        subset(i+1, sum);
    }
}
