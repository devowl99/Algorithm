import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] score;
	static int k;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		score = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		k = Integer.parseInt(br.readLine());
		
		int len = N/k;
		arr = new int[len];
		
        for (int i = 0; i < N; i += len) {
            for (int j = 0; j < len; j++) {
                arr[j] = score[i + j];
            }
            Arrays.sort(arr);
            for (int j = 0; j < len; j++) {
                score[i + j] = arr[j];
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(score[i]);
            if (i != N-1) sb.append(' ');
        }
        System.out.println(sb);
    }
}