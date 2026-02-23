import java.io.*;
import java.util.*;

public class Main {
    static long l, w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Long.parseLong(st.nextToken());
        w = Long.parseLong(st.nextToken());
        h = Long.parseLong(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        long[] cubes = new long[21];
        int maxI = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            cubes[a] = b;
            maxI = Math.max(maxI, a);
        }

        long filled = 0;
        long used = 0;

        long size = 1;
        for (int i = 0; i < maxI; i++) {
            size *= 2;
        }

        for (int i=maxI; i>=0; i--) {
            filled *= 8;
            long canFit = (l/size) * (w/size) * (h/size);

            long need = canFit - filled;
            if (need > 0) {
                long take = Math.min(need, cubes[i]);
                used += take;
                filled += take;
            }

            size /= 2;
        }

        if (filled == l*w*h)
            System.out.println(used);
        else
            System.out.println(-1);
    }
}