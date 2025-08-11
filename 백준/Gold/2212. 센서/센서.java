import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static List<Integer> sensor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 집중국의 수가 센서의 수와 같거나 많은 경우
        if (K >= N) {
            System.out.println(0);
            return;
        }

        sensor = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sensor.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(sensor);

        List<Integer> gap = new ArrayList<>();
        for (int j=0; j<sensor.size()-1; j++) {
            gap.add(sensor.get(j+1)-sensor.get(j));
        }
        Collections.sort(gap);

        for (int i=0; i<K-1; i++) {
            gap.remove(gap.size()-1);
        }

        int sum = 0;
        for (int x: gap){
            sum += x;
        }

        System.out.println(sum);
    }
}