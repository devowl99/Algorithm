import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Deque<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		stack = new ArrayDeque<>();
		for (int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if (cmd.equals("pop")) {
				if (stack.isEmpty()) sb.append(-1).append('\n');
				else sb.append(stack.pop()).append('\n');
			}
			else if (cmd.equals("size")) {
				sb.append(stack.size()).append('\n');
			}
			else if (cmd.equals("empty")) {
				if (stack.isEmpty()) sb.append(1).append('\n');
				else sb.append(0).append('\n');
			}
			else if (cmd.equals("top")) {
				if (stack.isEmpty()) sb.append(-1).append('\n');
				else sb.append(stack.peek()).append('\n');
			}
		}
		System.out.println(sb);
	}
}
