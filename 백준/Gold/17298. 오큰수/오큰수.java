import java.io.*;
import java.util.*;

public class Main {
	static int N; // 수열의 크기
	static int[] A;
	static Deque<Integer> stack;
	static int[] NGE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		stack = new ArrayDeque<>();
		NGE = new int[N];
		Arrays.fill(NGE, -1);
		stack.push(0); // 인덱스 값을 넣자
		for (int i=1; i<N; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i])
				NGE[stack.pop()] = A[i];
			stack.push(i);
		}
		
		for (int i=0; i<NGE.length; i++) {
			sb.append(NGE[i]).append(' ');
		};
		
		System.out.println(sb);
	}
}
