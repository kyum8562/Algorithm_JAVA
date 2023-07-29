import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<Node> list;
    static boolean[][] v;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int ans = 0;

        while (true) {
            boolean flag = true;
            v = new boolean[12][6];

            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        if (check(i, j) >= 4) {

                            flag = false;
                            pop(); // pop 해주기
                        }
                    }
                }
            }
            if (flag) break;
            gravity(); // 맵 내리기
            ans++;

        }
        System.out.println(ans);
    }

    private static void pop() {
        for (int i = 0; i < list.size(); i++) {
            Node curr = list.get(i);
            map[curr.r][curr.c] = '.';
        }
    }

    private static void gravity() {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static int check(int r, int c) {
        Queue<Node> q = new ArrayDeque<>();
        list = new ArrayList<>();

        list.add(new Node(r, c));
        q.offer(new Node(r, c));
        char target = map[r][c];
        v[r][c] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (isValid(nr, nc) && !v[nr][nc] && target == map[nr][nc]) {
                    v[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                    list.add(new Node(nr, nc));
                }
            }
        }
        return cnt;
    }

    private static boolean isValid(int r, int c) {
        return (r >= 0 && r < 12 && c >= 0 && c < 6);
    }
}