import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<Integer> road;
	static List<Integer> city;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		road = new ArrayList<>();
		while (st.hasMoreTokens()) {
			road.add(Integer.parseInt(st.nextToken()));
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		city = new ArrayList<>();
		while (st2.hasMoreTokens()) {
			city.add(Integer.parseInt(st2.nextToken()));
		}
		
		long minCost = city.get(0);
		long totalCost = 0;
		for (int i=0; i<city.size()-1; i++) {
			if (minCost > city.get(i)) {
				minCost = (long) city.get(i);
			}
			
			totalCost += (road.get(i) * minCost);
		}
		
		System.out.println(totalCost);
	}
}
