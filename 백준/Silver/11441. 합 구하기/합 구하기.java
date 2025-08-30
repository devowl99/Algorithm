import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] P;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		P = new int[N+1];
		for (int i=1; i<=N; i++) {
			P[i] = P[i-1] + arr[i-1];
		}
		
		M = Integer.parseInt(br.readLine());
		for (int t=0; t<M; t++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st2.nextToken());
			int j = Integer.parseInt(st2.nextToken());
			
			int sum = P[j] - P[i-1];
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
