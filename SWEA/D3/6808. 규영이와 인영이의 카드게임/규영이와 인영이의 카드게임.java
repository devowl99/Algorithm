import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer> gCard;
    static List<Integer> iCard;
    static List<Integer> iCardPerm;
    static boolean[] isSelected;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            gCard = new ArrayList<>();
            iCard = new ArrayList<>();
            iCardPerm = new ArrayList<>();
            while(st.hasMoreTokens()) {
                gCard.add(Integer.parseInt(st.nextToken()));
            }

            for (int i=1; i<=18; i++){
                if (!gCard.contains(i)) {
                    iCard.add(i);
                }
            }

            win = 0;
            lose = 0;
            isSelected = new boolean[iCard.size()];
            permutation(0);

            System.out.println("#" + test_case + " " + win + " " + lose);
        }
    }

    public static void permutation(int depth) {
        if (depth == 9) {
            game();
            return;
        }
        for (int i=0; i<9; i++){
            if (isSelected[i]) continue;

            iCardPerm.add(iCard.get(i));
            isSelected[i] = true;

            permutation(depth+1);

            iCardPerm.remove(iCardPerm.size()-1); // 리스트의 마지막 원소 삭제
            isSelected[i] = false;
        }
    }

    public static void game() {
        int gScore = 0;
        int iScore = 0;
        for (int i=0; i<9; i++) {
            if (gCard.get(i)>iCardPerm.get(i)) {
                gScore += (gCard.get(i) + iCardPerm.get(i));
            }
            else{
                iScore += (gCard.get(i) + iCardPerm.get(i));
            }
        }

        if (gScore > iScore) {
            win++;
        }
        else {
            lose++;
        }
    }
}