import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = 987654321;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                if (i != j) arr[i][j] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[a][b] = d;
        }

        // 플로이드 워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;

                    if (arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        // 최소 사이클의 도로길이 합 구하기
        int ans = INF;
        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                if(arr[i][j] != INF && arr[j][i] != INF)
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
            }
        }

        System.out.println(ans == INF ? -1 : ans);
    }
}