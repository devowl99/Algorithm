import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		for (int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		// 5개가 연속적
		int s = 0;
		int count = 4;
		for (int e=0; e<N; e++) {
			while (arr[e]-arr[s] > 4) { // 두 수의 차가 4보다 크면
				s++;
			}
			
			count = Math.min(count, 5-(e-s+1));
		}
		
		System.out.println(count);
	}
}