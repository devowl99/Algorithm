import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int end = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int start=0; start<N; start++) {
            while (end<N && A[end]-A[start] < M) {
                end++;
            }

            if (end == N) break;

            minDiff = Math.min(minDiff, A[end]-A[start]);

            if (minDiff == M) break;
        }

        System.out.println(minDiff);
    }
}
