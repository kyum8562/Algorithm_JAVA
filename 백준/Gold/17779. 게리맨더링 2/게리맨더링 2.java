import java.io.*;
import java.util.*;

public class Main {
    static int N, sum, ans = Integer.MAX_VALUE;
    static int[] resArr;
    static int[][] map, check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // d1, d2 ≥ 1
        // 1 ≤ x < x+d1+d2 ≤ N
        // 1 ≤ y-d1 < y < y+d2 ≤ N
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                       if (x + d1 + d2 > N || 1 > y - d1 || y + d2 >= N) continue;
                        check = new int[N + 1][N + 1];
                        if (x == 2 && y == 5 && d1 == 3 && d2 == 2)
                            System.out.print("");
                        boolean res1 = lineCreate(x, y, d1, d2);
                        // 4라인 모두 만들어 졌을 때 -> 선거구 체크(선거구는 구역을 적어도 하나 포함해야 함)
                        if (res1) {
                            resArr = new int[5];
                            boolean res2 = segmentChecking(x, y, d1, d2);
                            if (res2)
                                cal();
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static void cal() {
        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1 ; j <= N ; j ++){
                int curr = check[i][j];
                if(curr == 9 || curr == 0){
                    resArr[4] += map[i][j];
                }
                else resArr[curr-1] += map[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 4; i++) {
            max = Math.max(max, resArr[i]);
            min = Math.min(min, resArr[i]);
        }

        ans = Math.min(ans, max - min);
    }

    private static boolean segmentChecking(int x, int y, int d1, int d2) {
        // 1번 지역구 체크
        boolean res1 = segChecking(1, 1, x + d1 - 1, y, 1);
        if (!res1) return false;

        // 2번 지역구 체크
        boolean res2 = segChecking(1, y + 1, x + d2, N, 2);
        if (!res2) return false;

        // 3번 지역구 체크
        boolean res3 = segChecking(x + d1, 1, N, y - d1 + d2 - 1, 3);
        if (!res3) return false;

        // 4번 지역구 체크
        boolean res4 = segChecking(x + d2 + 1, y - d1 + d2, N, N, 4);
        if (!res4) return false;

        // 5번 지역구 체크
        int resSum = 0;
        for (int i = 1; i <= N; i++) {
            int nineCnt = 0;
            int nineIdx = 0;
            for (int j = 1; j <= N; j++) {
                if (check[i][j] == 9) {
                    nineCnt++;
                    nineIdx = j;
                }
            }
            if (nineCnt == 1) {
                resSum ++;
            } else if (nineCnt == 2) {
                for (int j = nineIdx; j >= 1; j--) {
                    if(check[i][j] == 9) nineCnt--;
                    resSum ++;
                    check[i][j] = 9;
                    if(nineCnt == 0) break;
                }
            }
        }
        if (resSum == 0) return false;

        return true;
    }

    private static boolean segChecking(int sx, int sy, int ex, int ey, int mark) {
        sum = 0;

        for (int x = sx; x <= ex; x++) {
            for (int y = sy; y <= ey; y++) {
                if (!isValid(x, y)) return false;
                if (check[x][y] != 0) continue;
                check[x][y] = mark;
                sum += map[x][y];
            }
        }
        return true;
    }

    private static boolean lineCreate(int x, int y, int d1, int d2) {
        // 1번라인 설정
        boolean res1 = pmLine(x, y, x + d1, y - d1);
        if (!res1) return false;
        // 2번라인 설정
        boolean res2 = ppLine(x, y, x + d2, y + d2);
        if (!res2) return false;
        // 3번라인 설정
        boolean res3 = ppLine(x + d1, y - d1, x + d1 + d2, y - d1 + d2);
        if (!res3) return false;
        // 4번라인 설정
        boolean res4 = pmLine(x + d2, y + d2, x + d1 + d2, y + d2 - d1);
        if (!res4) return false;
        // 5번라인 설정
        boolean res5 = pmLine(x + d2, y + d2, x + d1 + d2, y + d2 - d1);
        if (!res5) return false;

        return true;
    }

    private static boolean pmLine(int sx, int sy, int ex, int ey) {
        int y = sy;
        for (int x = sx; x <= ex; x++) {
            // validation Check
            if (!isValid(x, y)) return false;

            check[x][y--] = 9;
            if (y == ey - 1) break;
        }
        return true;
    }

    private static boolean ppLine(int sx, int sy, int ex, int ey) {
        int y = sy;
        for (int x = sx; x <= ex; x++) {
            // validation Check
            if (!isValid(x, y)) return false;

            check[x][y++] = 9;
            if (y == ey + 1) break;
        }
        return true;
    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 1 && nx <= N && ny >= 1 && ny <= N;
    }

}