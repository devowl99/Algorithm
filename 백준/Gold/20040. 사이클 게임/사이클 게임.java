import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int p[];
	static List<Edge> edgeList;
	static int path;
	static boolean cycle;
	
	static class Edge{
		int from, to;
		Edge(int from, int to){
			this.from = from;
			this.to = to;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N];
		
		make();
		
		edgeList = new ArrayList<>();
		for (int m=0; m<M; m++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st2.nextToken());
			int t = Integer.parseInt(st2.nextToken());
			
			edgeList.add(new Edge(f, t));
		}
		
		path = 0;
		cycle = false;
		for (Edge e: edgeList) {
			path++;
			if (!union(e.from, e.to)) {
				cycle = true;
				break;
			}
		}
		
		if (!cycle) path = 0;
		System.out.println(path);
	}
	
	static void make() {
		for (int i=0; i<N; i++) p[i] = i;
	}
	
	static int find(int i) {
		if (p[i] == i) return i;
		return p[i] = find(p[i]);
	}
	
	static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX == rootY) return false;
		
		if (rootX > rootY) p[rootY] = rootX;
		else p[rootX] = rootY;
		
		return true;
	}
}
