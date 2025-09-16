import java.io.*;
import java.util.*;

public class Main {
	static int N; // 나무의 수
	static int M; // 나무의 길이
	static int[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int maxH = 0;
		for (int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, trees[i]);
		}
		
		int low = 0;
		int high = maxH;
		int highest = 0;
		while (low <= high) {
			int mid = (low+high)/2;
			long sum = 0;
			
			for (int tree: trees) {
				if (tree>mid) sum += (tree-mid);
			}
			
			// 필요 이상으로 많이 가져가는 경우
			if (sum >= M) {
				highest = mid;
				low = mid+1;
			}
			
			// 부족한 경우
			else {
				high = mid-1;
			}
		}
		
		System.out.println(highest);
	}
}