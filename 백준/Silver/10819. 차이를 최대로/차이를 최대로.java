import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static int maxNum;
    static int[] newA;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            A[n] = Integer.parseInt(st.nextToken());
        }

        newA = new int[N];
        isSelected = new boolean[N];
        maxNum = Integer.MIN_VALUE;
        permutation(0);

        System.out.println(maxNum);
    }

    static void permutation(int depth) {
        if (depth == N){
            maxNum = Math.max(maxNum, calculate());
            return;
        }

        for (int i=0; i<N; i++){
            if (isSelected[i]) continue;

            isSelected[i] = true;
            newA[depth] = A[i];
            permutation(depth+1);
            isSelected[i] = false;
        }
    }

    static int calculate() {
        int cal = 0;
        for (int i=0; i<N-1; i++){
            cal += Math.abs(newA[i]-newA[i+1]);
        }
        return cal;
    }
}
