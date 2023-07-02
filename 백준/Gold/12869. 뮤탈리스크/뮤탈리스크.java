import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;
    static Queue<SCV> q;

    static class SCV {
        int s1;
        int s2;
        int s3;
        int cnt;

        SCV(int s1, int s2, int s3, int cnt) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[3];

        int maxIdx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map[i] = tmp;
        }

        bfs();

    }

    private static void bfs() {
        q = new ArrayDeque<>();
        boolean[][][] v = new boolean[61][61][61];
        int[][][] dp = new int[61][61][61];
        int[][] deal = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};

        v[0][0][0] = true;
        q.offer(new SCV(0, 0, 0, 0));
        // 큐에 넣은 수만큼 진행
        while (!q.isEmpty()) {
            SCV curr = q.poll();

            for(int d = 0 ; d < 6 ; d ++){
                int nextS1 = curr.s1 + deal[d][0];
                int nextS2 = curr.s2 + deal[d][1];
                int nextS3 = curr.s3 + deal[d][2];

                if(nextS1 >= 60) nextS1 = 60;
                if(nextS2 >= 60) nextS2 = 60;
                if(nextS3 >= 60) nextS3 = 60;

                if(v[nextS1][nextS2][nextS3]) continue;

                if(nextS1 >= map[0] && nextS2 >= map[1] && nextS3 >= map[2]) {
                    System.out.println(curr.cnt+1);
                    return;
                }
                v[nextS1][nextS2][nextS3] = true;
                q.add(new SCV(nextS1, nextS2, nextS3, curr.cnt+1));
            }
        }
    }
}