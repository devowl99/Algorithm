import java.io.*;
import java.util.*;

public class Main {
	static int holeNum, tapeLen;
	static List<Integer> waterHole;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		holeNum = Integer.parseInt(st.nextToken());
		tapeLen = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		waterHole = new ArrayList<>();
		while(st2.hasMoreTokens()) {
			waterHole.add(Integer.parseInt(st2.nextToken()));
		}
		
		Collections.sort(waterHole);
		
		int count = 1;
		double tapeEnd = waterHole.get(0) - 0.5 + tapeLen;
		for (int i=1; i<waterHole.size(); i++) {
			if (waterHole.get(i) > tapeEnd) {
				tapeEnd = waterHole.get(i) - 0.5 + tapeLen;
				count++;
			}	
		}
		
		System.out.println(count);
	}
}