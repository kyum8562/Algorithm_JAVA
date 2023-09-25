import java.io.*;
import java.util.*;

public class Main {
    static int N, totalOutSand = 0;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int[] dd = {1, 1, 2, 2}; // 토네이도 각 방향으로 이동하는 횟수
    static int[][] dsr = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsc = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] sandRatio ={1, 1, 2, 7, 7, 2, 10, 10, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = calc(N/2, N/2);
        // 한 칸 이동 먼저

        // 결과 출력
        System.out.println(result);
    }

    private static int calc(int sr, int sc) {
        int totalOutSand = 0;

        int currR = sr;
        int currC = sc;

        while(true){
            for(int d = 0 ; d < 4 ; d ++){
                for(int m = 0 ; m < dd[d] ; m ++){
                    int nr = currR + dr[d];
                    int nc = currC + dc[d];

                    if(!isValid(nr, nc))
                        return totalOutSand;

                    int sand = map[nr][nc];
                    map[nr][nc] = 0;
                    int spreadTotal = 0;

                    for(int spread = 0 ; spread < 9 ; spread ++){
                        int sandR = nr + dsr[d][spread];
                        int sandC = nc + dsc[d][spread];
                        int spreadAmount = (sand * sandRatio[spread])/100;

                        if(isValid(sandR, sandC))
                            map[sandR][sandC] += spreadAmount;

                        else
                            totalOutSand += spreadAmount;

                        spreadTotal += spreadAmount;
                    }

                    int alphaR = nr + dr[d];
                    int alphaC = nc + dc[d];
                    int alphaAmount = sand - spreadTotal;

                    if(isValid(alphaR, alphaC))
                        map[alphaR][alphaC] += alphaAmount;

                    else
                        totalOutSand += alphaAmount;

                    currR = nr;
                    currC = nc;
                }
            }
            for(int idx = 0; idx < 4 ; idx ++)
                dd[idx] += 2;
        }
    }

    private static boolean isValid(int nr, int nc) {
        return(nr>=0 && nr<N && nc>=0 && nc<N);
    }
}