import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        v = new boolean[R][C];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < tmp; j++) {
                v[j][i] = true;
            }
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            int K = 0;
            int left = 0;
            int right = 0;
            int sum = 0;
            while (right < C) {
                if (v[i][right]) {
                    K++;
                    if (K == 1) {
                        left = right;
                    }
                }


                if (K == 2) {
                    sum += right - left - K + 1;
                    left = right;
                    K = 0;
                } else
                    right++;
            }
            ans += sum;
        }

        System.out.println(ans);
    }
}