import java.io.*;
import java.util.*;
public class Main {
    static int R, C;
    static int[][] map;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i = 0 ; i < R ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j ++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 2*R*C + tmp() + tmp2();
        System.out.println(ans);
    }

    private static int tmp() {
        int mmC = 0;
        for(int c = 0 ; c < C ; c ++){
            int maxColSum = map[0][c] + map[R-1][c];
            for(int r = 0 ; r < R-1 ; r ++){
                if(map[r][c] == map[r+1][c]) continue;
                mmC += Math.abs(map[r][c] - map[r+1][c]);
            }
            mmC += maxColSum;
        }
        return mmC;
    }
    private static int tmp2() {
        int mmC = 0;
        for(int r = 0 ; r < R ; r ++){
            int maxColSum = map[r][0] + map[r][C-1];
            for(int c = 0 ; c < C-1 ; c ++){
                if(map[r][c] == map[r][c+1]) continue;
                mmC += Math.abs(map[r][c] - map[r][c+1]);
            }
            mmC += maxColSum;
        }
        return mmC;
    }
}