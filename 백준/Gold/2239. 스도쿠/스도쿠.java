import java.io.*;
import java.util.*;

public class Main {
    static boolean end = false;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        sudocu(0);
    }

    private static void sudocu(int depth) {
        if(depth == 81){
            print();
            end = true;
            return;
        }

        int r = depth / 9;
        int c = depth % 9;

        if(map[r][c] != 0) sudocu(depth + 1);
        else{
            for(int i = 1 ; i < 10 ; i ++){
                if(isValid(r, c, i)){
                    map[r][c] = i;
                    sudocu(depth + 1);
                    if(end) return;
                    map[r][c] = 0;
                }
            }
        }

    }
    private static boolean isValid(int r, int c, int n) {
        // 가로와 세로
        for (int i = 0; i < 9; i++)
            if (map[r][i] == n || map[i][c] == n) return false;

        // 네모
        int nr = r / 3 * 3;
        int nc = c / 3 * 3;
        for (int i = nr; i < nr + 3; i++) {
            for (int j = nc; j < nc + 3; j++) {
                if (map[i][j] == n) return false;
            }
        }
        return true;
    }
    private static void print(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}