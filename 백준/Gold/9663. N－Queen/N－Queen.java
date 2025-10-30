import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] col;
    static boolean[] d1; // \ (x+y=k)
    static boolean[] d2; // / (x-y=k)
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N]; // 열의 수 N
        d1 = new boolean[2*N-1]; // 대각선의 수 (가로+세로-1)
        d2 = new boolean[2*N-1]; // 대각선의 수 (가로+세로-1)

        count = 0;
        dfs(0);

        System.out.println(count);
    }

    static void dfs(int x){
        if (x == N){
            count++;
            return;
        }

        for (int y=0; y<N; y++){
            // 둘 수 없는 자리인 경우
            // d2의 경우, 인덱스가 음수가 될 수 있기때문에 최소를 0으로 보정
            // x-y가 최소가 되는 경우 : x=0, y=N-1
            if (col[y] || d1[x+y] || d2[x-y + N-1]) continue;

            col[y] = d1[x+y] = d2[x-y + N-1] = true;
            dfs(x+1);
            col[y] = d1[x+y] = d2[x-y + N-1] = false;
        }
    }
}
