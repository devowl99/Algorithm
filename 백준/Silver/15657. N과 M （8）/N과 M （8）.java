import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static StringBuilder sb;
    static int[] arr;
    static int[] newArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        newArr = new int[M];
        combination(0, 0);

        System.out.print(sb);
    }

    static void combination(int depth, int start){
        if (depth == M) {
            for (int x: newArr){
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i=start; i<N; i++){
            newArr[depth] = arr[i];
            combination(depth+1, i);
        }
    }
}
