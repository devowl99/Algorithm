import java.io.*;
import java.util.*;

public class Main {
	static int N, Q;
	static int[] beat;
	static int[] P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		beat = new int[N];
		int t=0;
		while(st2.hasMoreTokens()) {
			beat[t] = Integer.parseInt(st2.nextToken());
			t++;
		}
		
		P = new int[N];
		for (int i=1; i<N; i++) {
			P[i] = P[i-1] + Math.abs(beat[i-1] - beat[i]);
		}
		
		for (int c=0; c<Q; c++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st3.nextToken());
			int r = Integer.parseInt(st3.nextToken());
			int sum = P[r-1] - P[l-1];
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
