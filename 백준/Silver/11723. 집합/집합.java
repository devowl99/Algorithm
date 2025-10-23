import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static Set<Integer> S;
    static Set<Integer> newSet;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());

        S = new HashSet<>();
        newSet = new HashSet<>();
        for (int i=1; i<=21; i++){
            newSet.add(i);
        }

        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());

            execute(cmd, x);
        }
        System.out.println(sb);
    }

    static void execute(String cmd, int x){
        switch (cmd){
            case "add":
                S.add(x);
                break;
            case "remove":
                S.remove(x);
                break;
            case "check":
                int k = S.contains(x)? 1:0;
                sb.append(k).append('\n');
                break;
            case "toggle":
                if (S.contains(x)) S.remove(x);
                else S.add(x);
                break;
            case "all":
                S = new HashSet<>(newSet);
                break;
            case "empty":
                S = new HashSet<>();
                break;
        }
    }
}
