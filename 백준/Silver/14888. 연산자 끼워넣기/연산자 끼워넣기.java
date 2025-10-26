import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static int[] cal;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }

        cal = new int[4];
        st = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        dfs(A[0], 1, plus, minus, mul, div);

        System.out.println(maxNum);
        System.out.println(minNum);
    }

    static void dfs(int num, int i, int pl, int mi, int mu, int di){
        if (pl+mi+mu+di == 0){
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
            return;
        }

        if (pl > 0){
            dfs(num+A[i], i+1, pl-1, mi, mu, di);
        }
        if (mi > 0){
            dfs(num-A[i], i+1, pl, mi-1, mu, di);
        }
        if (mu > 0){
            dfs(num*A[i], i+1, pl, mi, mu-1, di);
        }
        if (di > 0){
            dfs(num/A[i], i+1, pl, mi, mu, di-1);
        }
    }
}
