import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N;
	static String[] cards;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			cards = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n=0; n<N; n++) {
				cards[n] = st.nextToken();
			}
			
			int half;
			if (N%2 == 1) half = N/2+1;
			else half = N/2;
			
			Queue<String> q1 = new ArrayDeque<>();
			Queue<String> q2 = new ArrayDeque<>();
			
			for (int i=0; i<half; i++) {
				q1.add(cards[i]);
			}
			for (int i=half; i<N; i++) {
				q2.add(cards[i]);
			}
			
			
			sb.append('#').append(tc).append(' ');
			
			for (int i=1; i<=N; i++) {
				if (i%2==1) sb.append(q1.poll()).append(' ');
				else sb.append(q2.poll()).append(' ');
			}
			sb.append('\n');	
		}
		
		System.out.println(sb);
	}
}
