import java.io.*;
import java.util.*;

public class Main {
	static int N, M; 
	static List<Integer>[] com;
	static List<Integer> maxComList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		com = new ArrayList[N+1];
		for (int i=1; i<N+1; i++) {
			com[i] = new ArrayList<>();
		}
		
		int A, B;
		for (int i=0; i<M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st2.nextToken());
			B = Integer.parseInt(st2.nextToken());
			
			com[B].add(A);
		}
		
		int maxCom = Integer.MIN_VALUE;
		for (int i=1; i<com.length; i++) {
			int cur = bfs(i);
			if (cur > maxCom) {
				maxComList = new ArrayList<>();
				maxComList.add(i);
				maxCom = cur;
			}
			else if (cur == maxCom) {
				maxComList.add(i);
			}
		}
		
		Collections.sort(maxComList);
		for (int i=0; i<maxComList.size(); i++) {
			if (i != maxComList.size()-1) {
				System.out.print(maxComList.get(i)+" ");
			}
			else {
				System.out.print(maxComList.get(i));
			}
		}
	}
	
	static int bfs(int start) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
	
		visited[start] = true;
		q.add(start);
		
		int count = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next: com[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
					count++;
				}
			}
		}
		return count;
	}
}