import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int N, R;
	static final int P = 1234567891;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
            // 분자
            long numerator = 1L;
            for (int i = 0; i < R; i++) {
                numerator = (numerator * (N - i)) % P;
            }

            // 분모
            long denominator = 1L;
            for (int i = 2; i <= R; i++) {
            	denominator = (denominator * i) % P;
            }

            // 분모의 역원 (페르마 소정리)
            long denomInv = pow(denominator, P - 2);

            // 최종 조합
            long result = (numerator * denomInv) % P;

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }

	// 거듭 제곱 구하는 템플릿 메서드 (분할 정복)
    static long pow(long base, long exp) {
        long result = 1L;
        
        while (exp > 0) {
            if (exp % 2 == 1) { // 홀수
            	result = (result * base) % P;
            }
            
            base = (base * base) % P;
            exp /= 2;
        }
        
        return result;
    }
}