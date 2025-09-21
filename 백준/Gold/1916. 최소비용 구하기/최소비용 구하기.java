import java.io.*;
import java.util.*;

// Dijkstra 알고리즘
public class Main {
	static int N; // 도시의 개수 (정점 수)
	static int M; // 버스의 개수 (간선 수)
	
	static List<Node>[] graph;
	static int s; // 버스의 시작 도시 번호
	static int e; // 버스의 도착 도시 번호
	static int cost; // 버스 이동에 필요한 비용
	
	static int ori; // 출발 도시 번호
	static int des; // 도착 도시 번호
	
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	
	static class Node implements Comparable<Node> {
		int u, w;
		
		Node(int u, int w){
			this.u = u; // 정점
			this.w = w; // 누적 최소
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1]; // 정점 리스트 
		for (int m=1; m<=N; m++) {
			graph[m] = new ArrayList<Node>();
		}
		
		StringTokenizer st;
		for (int m=1; m<=M; m++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			
			graph[s].add(new Node(e, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		ori = Integer.parseInt(st.nextToken());
		des = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		System.out.println(dist[des]);
	}
	
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		dist = new int[N+1]; // 정점부터 최소 거리 담기
		Arrays.fill(dist, INF); // 일단 모든 거리 무한대로 초기화
		
		pq.add(new Node(ori, 0)); // 힙에 출발지 넣고 시작 (시작 정점은 거리 0)
		
		while(!pq.isEmpty()) { // 힙이 비어있지 않으면
			Node cur = pq.poll(); // 가장 비용이 작은 정점부터 poll
			
			// dist에 저장된 최소 비용보다 크거나 같으면 고려할 필요 없다.
			if (cur.w >= dist[cur.u]) continue;
			
			// 저장된 최소 비용보다 작으면?
			// 1. dist[]의 비용 갱신
			dist[cur.u] = cur.w;
			
			for (Node edge: graph[cur.u]) { // 현재 정점과 연결된 간선들(다음 정점)
				
				// 2. 시작 정점에서부터 cur.u(현재 정점)까지의 cur.w(비용) 갱신
				edge.w += dist[cur.u];
				
				// 3. pq에 연결된 간선들 add
				pq.add(edge);
			}
			
		}
	}
}
