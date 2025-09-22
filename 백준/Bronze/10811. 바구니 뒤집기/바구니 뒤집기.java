import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int i, j;
	static List<Integer> books;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 1부터 n까지 리스트에 넣기
		books = new ArrayList<Integer>();
		books.add(0);
		for (int n=1; n<=N; n++) {
			books.add(n);
		}
		
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			List<Integer> newlst = new ArrayList<>();
			for (int a=i; a<=j; a++) {
				newlst.add(books.get(a));
			}
			
			Collections.reverse(newlst);
			
			for (int a=1; a<=N; a++) {
				if (i<=a && a<=j) {
					books.set(a, newlst.get(a-i));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if (i!=N) sb.append(books.get(i)).append(' ');
			else sb.append(books.get(i));
		}
		
		System.out.println(sb);
	}
}
