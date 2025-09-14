import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N; // 지렁이 수
	static Node[] worms; // 지렁이 좌표 배열
	static long sumX;
	static long sumY;
	static long vSize;
	
	static class Node { // 지렁이 좌표
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			worms = new Node[N];
			sumX = 0;
			sumY = 0;
			
			for (int n=0; n<N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				worms[n] = new Node(x, y);
				sumX += x;
				sumY += y;
			}
			
			vSize = Long.MAX_VALUE;
			dfs(0, 0, 0, 0); // 현재 지렁이의 인덱스, 배정한 지렁이 수, 도착 그룹 x 합, 도착 그룹 y 합
			
			sb.append('#').append(tc).append(' ').append(vSize).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int i, int count, long x, long y) {
		if (count == N/2) { // 도착에 배정된 지렁이 수가 N/2가 되었을 때
			long totalX = x - (sumX - x); // 도착 x좌표 - 출발 x좌표
			long totalY = y - (sumY - y); // 도착 y좌표 - 출발 y좌표
			
			vSize = Math.min(vSize, totalX*totalX + totalY*totalY);
			return;
		}
		if (i == N) return; // 모든 지렁이를 다 확인했는데 도착 그룹의 지렁이 수가 N/2가 안되는 경우
		
		// case 1. i번째 지렁이를 도착 그룹에 배정
        dfs(i+1, count+1, x + worms[i].x, y + worms[i].y);
        // case 2. i번째 지렁이를 도착 그룹에 배정하지 않음 (출발 그룹에 배정)
        dfs(i+1, count, x, y);
	}
}
