import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] isSelected;
    static int[] newArr;
    static Set<String> resultSet;
    static StringBuilder sbMini;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isSelected = new boolean[N];
        newArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        resultSet = new LinkedHashSet<>();
        sbMini = new StringBuilder();
        dfs(0);

        for (String l: resultSet){
            sb.append(l).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int depth){
        if (depth == M){
            for (int x: newArr){
                sbMini.append(x).append(' ');
            }

            resultSet.add(sbMini.toString());
            sbMini = new StringBuilder();
            return;
        }

        for (int i=0; i<N; i++){
            if (isSelected[i]) continue;

            isSelected[i] = true;
            newArr[depth] = arr[i];
            dfs(depth+1);
            isSelected[i] = false;
        }
    }
}
