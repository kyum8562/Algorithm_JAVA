import java.io.*;
import java.util.*;
public class Main {
    static int N, M, sr, sc, K;
    static int[][] map;
    static int[] dice;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 동쪽 이동 ->
        dice = new int[7];
        int bottom = 3;
        int currR = sr;
        int currC = sc;
        st = new StringTokenizer(br.readLine());
        while(K-- > 0){
            int d = Integer.parseInt(st.nextToken()) - 1;
            // 동쪽은 0, 서쪽은 1, 북쪽은 2, 남쪽은 3
            // 범위 내에 있는지
            int nr = currR + dr[d];
            int nc = currC + dc[d];
            if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
            if(d == 0){ // 동
                int tmp = dice[6];
                dice[6] = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[4];
                dice[4] = tmp;
            }
            else if(d == 1){ // 서
                int tmp = dice[6];
                dice[6] = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[2];
                dice[2] = tmp;
            }
            else if(d == 2){ // 북
                int tmp = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = dice[3];
                dice[3] = tmp;
            }
            else if(d == 3){ // 남
                int tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = tmp;
            }

            // 바닥과 비교
            if(map[nr][nc] == 0) map[nr][nc] = dice[6];
            else{
                dice[6] = map[nr][nc];
                map[nr][nc] = 0;
            }

            // 현재 위치 갱신
            currR = nr;
            currC = nc;

            // 출력
            System.out.println(dice[3]);
        }
    }
}