import java.io.*;
import java.util.*;

public class Main {
	static int N; // 같은 크기의 박스 수
	static int L, W, H;
	static double minA;
	static double maxA;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// 한 변의 길이 A가 최대가 될 수 있도록
		minA = 0.0;
		maxA = Math.min(L, Math.min(W, H));
		while (minA<maxA) {
			double mid = (minA + maxA) / 2;
			
			double count = (long)(L/mid) * (long)(W/mid) * (long)(H/mid);
			
			if (count < N) {
				if (maxA == mid) break;
				maxA = mid;
			}
			else {
				if (minA == mid) break;
				minA = mid;
			}
		}
		
		System.out.println(maxA);
	}
}