import java.io.*;
import java.util.*;

public class Main {
	static Queue<Integer> inputs;
	static boolean[] isPrime;
	static int MAX;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		inputs = new ArrayDeque<>();
		while (true) {
			int input = Integer.parseInt(br.readLine());
			if (input==0) break;
			inputs.add(input);
		}
		
		MAX = Collections.max(inputs);
		sieve();
		
		int a = 0;
		int b = 0;
		while (!inputs.isEmpty()) {
			int n = inputs.poll();
			
			for (int i=3; i<=n/2; i+=2) {
				if (isPrime[i] && isPrime[n-i]) {
					a = i;
					b = n-i;
					break;
				}
			}
			
			if (a==0) {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
			else {
				sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void sieve() {
		isPrime = new boolean[MAX+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		
		for (int i=2; i*i<=MAX; i++) {
			if (isPrime[i]) {
				for (int j=i*i; j<=MAX; j+=i) {
					isPrime[j] = false;
				}
			}
		}
	}
}
