import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] newArr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        // 길이가 M인 수열을 구해야 함
        // N개 자연수 중 M개를 고른 오름차순 수열
        newArr = new int[M];

        // 정렬하고 조합 구하자
        Arrays.sort(arr);
        combination(0, 0);

        System.out.println(sb);
    }

    static void combination(int depth, int idx){
        if (depth == M) {
            for (int x: newArr) sb.append(x).append(' ');
            sb.append('\n');
            return;
        }

        for (int i=idx; i<arr.length; i++){
            newArr[depth] = arr[i];
            combination(depth+1, i+1);
        }
    }
}
