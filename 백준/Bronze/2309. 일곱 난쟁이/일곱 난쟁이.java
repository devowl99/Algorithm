import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> dwarf = new ArrayList<>();
		for (int i=0; i<9;i++) {
			dwarf.add(Integer.parseInt(br.readLine()));
		}
		
		int sum = 0;
		for (int i=0; i<9;i++) {
			sum += dwarf.get(i);
		}
		
		int who1 = 0;
		int who2 = 0;
		for (int i=0; i<9; i++) {
			for (int j=i+1; j<9; j++) {
				int di = dwarf.get(i);
				int dj = dwarf.get(j);
				if (sum-di-dj == 100) {
					who1 = di;
					who2 = dj;
					break;
				}
			}
			if (who1 != 0) break;
		}
		
		List<Integer> myDwarf = new ArrayList<>();
		for (int i=0; i<9; i++) {
			int d = dwarf.get(i);
			if (d != who1 && d != who2) {
				myDwarf.add(d);
			}
		}
		Collections.sort(myDwarf);
		
		for (int i=0; i<7; i++) {
			System.out.println(myDwarf.get(i));
		}
	}

}