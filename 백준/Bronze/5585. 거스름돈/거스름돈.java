import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int change = 1000-n;
		int count = 0;
		
		count += (change/500);
		change = change % 500;
		count += (change/100);
		change = change % 100;
		count += (change/50);
		change = change % 50;
		count += (change/10);
		change = change % 10;
		count += (change/5);
		change = change % 5;
		count += change;
		
		System.out.println(count);
	}
}