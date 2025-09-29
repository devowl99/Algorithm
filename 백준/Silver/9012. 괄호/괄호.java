import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static Deque<Character> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			stack = new ArrayDeque<>();
			String str = br.readLine();
			boolean yes = true;
			
			for(int i=0; i<str.length(); i++) {
				char next = str.charAt(i);
				if (next == '(') stack.push(next);
				else if (next == ')') {
					if (stack.isEmpty()) {
						yes = false;
						break;
					}
					stack.pop();
				}
			}
			
			if (yes && stack.isEmpty()) sb.append("YES").append('\n');
			else sb.append("NO").append('\n');
		}
		System.out.println(sb);
	}
}
