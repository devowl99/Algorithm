import java.io.*;
import java.math.BigInteger;

public class Main {
	static BigInteger N;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = new BigInteger(br.readLine());
		
		long q = 0;
		long l = 0;
		long r = N.longValue();
		
		while (l<=r) {
			long mid = (l+r)/2;
			
            BigInteger midBig = BigInteger.valueOf(mid);    
			
			if (midBig.multiply(midBig).compareTo(N) >= 0) {
				q = mid;
				r = mid-1;
			}
			else {
				l = mid+1;
			}
		}
		
		System.out.println(q);
	}
}
