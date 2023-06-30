import java.io.*;
import java.util.*;

public class Main {
    static int N, K, minTime = 100002, count = 0;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[100001];

        if (N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }

        bfs();
        System.out.println(minTime + "\n" + count);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        map[N] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if(minTime < map[curr]) return;

            for (int d = 0; d < 3; d++) {
                int next = curr;

                if (d == 0) next *= 2;
                else if (d == 1) next += 1;
                else next -= 1;

                if (!isValid(next)) continue;

                if (next == K) {
                    minTime = map[curr];
                    count++;
                }

                if (map[next] == 0 || map[next] == map[curr] + 1) {
                    q.offer(next);
                    map[next] = map[curr] + 1;
                }
            }
        }
    }
    private static boolean isValid(int next) {
        return (next >= 0 && next <= 100000);
    }
}