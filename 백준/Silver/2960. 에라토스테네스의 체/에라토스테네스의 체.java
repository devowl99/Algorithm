import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int count;
	static boolean[] isPrime;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(sieve());
	}
	
	static int sieve() {
		isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		count = 0;
		for(int i=2; i<=N; i++) {
			if (isPrime[i]) {
				for (int j=i; j<=N; j+=i) {
					if (!isPrime[j]) continue;
					isPrime[j] = false;
					count++;
					if (count == K) return j;
				}
			}
		}
		return -1;
	}
}