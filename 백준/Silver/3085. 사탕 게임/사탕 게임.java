import java.io.*;
import java.util.*;

public class Main {
    static int N, max = 1, ans = 1;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0 ; i < N ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j ++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i = 0 ; i < N ; i ++)
            game(i, 0); // 가로
        for(int j = 0 ; j < N ; j ++)
            game(j, 1); // 세로
        ans = Math.max(ans, max);


        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < N ; j ++){
                char curr = map[i][j];
                max = 1;
                for(int d = 0 ; d < 4 ; d ++){

                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if(nr<0 || nr>N-1 || nc<0 || nc>N-1 || curr == map[nr][nc]) continue;

                    // 교체
                    char tmp = curr;
                    char tmp2 = map[nr][nc];
                    map[i][j] = tmp2;
                    map[nr][nc] = tmp;

                    game(i, 0); // 가로
                    game(nr, 0); // 가로
                    game(j, 1); // 세로
                    game(nc, 1); // 세로

                    map[i][j] = tmp;
                    map[nr][nc] = tmp2;
                }
                ans = Math.max(ans, max);

                if(ans == N){
                    System.out.println(N);
                    return;
                }
            }
        }
        System.out.println(ans);
    }

    private static void game(int i, int type) {
        int cnt = 1;
        if(type == 0){
            for(int k = 0 ; k < N-1 ; k ++){
                if(map[i][k] == map[i][k+1]){
                    cnt ++;
                    max = Math.max(max, cnt);
                }
                else cnt = 1;
            }
        }
        else{
            for(int k = 0 ; k < N-1 ; k ++){
                if(map[k][i] == map[k+1][i]){
                    cnt ++;
                    max = Math.max(max, cnt);
                }
                else cnt = 1;
            }
        }
    }
}