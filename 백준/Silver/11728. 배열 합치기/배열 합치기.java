import java.io.*;
import java.util.*;

public class Main {
	static int N; // 배열 A 크기
	static int M; // 배열 B 크기
	static List<Integer> A;
	static List<Integer> B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		B = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		A.addAll(B);
		Collections.sort(A);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<A.size(); i++) {
			sb.append(A.get(i)).append(' ');
		}
		System.out.println(sb);
	}
}
