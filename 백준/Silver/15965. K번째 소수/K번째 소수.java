import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static final int MAX = 10_000_000;
	static boolean[] isPrime;
	static List<Integer> prime;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		sieve();
		
		System.out.println(prime.get(K));
	}
	
	static void sieve() {
		isPrime = new boolean[MAX+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		prime = new ArrayList<>();
		for (int i=2; i*i<=MAX; i++) {
			if (isPrime[i]) {
				for (int j=i*i; j<=MAX; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		prime.add(0);
		for (int i=2; i<=MAX; i++) {
			if (isPrime[i]) prime.add(i);
		}
	}
}
