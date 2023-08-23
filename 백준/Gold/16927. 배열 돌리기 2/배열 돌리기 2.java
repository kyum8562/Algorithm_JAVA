import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] map;
    static StringTokenizer st;

    //    static class Node {
//        char type;
//        int node;
//        int dist;
//
//        public Node(char type, int node, int dist) {
//            this.type = type;
//            this.node = node;
//            this.dist = dist;
//        }
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int localRotation = Math.min(N, M) / 2;
        int n = N;
        int m = M;
        for (int i = 0; i < localRotation; i++) {
            rotationMap(n * 2 + m * 2 - 4, i);
            n -= 2;
            m -= 2;
        }

        printMap();
    }

    private static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                sb.append(map[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void rotationMap(int len, int k) {
        int rLen = R % len;

        while(rLen -- > 0) {
            int tmp = map[k][k];

            // 위쪽
            for (int i = k; i < M - 1 - k; i++)
                map[k][i] = map[k][i + 1];

            // 오른쪽
            for (int i = k; i < N - 1 - k; i++)
                map[i][M - 1 - k] = map[i + 1][M - 1 - k];

            // 아래쪽
            for (int i = M - 1 - k; i > k; i--)
                map[N - 1 - k][i] = map[N - 1 - k][i - 1];

            // 왼쪽
            for (int i = N - 1 - k; i > k; i--)
                map[i][k] = map[i - 1][k];

            map[k + 1][k] = tmp;

        }

    }
}