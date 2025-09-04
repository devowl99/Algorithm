import java.io.*;
import java.util.*;

public class Solution {
    static int T;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Atom> atomList;
    static long totalE;
    
    static final int SIZE = 2000;
    static final int SIZE2 = SIZE * 2 + 1;
    
    static class Atom {
        int x, y, dir, energy;
        
        Atom(int x, int y, int move, int energy){
            this.x = x;
            this.y = y;
            this.dir = move;
            this.energy = energy;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());
            atomList = new ArrayList<>();
            totalE = 0;
            
            for (int n=0; n<N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                
                atomList.add(new Atom(x*2, y*2, d, e));
            }
            simulate();
            sb.append('#').append(tc).append(' ').append(totalE).append('\n');            
        }
        System.out.println(sb);
    }
    
    static void simulate() {
        int count = 0;
        while (!atomList.isEmpty() && count < SIZE2) {
            Map<Long, List<Atom>> map = new HashMap<>();

            for (Atom a : atomList) {
                int nx = a.x + dx[a.dir];
                int ny = a.y + dy[a.dir];
                
                if (Math.abs(nx) > SIZE || Math.abs(ny) > SIZE) {
                    a.energy = -1;
                    continue;
                }
                a.x = nx; a.y = ny;

                long key = (((long)(nx + SIZE)) << 32) | (ny + SIZE);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(a);
            }

            List<Atom> next = new ArrayList<>();
            for (List<Atom> list : map.values()) {
                if (list.size() >= 2) {
                    int sum = 0;
                    for (Atom a : list) sum += a.energy;
                    totalE += sum;
                } else {
                    Atom a = list.get(0);
                    if (a.energy != -1) next.add(a);
                }
            }

            atomList = next;
            count++;
        }
    }
}