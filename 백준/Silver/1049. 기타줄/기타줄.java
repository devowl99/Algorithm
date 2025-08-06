import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer> pack = new ArrayList<>();
		List<Integer> each = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()); 
			pack.add(Integer.parseInt(st2.nextToken()));
			each.add(Integer.parseInt(st2.nextToken()));
		}
		
		int minPack = Collections.min(pack);
		int minEach = Collections.min(each);
		
		int case1 = minEach*n;
		int case2 = minPack*(n/6 + 1);
		int case3 = minPack*(n/6) + minEach*(n%6);
		
		System.out.println(Math.min(Math.min(case1, case2), case3));
	}
}
