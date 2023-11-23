import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map = new int[101][101];
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            for(int r = r1 ; r <= r2 ; r ++){
                for(int c = c1 ; c <= c2 ; c ++) map[r][c]++;
            }
        }
        int res = 0;
        for(int r = 1 ; r <= 100 ; r ++){
            for(int c = 1 ; c <= 100 ; c ++)
                if(map[r][c] > M) res ++;
        }
        System.out.println(res);
    }
}