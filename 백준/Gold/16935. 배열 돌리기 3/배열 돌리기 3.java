import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, newN;
    static int[][] map, tmp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        newN = Math.max(N, M);
        map = new int[newN][newN];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int tcase = 1 ; tcase <= R ; tcase++) {
            int type = Integer.parseInt(st.nextToken());
            if(type == 1)
                type1(); // 상하반전
            else if(type == 2)
                type2(); // 좌우반전
            else if(type == 3)
                type3(); // 오른쪽90도회전
            else if(type == 4)
                type4(); // 왼쪽90도회전
            else if(type == 5)
                type5(); // 4그룹 이동(1->2, 2->3, 3->4, 4->1)
            else if(type == 6)
                type6(); // 4그룹 이동(5와 반대방향)
        }
        printMap();
    }

    private static void type1() {
        tmp = new int[newN][newN];

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                tmp[N-1-i][j] = map[i][j];
            }
        }

        map = tmp;
    }
    private static void type2() {
        tmp = new int[newN][newN];

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                tmp[i][M-1-j] = map[i][j];
            }
        }

        map = tmp;
    }
    private static void type3() {
        tmp = new int[newN][newN];

        for(int i = 0 ; i < M ; i ++){
            for(int j = 0 ; j < N ; j ++){
                tmp[i][j] = map[N-1-j][i];
            }
        }
        N^=M;
        M^=N;
        N^=M;
        map = tmp;
    }
    private static void type4() {
        tmp = new int[newN][newN];

        for(int i = 0 ; i < M ; i ++){
            for(int j = 0 ; j < N ; j ++){
                tmp[i][j] = map[j][M-1-i];
            }
        }
        N^=M;
        M^=N;
        N^=M;
        map = tmp;
    }
    private static void type5() {
        tmp = new int[newN][newN];
        // 1
        for(int i = 0 ; i < N/2 ; i ++){
            for(int j = 0 ; j < M/2 ; j ++){
                tmp[i][j+M/2] = map[i][j];
            }
        }
        // 2
        for(int i = 0 ; i < N/2 ; i ++){
            for(int j = M/2 ; j < M ; j ++){
                tmp[i+N/2][j] = map[i][j];
            }
        }
        // 3
        for(int i = N/2 ; i < N ; i ++){
            for(int j = M/2 ; j < M ; j ++){
                tmp[i][j-M/2] = map[i][j];
            }
        }
        // 4
        for(int i = N/2 ; i < N ; i ++){
            for(int j = 0 ; j < M/2 ; j ++){
                tmp[i-N/2][j] = map[i][j];
            }
        }
        map = tmp;
    }
    private static void type6() {
        tmp = new int[newN][newN];
        // 1->4
        for(int i = 0 ; i < N/2 ; i ++){
            for(int j = 0 ; j < M/2 ; j ++){
                tmp[i+N/2][j] = map[i][j];
            }
        }
        // 2->1
        for(int i = 0 ; i < N/2 ; i ++){
            for(int j = M/2 ; j < M ; j ++){
                tmp[i][j-M/2] = map[i][j];
            }
        }
        // 3->2
        for(int i = N/2 ; i < N ; i ++){
            for(int j = M/2 ; j < M ; j ++){
                tmp[i-N/2][j] = map[i][j];
            }
        }
        // 4->3
        for(int i = N/2 ; i < N ; i ++){
            for(int j = 0 ; j < M/2 ; j ++){
                tmp[i][j+M/2] = map[i][j];
            }
        }
        map = tmp;
    }

    private static void printMap() {
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}