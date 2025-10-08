import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// input = new BufferedReader(new StringReader(instr));
		int T = Integer.parseInt(input.readLine());
		for(int t=1;t<=T;t++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			// System.out.println("Case #"+t+": "+a+" + "+b+" = "+(a+b));
			output.append("Case #").append(t).append(": ").append(a).append(" + ").append(b).append(" = ").append(a+b).append("\n");
		}
		
		System.out.println(output);
	}
	
	static String instr = "5\r\n"
			+"1 1\r\n"
			+"2 3\r\n"
			+"3 4\r\n"
			+"9 8\r\n"
			+"5 2";
}