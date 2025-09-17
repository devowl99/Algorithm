import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static int x;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		x = Integer.parseInt(br.readLine());
		
		int l = 0;
		int r = n-1;
		int sum = 0;
		int count = 0;
		while (l<r) {
			sum = arr[l] + arr[r];
			
			if (sum > x) { // 두 수의 합이 x보다 크면?
				r--;
			}
			
			else if (sum < x) { // 두 수의 합이 x보다 작으면?
				l++;
			}
			
			else { // 두 수의 합이 x면?
				count++;
				l++;
				r--;
			}
		}
		
		System.out.println(count);
	}
}
