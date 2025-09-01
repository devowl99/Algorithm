import java.io.*;

public class Main {
	static int N;
	static int[][] video;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		video = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<N; j++) {
				video[i][j] = str.charAt(j)-'0';
			}
		}
		solve(0, 0, N);
		System.out.println(sb);
	}
	
	static void solve(int r, int c, int size) {
		int ck = check(r, c, size);

		if (ck == 0){
			sb.append(0);
		}
		else if (ck == 1) {
			sb.append(1);
		}
		else if (ck == -1) {
			int half = size/2;
			sb.append("(");
			solve(r, c, half);
			solve(r, c+half, half);
			solve(r+half, c, half);
			solve(r+half, c+half, half);
			sb.append(")");
		}
	}
	
	static int check(int r, int c, int size) {
		int num = video[r][c];
		
		for (int i=r; i<r+size; i++) {
			for (int j=c; j<c+size; j++) {
				if (video[i][j] != num) return -1;
			}
		}
		
		return (num == 0)? 0: 1; 
	}
}