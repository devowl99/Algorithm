import java.io.*;
import java.util.*;

public class Solution {
	static final int T = 10;
	static int V, E;
	static int from, to;
	static List<Integer>[] adjList;
	static int[] inDegree;
	static List<Integer> sortList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[V+1];
			for (int i=0; i<=V; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			inDegree = new int[V+1];
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i=0; i<E; i++) {
				from = Integer.parseInt(st2.nextToken());
				to = Integer.parseInt(st2.nextToken());
				adjList[from].add(to);
				inDegree[to]++;
			}
			
			sortList = new ArrayList<>();
			bfs();
			
			sb.append("#").append(tc);
			for (int x: sortList) {
				sb.append(" ").append(x);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i=1; i<=V; i++) {
			if (inDegree[i] == 0) q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sortList.add(cur);
			
			for (int x: adjList[cur]) {
				inDegree[x]--;
				if (inDegree[x] == 0) q.offer(x);
			}
		}
	}
}
