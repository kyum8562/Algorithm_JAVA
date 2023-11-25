import java.io.*;
import java.util.*;
public class Main {
    static int ans = 0;
    static int[][] map;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[101][101];

        int stage = 0;
        while(stage++ < 4){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            marking(r1, c1, r2, c2);
            ans += (r2-r1) * (c2-c1);
        }
        calculating();
        System.out.println(ans);
    }

    private static void calculating() {
        for(int i = 1 ; i <= 100 ; i ++){
            for(int j = 1 ; j <= 100 ; j ++){
                if(map[i][j] >= 2) ans -= map[i][j] - 1;
            }
        }
    }
    private static void marking(int r1, int c1, int r2, int c2) {
        for(int r = r1 ; r < r2 ; r ++){
            for(int c = c1 ; c < c2 ; c ++){
                map[r][c] ++;
            }
        }
    }
}