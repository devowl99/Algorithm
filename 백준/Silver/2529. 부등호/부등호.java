import java.io.*;
import java.util.*;

public class Main {
    static int k; // 부등호의 수
    static int N; // 자릿수
    static char[] sign;
    static int[] perm;
    static boolean[] isSelected;
    static StringBuilder sb;

    static long maxNum = Long.MIN_VALUE;
    static long minNum = Long.MAX_VALUE;

    static String maxS="";
    static String minS="";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        k = Integer.parseInt(br.readLine());
        N = k+1;

        sign = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++){
            sign[i] = st.nextToken().charAt(0);
        }

        // 순열로 10(0~9)Pk 구하자
        perm = new int[N];
        isSelected = new boolean[10];
        permutation(0);

        System.out.println(maxS);
        System.out.println(minS);
    }

    static void permutation(int depth){
        if (depth == N){
            for (int p: perm){
                sb.append(p);
            }
            long cur = Long.parseLong(sb.toString());
            if (maxNum<cur) {
                maxNum = cur;
                maxS = sb.toString();
            }
            if (minNum>cur){
                minNum = cur;
                minS = sb.toString();
            }
            sb = new StringBuilder();
            return;
        }

        for (int i=0; i<10; i++) {
            if (isSelected[i]) continue;

            isSelected[i] = true;
            perm[depth] = i;
            if (depth != 0 && calculate(depth-1, depth)) permutation(depth+1);
            else if (depth == 0) permutation(depth+1);
            isSelected[i] = false;
        }
    }

    static boolean calculate(int former, int latter){
        if (sign[former] == '<'){
            return perm[former] < perm[latter];
        }
        else if (sign[former] == '>'){
            return perm[former] > perm[latter];
        }
        return false;
    }
}
