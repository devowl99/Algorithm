import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q = new ArrayDeque<>();
		for (int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		while(!q.isEmpty()) {
			if (q.size() == 1) sb.append(q.poll()).append(">");
			else {
				for (int i=0; i<K-1; i++) q.offer(q.poll());
				sb.append(q.poll()).append(", ");
			}
		}
		System.out.println(sb);
	}
}