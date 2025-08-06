import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		List<Integer> nums = new ArrayList<>();
		for (int i=0; i<s.length(); i++) {
			nums.add(s.charAt(i)-'0');
		}
		
		int count0 = 0;
		int count1 = 0;
		
		int former = nums.get(0);
		if (former == 0) {
			count0++;
		}
		else {
			count1++;
		}
		
		int recent = 0;
		for (int i=1; i<nums.size(); i++) {
			recent = nums.get(i);
			if (former != recent) {
				if (recent == 0) {
					count0++;
				}
				else {
					count1++;
				}
			}
			former = recent;
		}
		
		System.out.println(Math.min(count0, count1));
	}
}
