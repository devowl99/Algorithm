import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N; // 학생들의 수
	static int M; // 학생들의 키를 비교한 횟수
	static List<Integer>[] listArr; // 리스트 배열
	static List<Integer>[] reverseArr; // 역방향 배열
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			listArr = new ArrayList[N+1]; // 1-based
			for(int i=1; i<=N; i++) {
				listArr[i] = new ArrayList<>();
			}
			reverseArr = new ArrayList[N+1]; // 1-based
			for(int i=1; i<=N; i++) {
				reverseArr[i] = new ArrayList<>();
			}
			
			int from = 0;
			int to = 0;
			for (int m=0; m<M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				listArr[from].add(to);
				reverseArr[to].add(from);
			}
			
			count = 0;
			for (int i=1; i<=N; i++) {
				int forward = bfs(i, listArr);
				int reverse = bfs(i, reverseArr);
				if (forward + reverse + 1 == N) count++;
			}
			
			sb.append('#').append(tc).append(' ').append(count).append('\n');
		}
		System.out.println(sb);
	}
	
	static int bfs(int start, List<Integer>[] graph) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		q.offer(start);
		visited[start] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next: graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}