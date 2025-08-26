import java.io.*;
import java.util.*;

public class Main {
	static long A, B, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long answer = pow(A, B, C);
		
		System.out.println(answer%C);
	}
	
	static long pow(long a, long b, long c) {
		if (b == 0) return 1%c;
		if (b == 1) return a%c;
		long half = pow(a, b/2, c);
		long result = (half*half)%c;
		
		if (b%2 == 1)
			return (result*a)%c;
		else
			return result;
	}
}